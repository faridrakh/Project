package com.brs.project.financial.account.controller;

import com.brs.project.common.controller.BaseController;
import com.brs.project.common.helper.CommonConstants;
import com.brs.project.common.model.RequestModel;
import com.brs.project.common.model.ResponseModel;
import com.brs.project.financial.account.entity.Account;
import com.brs.project.financial.account.service.AccountService;
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
@RequestMapping("/sl/account")
public class AccountController extends BaseController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/doAddAccountApi", method = RequestMethod.POST)
    public ResponseEntity<?> doAddAccountApi(@RequestBody RequestModel request) throws ApplicationException {
        ResponseModel response = new ResponseModel();
        Account account = new Account();
        copy.objectCopyValue(request,account);
        accountService.processAddAccount(account);
        response.setAccount(account);
        response.setErrorCode(CommonConstants.SUCCESS_CODE);
        response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doUpdateAccountApi", method = RequestMethod.POST)
    public ResponseEntity<?> doUpdateAccountApi(@RequestBody RequestModel request) throws ApplicationException {
        ResponseModel response = new ResponseModel();
        Account account = new Account();
        copy.objectCopyValue(request,account);
        accountService.processUpdateAccount(account);
        response.setAccount(account);
        response.setErrorCode(CommonConstants.SUCCESS_CODE);
        response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doGetAccountDetailApi", method = RequestMethod.POST)
    public ResponseEntity<?> doGetAccountDetailApi(@RequestBody RequestModel request) throws ApplicationException {
        ResponseModel response = new ResponseModel();
        Account account = new Account();
        copy.objectCopyValue(request,account);
        account = accountService.processGetAccount(account.getUsrId(),account.getId());
        if(null != account) {
            response.setAccount(account);
        }
        response.setErrorCode(CommonConstants.SUCCESS_CODE);
        response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doGetAccountListApi", method = RequestMethod.POST)
    public ResponseEntity<?> doGetAccountListApi(@RequestBody RequestModel request) throws ApplicationException {
        Map<String,Object> result = new LinkedHashMap<>();
        Account account = new Account();
        copy.objectCopyValue(request,account);
        result.put("errorCode", CommonConstants.SUCCESS_CODE);
        result.put("errorDescription", CommonConstants.SUCCESS_DESCP);
        result.put("tokenId", dataContainer.getTokenId());
        result.putAll(accountService.processGetAccountList(account.getUsrId(),request.getPage()));
        if(((List<Account>)result.get("accountList")).size() < 0) {
            result.put("errorCode", CommonConstants.NODATA_CODE);
            result.put("errorDescription", CommonConstants.NODATA_DESCP);
        }
        return ResponseEntity.ok().body(result);
    }
}
