package com.brs.project.auth.service;

import com.brs.project.auth.entity.LoginSession;
import com.sytan.base.lib.ApplicationException;
import org.springframework.security.core.Authentication;

public interface AuthService {
    LoginSession processLogin(String tokenId, Authentication authentication) throws ApplicationException;
    LoginSession processUpdateSession(LoginSession login) throws ApplicationException;
    LoginSession loadUserSessionByTokenId(String id) throws ApplicationException;
}
