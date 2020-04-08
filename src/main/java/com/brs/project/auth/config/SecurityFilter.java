package com.brs.project.auth.config;

import com.brs.project.auth.entity.LoginSession;
import com.brs.project.auth.entity.UserPrincipal;
import com.brs.project.auth.service.AuthService;
import com.brs.project.cache.service.CacheService;
import com.brs.project.common.helper.CommonConstants;
import com.brs.project.common.model.DataContainer;
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
    private CacheService cacheService;
    private DataContainer dataContainer;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String tokenId = httpServletRequest.getHeader(CommonConstants.FLD_TOKEN_ID);

        try {
            if (StringUtils.hasText(tokenId)) {
                LoginSession user = authService.loadUserSessionByTokenId(tokenId);
                UserDetails userDetails = UserPrincipal.create(user.getUser());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                authService.processUpdateSession(user);
                LoginSession session = authService.processLogin(tokenId,authentication);
                cacheService.UpdateCacheByTokenId(tokenId,session.getId());
                if(StringUtils.hasText(tokenId) && null != userDetails){
                    dataContainer.setUserId(user.getUsrId());
                    dataContainer.setLoginSession(session);
                    dataContainer.setUser(user.getUser());
                    dataContainer.setTokenId(session.getId());
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
}
