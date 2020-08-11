package com.brs.project.common.model;

import com.brs.project.category.entity.Category;
import com.brs.project.usergrp.entity.UserGroup;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

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
    private Integer page;
    private Date dtCreate;
    private String createBy;
    private Date dtUpdate;
    private String updateBy;
    private String categoryName;
    private String type;
    private String code;
    private String description;
    private BigDecimal amount;
    private String action;
    private String accountId;
    private String categoryId;
    private String channel;
    private String ipAddress;
}
