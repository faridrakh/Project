package com.brs.project.financial.transaction.service;

import com.brs.project.financial.transaction.entity.Transaction;
import com.sytan.base.lib.ApplicationException;

import java.util.Map;

public interface TransactionService {
    void processInsertTrxn(Transaction trxn) throws ApplicationException;
    void processUpdateTrxn(Transaction trxn) throws ApplicationException;
    Transaction processGetTrxn(String id) throws ApplicationException;
    Map<String,Object> processGetTrxnList(String userId, Integer page) throws ApplicationException;
}
