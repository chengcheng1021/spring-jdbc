package com.cc1021.factory;

import com.cc1021.service.IAccountService;
import com.cc1021.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
