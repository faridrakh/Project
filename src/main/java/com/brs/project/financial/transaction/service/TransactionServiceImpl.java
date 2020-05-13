package com.brs.project.financial.transaction.service;

import com.brs.project.category.dao.CategoryDAO;
import com.brs.project.category.entity.Category;
import com.brs.project.common.helper.CommonUtils;
import com.brs.project.financial.account.dao.AccountDAO;
import com.brs.project.financial.account.entity.Account;
import com.brs.project.financial.transaction.dao.TransactionDAO;
import com.brs.project.financial.transaction.entity.Transaction;
import com.sytan.base.lib.ApplicationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Map;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    private TransactionDAO transactionDAO;
    private AccountDAO accountDAO;
    private CategoryDAO categoryDAO;
    private final CommonUtils commonUtils  = new CommonUtils();

    public TransactionServiceImpl(TransactionDAO transactionDAO, AccountDAO accountDAO, CategoryDAO categoryDAO) {
        this.transactionDAO = transactionDAO;
        this.accountDAO = accountDAO;
        this.categoryDAO = categoryDAO;
    }

    @Override
    public void processInsertTrxn(Transaction trxn) throws ApplicationException {
        Account account;
        String uid = commonUtils.generateUUID();
        trxn.setId(uid);
        trxn.setCreateBy(trxn.getUsrId());
        trxn.setDtCreate(commonUtils.generateDate());
        account = accountDAO.getAccount(trxn.getAccountId());
        BigDecimal total;
        if("INCOME".equals(trxn.getAction())) {
            total = account.getAmount().add(trxn.getAmount());
            trxn.setAction("0");
        } else {
            total = account.getAmount().subtract(trxn.getAmount());
            trxn.setAction("1");
        }
        account.setAmount(total);
        account.setUpdateBy(trxn.getUsrId());
        account.setDtUpdate(commonUtils.generateDate());
        accountDAO.updateAccount(account);
        transactionDAO.insertTrxn(trxn);
    }

    @Override
    public void processUpdateTrxn(Transaction trxn) throws ApplicationException {
        Account account;
        trxn.setUpdateBy(trxn.getUsrId());
        trxn.setDtUpdate(commonUtils.generateDate());
        Transaction tmp = processGetTrxn(trxn.getId());
        account = accountDAO.getAccount(trxn.getAccountId());
        BigDecimal total;
        trxn.setDtCreate(tmp.getDtCreate());
        trxn.setCreateBy(tmp.getCreateBy());
        if("INCOME".equals(trxn.getAction()))
            total = (account.getAmount().subtract(tmp.getAmount())).add(trxn.getAmount());
        else
            total = (account.getAmount().add(tmp.getAmount())).subtract(trxn.getAmount());
        account.setAmount(total);
        account.setUpdateBy(trxn.getUsrId());
        account.setDtUpdate(commonUtils.generateDate());
        accountDAO.updateAccount(account);
        transactionDAO.updateTrxn(trxn);
    }

    @Override
    public Transaction processGetTrxn(String id) throws ApplicationException {
        return transactionDAO.getTrxn(id);
    }

    @Override
    public Map<String, Object> processGetTrxnList(String userId, Integer page) throws ApplicationException {
        return transactionDAO.getTrxnList(userId,page);
    }
}
