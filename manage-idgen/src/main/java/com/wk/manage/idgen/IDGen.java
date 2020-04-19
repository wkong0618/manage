package com.wk.manage.idgen;


import com.wk.manage.idgen.common.Result;

public interface IDGen {
    Result get(String key);
    boolean init();
}
