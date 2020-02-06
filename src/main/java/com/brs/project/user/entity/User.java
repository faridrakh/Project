package com.brs.project.user.entity;

import com.brs.project.usergrp.entity.UserGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_USR")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class User {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "DT_CREATE")
    private Date dtCreate;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "DT_UPDATE")
    private Date dtUpdate;

    @Column(name = "UPDATE_BY")
    private String updateBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="USR_GRP_ID")
    private UserGroup userGroup;
}
