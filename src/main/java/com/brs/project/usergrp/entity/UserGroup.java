package com.brs.project.usergrp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "T_USR_GRP")
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroup {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "MT_GRP_ID")
    private String mtGrpId;

    private String role;
    private String roleName;


//    @OneToOne
//    @JoinColumn(name="MT_GRP_ID", insertable = false, updatable = false)
//    private UserGroupMtn userGroupMtn;
}
