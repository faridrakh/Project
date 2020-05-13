package com.brs.project.user.controller;

import com.brs.project.common.controller.BaseController;
import com.brs.project.common.helper.CommonConstants;
import com.brs.project.common.helper.CommonUtils;
import com.brs.project.common.helper.RequestMapper;
import com.brs.project.common.model.RequestModel;
import com.brs.project.common.model.ResponseModel;
import com.brs.project.user.entity.User;
import com.brs.project.user.service.UserService;
import com.sytan.base.lib.ApplicationException;
import com.sytan.base.lib.ObjectCopier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/sl/user")
public class UserController extends BaseController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/doAddUserApi", method = RequestMethod.POST)
    public ResponseEntity<?> doAddUserApi(@RequestBody RequestModel request) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ApplicationException {
        ResponseModel response = new ResponseModel();
        User user = new User();
        copy.objectCopyValue(request,user);
        user = userService.addUser(user);
        response.setUser(user);
        response.setErrorCode(CommonConstants.SUCCESS_CODE);
        response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doUpdateUserApi", method = RequestMethod.POST)
    public ResponseEntity<?> doUpdateUserApi(@RequestBody RequestModel request) {
        ResponseModel response = new ResponseModel();
        User user = new User();
        copy.objectCopyValue(request,user);
        String result = userService.updateUser(user);
        if(CommonConstants.SUCCESS_DESCP.equals(result)){
            response.setErrorCode(CommonConstants.SUCCESS_CODE);
            response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        }
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

//    @RequestMapping(value = "/doDeleteUserApi", method = RequestMethod.POST)
//    public ResponseEntity<?> doDeleteUserApi(@RequestBody RequestModel request) {
//        ResponseModel response = new ResponseModel();
//        RequestMapper<User> mapper = new RequestMapper<>();
//        User user = mapper.convertRequestToModel(request,"USER");
//        String result = userService.deleteUser(user.getId());
//        if(CommonConstants.SUCCESS_DESCP.equals(result)){
//            response.setErrorCode(CommonConstants.SUCCESS_CODE);
//            response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
//        }
//        response.setTokenId(dataContainer.getTokenId());
//        return ResponseEntity.ok().body(response);
//    }

    @RequestMapping(value = "/doGetUserDetailApi", method = RequestMethod.POST)
    public ResponseEntity<?> doGetUserDetailApi(@RequestBody RequestModel request) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ResponseModel response = new ResponseModel();
        User user = new User();
        copy.objectCopyValue(request,user);
        if(!dataContainer.getUserId().equals(user.getId())){
            //throw new Exception("Unauthorized");
        }
        user = userService.getUser(user.getId());
        if(null != user) {
            response.setUser(user);
        }
        response.setErrorCode(CommonConstants.SUCCESS_CODE);
        response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doCheckUserName", method = RequestMethod.POST)
    public ResponseEntity<?> doCheckUserName(@RequestBody RequestModel request) {
        ResponseModel response = new ResponseModel();
        User user = new User();
        copy.objectCopyValue(request,user);
        user = userService.getUserByUserName(user.getUserName());
        if(null != user) {
            response.setErrorCode(CommonConstants.EXIST_USER_CODE);
            response.setErrorDescription(CommonConstants.EXIST_USER_DESCP);
        } else {
            response.setErrorCode(CommonConstants.SUCCESS_CODE);
            response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        }
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doCheckUserEmail", method = RequestMethod.POST)
    public ResponseEntity<?> doCheckUserEmail(@RequestBody RequestModel request) {
        ResponseModel response = new ResponseModel();
        User user = new User();
        copy.objectCopyValue(request,user);
        user = userService.getUserByEmail(user.getEmail());
        if(null != user) {
            response.setErrorCode(CommonConstants.EXIST_EMAIL_CODE);
            response.setErrorDescription(CommonConstants.EXIST_EMAIL_DESCP);
        } else {
            response.setErrorCode(CommonConstants.SUCCESS_CODE);
            response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        }
        response.setTokenId(dataContainer.getTokenId());
        return ResponseEntity.ok().body(response);
    }

}
