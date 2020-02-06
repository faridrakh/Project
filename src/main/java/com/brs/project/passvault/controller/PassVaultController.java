package com.brs.project.passvault.controller;

import com.brs.project.common.controller.BaseController;
import com.brs.project.common.helper.CommonConstants;
import com.brs.project.common.model.RequestModel;
import com.brs.project.common.model.ResponseModel;
import com.brs.project.passvault.entity.PassVault;
import com.brs.project.passvault.service.PassVaultService;
import com.sytan.base.lib.ObjectCopier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sl/passvlt")
public class PassVaultController extends BaseController {
    private static final Logger logger = LogManager.getLogger(PassVaultController.class);
    private PassVaultService passVaultService;

    public PassVaultController(PassVaultService passVaultService){
        this.passVaultService = passVaultService;
    }

    @RequestMapping(value = "/doInsertPasswordApi", method = RequestMethod.POST)
    public ResponseEntity<?> doInsertPasswordApi(@RequestBody RequestModel request) {
        ResponseModel response = new ResponseModel();
        PassVault passVault = new PassVault();
        ObjectCopier copy = new ObjectCopier();
        copy.objectCopyValue(request,passVault);
        passVault = passVaultService.insertPassword(passVault);
        response.setPassVault(passVault);
        response.setErrorCode(CommonConstants.SUCCESS_CODE);
        response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doUpdatePasswordApi", method = RequestMethod.POST)
    public ResponseEntity<?> doUpdatePasswordApi(@RequestBody RequestModel request) {
        ResponseModel response = new ResponseModel();
        PassVault passVault = new PassVault();
        ObjectCopier copy = new ObjectCopier();
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
    public ResponseEntity<?> doGetPasswordListApi(@RequestBody RequestModel request) {
        ResponseModel response = new ResponseModel();
        PassVault passVault = new PassVault();
        ObjectCopier copy = new ObjectCopier();
        copy.objectCopyValue(request,passVault);
        List<PassVault> result = passVaultService.getListPassword(passVault.getUsrId());
        if(result.size() > 0) {
            response.setErrorCode(CommonConstants.SUCCESS_CODE);
            response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
            response.setPassVaultList(result);
        }
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }
}
