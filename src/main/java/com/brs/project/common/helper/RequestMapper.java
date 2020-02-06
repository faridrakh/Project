package com.brs.project.common.helper;

import com.brs.project.common.model.RequestModel;
import com.brs.project.common.model.ResponseModel;
import com.brs.project.passvault.entity.PassVault;
import com.brs.project.user.entity.User;

public class RequestMapper<T> {
    public T convertRequestToModel(RequestModel model, String modelName){
        Object obj = null;
        if("USER".equals(modelName)){
            User user = new User();
            user.setId(model.getId());
            user.setUserName(model.getUserName());
            user.setEmail(model.getEmail());
            user.setPassword(model.getPassword());
            user.setFullName(model.getFullName());
            obj = user;
        } else if("PASSVLT".equals(modelName)){
            PassVault passVault = new PassVault();
            passVault.setId(model.getId());
            passVault.setUsrId(model.getUsrId());
            passVault.setUserName(model.getUserName());
            passVault.setPassword(model.getPassword());
            passVault.setLocation(model.getLocation());
            obj = passVault;
        }
        return (T) obj;
    }

//    public ResponseModel convertModelToResponse(Object model, String modelName){
//        ResponseModel res = new ResponseModel();
//        if("USER".equals(modelName)){
//            User user = (User) model;
//            res.setId(user.getId());
//            res.setUserName(user.getUserName());
//            res.setEmail(user.getEmail());
//            res.setPassword(user.getPassword());
//            res.setFullName(user.getFullName());
//        } else if("PASSVLT".equals(modelName)){
//            PassVault passVault = (PassVault) model;
//            res.setId(passVault.getId());
//            res.setUsrId(passVault.getUsrId());
//            res.setUserName(passVault.getUserName());
//            res.setPassword(passVault.getPassword());
//            res.setLocation(passVault.getLocation());
//        }
//        return res;
//    }
}
