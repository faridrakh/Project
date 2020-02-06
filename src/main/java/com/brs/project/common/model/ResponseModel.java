package com.brs.project.common.model;

import com.brs.project.maintenance.entity.UserGroupMtn;
import com.brs.project.passvault.entity.PassVault;
import com.brs.project.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {
    private String errorCode;
    private String errorDescription;
    private String tokenId;
//    private String id;
//    private String userName;
//    private String email;
//    private String password;
//    private String fullName;
//    private String createDate;
//    private String usrId;
//    private String location;
    private User user;
    private PassVault passVault;
    private List<User> userList;
    private List<UserGroupMtn> userGroupMtnList;
    private List<PassVault> passVaultList;
}
