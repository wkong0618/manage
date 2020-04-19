package com.wk.manage.biz.service.impl.remote;

import com.alibaba.dubbo.config.annotation.Service;
import com.wk.manage.biz.service.DemoService;
import com.wk.manage.remote.model.param.ManageParam;
import com.wk.manage.remote.model.result.ManageDTO;
import com.wk.manage.remote.service.RpcManageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 描述:
 * 接口测试
 *
 * @author wukong
 * @create 2020-03-08 下午9:54
 */
@Service
public class RpcManageServiceImpl implements RpcManageService{
    @Autowired
    private DemoService demoService;


    @Override
    public ManageDTO test(ManageParam param) {
        ManageDTO demo = new ManageDTO();
        demo.setStr(demoService.test());
        return demo;
    }
}
