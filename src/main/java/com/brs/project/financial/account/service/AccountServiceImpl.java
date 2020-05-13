package com.brs.project.financial.account.service;

import com.brs.project.common.helper.CommonUtils;
import com.brs.project.financial.account.dao.AccountDAO;
import com.brs.project.financial.account.entity.Account;
import com.sytan.base.lib.ApplicationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;
    private final CommonUtils commonUtils  = new CommonUtils();

    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
    @Override
    public void processAddAccount(Account account) throws ApplicationException {
        String uid = commonUtils.generateUUID();
        account.setId(uid);
        account.setCreateBy(account.getUsrId());
        account.setDtCreate(commonUtils.generateDate());
        accountDAO.addAccount(account);
    }

    @Override
    public void processUpdateAccount(Account account) throws ApplicationException {
        Account tmp = accountDAO.getAccount(account.getId());
        account.setCreateBy(tmp.getCreateBy());
        account.setDtCreate(tmp.getDtCreate());
        account.setUpdateBy(account.getUsrId());
        account.setDtUpdate(commonUtils.generateDate());
        accountDAO.updateAccount(account);
    }

    @Override
    public Account processGetAccount(String uid, String aid) throws ApplicationException {
        return accountDAO.getAccount(uid, aid);
    }

    @Override
    public Map<String, Object> processGetAccountList(String userId, Integer page) throws ApplicationException {
        return accountDAO.getAccountList(userId, page);
    }
}
