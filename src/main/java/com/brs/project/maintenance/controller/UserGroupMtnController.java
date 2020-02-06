package com.brs.project.maintenance.controller;

import com.brs.project.common.controller.BaseController;
import com.brs.project.common.helper.CommonConstants;
import com.brs.project.common.model.ResponseModel;
import com.brs.project.maintenance.entity.UserGroupMtn;
import com.brs.project.maintenance.service.UserGroupMtnService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sl/userGroupMtn")
public class UserGroupMtnController extends BaseController {
    private static final Logger logger = LogManager.getLogger(UserGroupMtnController.class);

    private UserGroupMtnService userGroupMtnService;

    public UserGroupMtnController(UserGroupMtnService userGroupMtnService){
        this.userGroupMtnService = userGroupMtnService;
    }

    @RequestMapping(value = "/doGetUserGroupListApi", method = RequestMethod.POST)
    public ResponseEntity<?> doGetUserGroupListRsApi() {
        ResponseModel response = new ResponseModel();
        List<UserGroupMtn> list = userGroupMtnService.getUserGroupMtnList();
        response.setUserGroupMtnList(list);
        response.setErrorCode(CommonConstants.SUCCESS_CODE);
        response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        return ResponseEntity.ok().body(response);
    }
}
