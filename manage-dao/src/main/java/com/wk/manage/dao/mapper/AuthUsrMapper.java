package com.wk.manage.dao.mapper;

import com.wk.manage.dao.entity.AuthUsr;
import org.springframework.stereotype.Repository;

/**
 * AuthUsrMapper继承基类
 */
@Repository
public interface AuthUsrMapper extends MyBatisBaseDao<AuthUsr, String> {
}