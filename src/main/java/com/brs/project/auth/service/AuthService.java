package com.brs.project.auth.service;

import com.brs.project.auth.entity.LoginSession;
import org.springframework.security.core.Authentication;

public interface AuthService {
    LoginSession processLogin(String tokenId, Authentication authentication);
    LoginSession processUpdateSession(LoginSession login);
    LoginSession loadUserSessionByTokenId(String id) throws Exception;
}
