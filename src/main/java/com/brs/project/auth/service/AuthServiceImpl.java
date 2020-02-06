package com.brs.project.auth.service;

import com.brs.project.auth.dao.AuthDAO;
import com.brs.project.auth.entity.LoginSession;
import com.brs.project.auth.entity.UserPrincipal;
import com.brs.project.common.helper.CommonUtils;
import com.brs.project.user.dao.UserDAO;
import com.brs.project.user.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Service
@Transactional
public class AuthServiceImpl implements AuthService, UserDetailsService {
    private UserDAO userDAO;
    private AuthDAO authDAO;

    public AuthServiceImpl(AuthDAO authDAO,UserDAO userDAO){
        this.authDAO = authDAO;
        this.userDAO = userDAO;
    }

    @Override
    public LoginSession processLogin(String tokenId, Authentication authentication) {
        UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
        LoginSession session = new LoginSession();
        session.setId(CommonUtils.generateUUID());
        session.setUsrId(user.getId());
        session.setLoginDate(new Timestamp(new Date().getTime()));
        session.setLastSessionId(tokenId);
        session.setChannel("TEST");
        session.setIpAddress("localhost");
        session.setTokenDuration(300);
        session.setIsActive("Y");
        authDAO.insertLoginSession(session);
        User userSession = userDAO.getUser(user.getId());
        session.setUser(userSession);
        return session;
    }

    @Override
    public LoginSession processUpdateSession(LoginSession login) {
        return authDAO.updateLoginSession(login);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.getUserByUserName(s);
        if(null == user){
            new UsernameNotFoundException("User not found with UserName : " + s);
        }
        return UserPrincipal.create(user);
    }

    public LoginSession loadUserSessionByTokenId(String id) throws Exception {
        LoginSession user = authDAO.getSession(id);

        if(null == user){
            new UsernameNotFoundException("User not found with id : " + id);
        } else {
            Timestamp now = new Timestamp(new Date().getTime());
            Timestamp loginTime = user.getLoginDate();
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(loginTime.getTime());
            cal.add(Calendar.SECOND, user.getTokenDuration());
            Timestamp ExpireTime = new Timestamp(cal.getTime().getTime());
            if(ExpireTime.compareTo(now) < 0){
                throw new Exception("Your Token is expired, Please login again");
            }
        }
        return user;
    }
}
