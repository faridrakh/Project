package com.brs.project.financial.transaction.controller;

import com.brs.project.common.controller.BaseController;
import com.brs.project.common.helper.CommonConstants;
import com.brs.project.common.model.RequestModel;
import com.brs.project.common.model.ResponseModel;
import com.brs.project.financial.transaction.entity.Transaction;
import com.brs.project.financial.transaction.service.TransactionService;
import com.sytan.base.lib.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sl/transaction")
public class TransactionController extends BaseController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/doAddTransactionApi", method = RequestMethod.POST)
    public ResponseEntity<?> doAddTransactionApi(@RequestBody RequestModel request) throws ApplicationException {
        ResponseModel response = new ResponseModel();
        Transaction transaction = new Transaction();
        copy.objectCopyValue(request,transaction);
        transactionService.processInsertTrxn(transaction);
        response.setTransaction(transaction);
        response.setErrorCode(CommonConstants.SUCCESS_CODE);
        response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doUpdateTransactionApi", method = RequestMethod.POST)
    public ResponseEntity<?> doUpdateTransactionApi(@RequestBody RequestModel request) throws ApplicationException {
        ResponseModel response = new ResponseModel();
        Transaction transaction = new Transaction();
        copy.objectCopyValue(request,transaction);
        transactionService.processUpdateTrxn(transaction);
        response.setTransaction(transaction);
        response.setErrorCode(CommonConstants.SUCCESS_CODE);
        response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doGetTransactionDetailApi", method = RequestMethod.POST)
    public ResponseEntity<?> doGetTransactionDetailApi(@RequestBody RequestModel request) throws ApplicationException {
        ResponseModel response = new ResponseModel();
        Transaction transaction = new Transaction();
        copy.objectCopyValue(request,transaction);
        transaction = transactionService.processGetTrxn(transaction.getId());
        if(null != transaction) {
            response.setTransaction(transaction);
        }
        response.setErrorCode(CommonConstants.SUCCESS_CODE);
        response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doGetTransactionListApi", method = RequestMethod.POST)
    public ResponseEntity<?> doGetTransactionListApi(@RequestBody RequestModel request) throws ApplicationException {
        Map<String,Object> result = new LinkedHashMap<>();
        Transaction transaction = new Transaction();
        copy.objectCopyValue(request,transaction);
        result.put("errorCode", CommonConstants.SUCCESS_CODE);
        result.put("errorDescription", CommonConstants.SUCCESS_DESCP);
        result.put("tokenId", dataContainer.getTokenId());
        result.putAll(transactionService.processGetTrxnList(transaction.getUsrId(),request.getPage()));
        if(((List<Transaction>)result.get("transactionList")).size() < 0) {
            result.put("errorCode", CommonConstants.NODATA_CODE);
            result.put("errorDescription", CommonConstants.NODATA_DESCP);
        }
        return ResponseEntity.ok().body(result);
    }
}
