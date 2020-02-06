package com.brs.project.common.model;

import com.brs.project.usergrp.entity.UserGroup;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestModel {
    private String id;
    private String userName;
    private String email;
    private String password;
    private String fullName;
    private String usrId;
    private String location;
    private UserGroup userGroup;
}
