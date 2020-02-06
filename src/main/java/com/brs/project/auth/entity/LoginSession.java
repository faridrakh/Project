package com.brs.project.auth.entity;

import com.brs.project.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Getter
@ToString
@Entity
@Table(name = "t_login_session")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginSession {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "USR_ID")
    private String usrId;

    @Column(name = "DT_LOGIN")
    private Timestamp loginDate;

    @Column(name = "TOKEN_DURATION")
    private Integer tokenDuration;

    @Column(name = "LAST_SESSION_ID")
    private String lastSessionId;

    @Column(name = "CHANNEL")
    private String channel;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "IS_ACTIVE")
    private String isActive;

    @OneToOne
    @JoinColumn(name="USR_ID" , insertable = false, updatable = false)
    private User user;
}
