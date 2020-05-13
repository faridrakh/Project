package com.brs.project.financial.account.dao;

import com.brs.project.financial.account.entity.Account;
import com.sytan.base.lib.ApplicationException;

import java.util.Map;

public interface AccountDAO {
    void addAccount(Account account) throws ApplicationException;
    void updateAccount(Account account) throws ApplicationException;
    Account getAccount(String uid) throws ApplicationException;
    Account getAccount(String uid, String accountId) throws ApplicationException;
    Map<String,Object> getAccountList(String userId, Integer page) throws ApplicationException;
}
