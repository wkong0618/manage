package com.wk.manage.remote.service;

import com.wk.manage.remote.model.param.ManageParam;
import com.wk.manage.remote.model.result.ManageDTO;

public interface RpcManageService {

    /**
     * dubbo 接口测试
     * @param param
     * @return
     */
    ManageDTO test(ManageParam param);
}
