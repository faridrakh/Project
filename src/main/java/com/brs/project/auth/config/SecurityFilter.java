package com.brs.project.auth.config;

import com.brs.project.auth.entity.LoginSession;
import com.brs.project.auth.entity.UserPrincipal;
import com.brs.project.auth.service.AuthService;
import com.brs.project.cache.service.CacheService;
import com.brs.project.common.helper.CommonConstants;
import com.brs.project.common.model.DataContainer;
import com.brs.project.maintenance.entity.UserGroupMtn;
import com.brs.project.user.entity.User;
import com.brs.project.usergrp.entity.UserGroup;
import com.brs.project.usergrp.service.UserGroupService;
import com.sytan.base.lib.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    private AuthService authService;
    private UserGroupService userGroupService;
    private CacheService cacheService;
    private DataContainer dataContainer;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String tokenId = httpServletRequest.getHeader(CommonConstants.FLD_TOKEN_ID);

        try {
            if (StringUtils.hasText(tokenId)) {
                LoginSession user = authService.loadUserSessionByTokenId(tokenId);
                UserGroup userGroup = userGroupService.getUserGrp(user.getUser().getUserGrpId());
                UserDetails userDetails = UserPrincipal.create(user.getUser(),userGroup.getRole());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                authService.processUpdateSession(user);
//                LoginSession session = authService.processLogin(tokenId,authentication);
//                cacheService.UpdateCacheByTokenId(tokenId,session.getId());
                if(StringUtils.hasText(tokenId) && null != userDetails){
                    dataContainer.setUserId(user.getUsrId());
                    dataContainer.setLoginSession(user);
                    dataContainer.setUser(user.getUser());
                    dataContainer.setTokenId(user.getId());
                    dataContainer.setUserRole(userGroup.getRole());
                }
            }
        } catch (ApplicationException ex) {
            logger.error("Could not set user authentication in security context with tokenId " + tokenId);
            logger.error(ex);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Autowired
    public void setDataContainer(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    @Autowired
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Autowired
    public void setUserGroupService(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

//    private LoginSession getDummyUser() {
//        LoginSession login = new LoginSession();
//        User user = new User();
//        UserGroup ug = new UserGroup();
//        UserGroupMtn ugm = new UserGroupMtn();
//        login.setId("6AD0FF8B1E074D6682A2CAB99FFBCBDA");
//        login.setUsrId("CF83B19ACFEF4A58AB0AF02BAF5CB747");
//        user.setId("CF83B19ACFEF4A58AB0AF02BAF5CB747");
//        user.setUserName("faridrakh");
//        user.setEmail("faridrakh@yahoo.com");
//        ug.setId("80230E11A09F41C2B5F9AACCD2AF2604");
//        ug.setMtGrpId("433FAC435FF92F0CF3414AA155167BC9");
//        ugm.setId("433FAC435FF92F0CF3414AA155167BC9");
//        return
//    }
}
