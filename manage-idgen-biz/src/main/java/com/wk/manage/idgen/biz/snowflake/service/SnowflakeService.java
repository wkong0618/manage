package com.wk.manage.idgen.biz.snowflake.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wk.manage.idgen.biz.snowflake.SnowflakeIDGenImpl;
import com.wk.manage.idgen.biz.snowflake.common.Constants;
import com.wk.manage.idgen.biz.snowflake.common.PropertyFactory;
import com.wk.manage.idgen.biz.snowflake.exception.InitException;
import com.wk.manage.idgen.biz.snowflake.exception.LeafServerException;
import com.wk.manage.idgen.biz.snowflake.exception.NoKeyException;
import com.wk.manage.idgen.IDGen;
import com.wk.manage.idgen.RpcIdGen;
import com.wk.manage.idgen.common.Result;
import com.wk.manage.idgen.common.Status;
import com.wk.manage.idgen.common.ZeroIDGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Service(group = "SnowflakeService")
@Component
public class SnowflakeService implements RpcIdGen {
    private Logger logger = LoggerFactory.getLogger(SnowflakeService.class);

    private IDGen idGen;

    public SnowflakeService() throws InitException {
        Properties properties = PropertyFactory.getProperties();
        boolean flag = Boolean.parseBoolean(properties.getProperty(Constants.LEAF_SNOWFLAKE_ENABLE, "true"));
        if (flag) {
            String zkAddress = properties.getProperty(Constants.LEAF_SNOWFLAKE_ZK_ADDRESS);
            int port = Integer.parseInt(properties.getProperty(Constants.LEAF_SNOWFLAKE_PORT));
            idGen = new SnowflakeIDGenImpl(zkAddress, port);
            if(idGen.init()) {
                logger.info("Snowflake Service Init Successfully");
            } else {
                throw new InitException("Snowflake Service Init Fail");
            }
        } else {
            idGen = new ZeroIDGen();
            logger.info("Zero ID Gen Service Init Successfully");
        }
    }

    public Result getId(String key) {
        return idGen.get(key);
    }

    @Override
    public String get(String key) {
        return get(key, getId(key));
    }

    private String get(String key, Result id) {
        Result result;
        if (key == null || key.isEmpty()) {
            throw new NoKeyException();
        }
        result = id;
        if (result.getStatus().equals(Status.EXCEPTION)) {
            throw new LeafServerException(result.toString());
        }
        return String.valueOf(result.getId());
    }
}
