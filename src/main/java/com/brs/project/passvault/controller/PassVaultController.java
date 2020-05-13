package com.brs.project.passvault.controller;

import com.brs.project.common.controller.BaseController;
import com.brs.project.common.helper.CommonConstants;
import com.brs.project.common.model.RequestModel;
import com.brs.project.common.model.ResponseModel;
import com.brs.project.passvault.entity.PassVault;
import com.brs.project.passvault.service.PassVaultService;
import com.sytan.base.lib.ApplicationException;
import com.sytan.base.lib.ObjectCopier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sl/passvlt")
public class PassVaultController extends BaseController {
    private static final Logger logger = LogManager.getLogger(PassVaultController.class);
    private PassVaultService passVaultService;

    public PassVaultController(PassVaultService passVaultService){
        this.passVaultService = passVaultService;
    }

    @RequestMapping(value = "/doInsertPasswordApi", method = RequestMethod.POST)
    public ResponseEntity<?> doInsertPasswordApi(@RequestBody RequestModel request) throws ApplicationException {
        ResponseModel response = new ResponseModel();
        PassVault passVault = new PassVault();
        copy.objectCopyValue(request,passVault);
        passVault = passVaultService.insertPassword(passVault);
        response.setPassVault(passVault);
        response.setErrorCode(CommonConstants.SUCCESS_CODE);
        response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doUpdatePasswordApi", method = RequestMethod.POST)
    public ResponseEntity<?> doUpdatePasswordApi(@RequestBody RequestModel request) throws ApplicationException {
        ResponseModel response = new ResponseModel();
        PassVault passVault = new PassVault();
        copy.objectCopyValue(request,passVault);
        String result = passVaultService.updatePassword(passVault);
        if(CommonConstants.SUCCESS_DESCP.equals(result)) {
            response.setErrorCode(CommonConstants.SUCCESS_CODE);
            response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        }
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doDeletePasswordApi", method = RequestMethod.POST)
    public ResponseEntity<?> doDeletePasswordApi(@RequestBody RequestModel request) throws ApplicationException {
        ResponseModel response = new ResponseModel();
        PassVault passVault = new PassVault();
        copy.objectCopyValue(request,passVault);
        String result = passVaultService.updatePassword(passVault);
        if(CommonConstants.SUCCESS_DESCP.equals(result)) {
            response.setErrorCode(CommonConstants.SUCCESS_CODE);
            response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        }
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doGetPasswordListApi", method = RequestMethod.POST)
    public ResponseEntity<?> doGetPasswordListApi(@RequestBody RequestModel request) throws ApplicationException {
        Map<String,Object> result = new LinkedHashMap<>();
        PassVault passVault = new PassVault();
        copy.objectCopyValue(request,passVault);
        result.put("errorCode", CommonConstants.SUCCESS_CODE);
        result.put("errorDescription", CommonConstants.SUCCESS_DESCP);
        result.put("tokenId", dataContainer.getTokenId());
        result.putAll(passVaultService.getListPassword(passVault.getUsrId(),request.getPage()));
        if(((List<PassVault>)result.get("passVaultList")).size() < 0) {
            //result.put("passVaultList",new ArrayList<>());
            result.put("errorCode", CommonConstants.NODATA_CODE);
            result.put("errorDescription", CommonConstants.NODATA_DESCP);
        }
        return ResponseEntity.ok().body(result);
    }
}
