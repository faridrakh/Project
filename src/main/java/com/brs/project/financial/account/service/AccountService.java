package com.brs.project.financial.account.service;

import com.brs.project.financial.account.entity.Account;
import com.sytan.base.lib.ApplicationException;

import java.util.Map;

public interface AccountService {
    void processAddAccount(Account account) throws ApplicationException;
    void processUpdateAccount(Account account) throws ApplicationException;
    Account processGetAccount(String uid, String aid) throws ApplicationException;
    Map<String,Object> processGetAccountList(String userId, Integer page) throws ApplicationException;
}
