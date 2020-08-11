package com.brs.project.auth.controller;

import com.brs.project.auth.entity.LoginSession;
import com.brs.project.auth.service.AuthService;
import com.brs.project.common.controller.BaseController;
import com.brs.project.common.model.RequestModel;
import com.sytan.base.lib.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sl/auth")
public class AuthController extends BaseController {
    private AuthService authService;
    private AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager){
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @RequestMapping("/doLogin")
    public ResponseEntity<?> authenticateUser(@RequestBody RequestModel loginRequest) throws ApplicationException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        LoginSession session = authService.processLogin(null,authentication,loginRequest.getChannel(), loginRequest.getIpAddress());
        return ResponseEntity.ok(session);
    }
}
