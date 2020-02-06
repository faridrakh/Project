package com.brs.project.config;

import com.brs.project.maintenance.service.UserGroupMtnService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DataInitializer {
    private UserGroupMtnService userGroupMtnService;

    public DataInitializer(UserGroupMtnService userGroupMtnService){
        this.userGroupMtnService = userGroupMtnService;

    }

    @PostConstruct
    private void initData(){
        userGroupMtnService.getUserGroupMtnList();
    }

    @PreDestroy
    private void destroyData(){
        System.out.println("Destroyed");
    }
}
