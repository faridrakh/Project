package com.brs.project.auth.dao;

import com.brs.project.auth.entity.LoginSession;

public interface AuthDAO {
    LoginSession insertLoginSession(LoginSession login);
    LoginSession updateLoginSession(LoginSession login);
    LoginSession getSession(String tokenId);
}
