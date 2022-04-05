package com.wk.manage.biz.service.impl.remote;

import com.wk.manage.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void addJob(){
        userMapper.ageAdd1(1, 1);
    }
}
