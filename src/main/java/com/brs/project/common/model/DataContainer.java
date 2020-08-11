package com.brs.project.common.model;

import com.brs.project.auth.entity.LoginSession;
import com.brs.project.user.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DataContainer {
    private String userId;
    private String ipAddress;
    private String channel;
    private String tokenId;
    private LoginSession loginSession;
    private User user;
    private String userRole;
}
