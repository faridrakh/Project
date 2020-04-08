package com.brs.project.auth.dao;

import com.brs.project.auth.entity.LoginSession;
import com.sytan.base.lib.ApplicationException;

public interface AuthDAO {
    LoginSession insertLoginSession(LoginSession login) throws ApplicationException;
    LoginSession updateLoginSession(LoginSession login) throws ApplicationException;
    LoginSession getSession(String tokenId) throws ApplicationException;
}
