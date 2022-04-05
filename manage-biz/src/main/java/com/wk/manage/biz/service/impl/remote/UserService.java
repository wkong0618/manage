package com.wk.manage.biz.service.impl.remote;

import com.wk.manage.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JobService jobService;

    @Transactional
    public void addUser(){
        userMapper.ageAdd(1, 1);
        new Thread(()->{
            jobService.addJob();
        }).start();
    }
}
