package com.wk.manage.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int ageAdd(@Param("id") long id, @Param("add") int add);
    int ageAdd1(@Param("id") long id, @Param("add") int add);
}
