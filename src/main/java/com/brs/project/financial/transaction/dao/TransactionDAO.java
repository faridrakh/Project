package com.brs.project.financial.transaction.dao;

import com.brs.project.financial.transaction.entity.Transaction;
import com.sytan.base.lib.ApplicationException;

import java.util.Map;

public interface TransactionDAO {
    void insertTrxn(Transaction trxn) throws ApplicationException;
    void updateTrxn(Transaction trxn) throws ApplicationException;
    Transaction getTrxn(String id) throws ApplicationException;
    Map<String,Object> getTrxnList(String userId, Integer page) throws ApplicationException;
}
