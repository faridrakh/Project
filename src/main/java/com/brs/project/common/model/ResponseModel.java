package com.brs.project.common.model;

import com.brs.project.category.entity.Category;
import com.brs.project.financial.account.entity.Account;
import com.brs.project.financial.transaction.entity.Transaction;
import com.brs.project.maintenance.entity.UserGroupMtn;
import com.brs.project.passvault.entity.PassVault;
import com.brs.project.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {
    private String errorCode;
    private String errorDescription;
    private String tokenId;
    private User user;
    private PassVault passVault;
    private List<User> userList;
    private List<UserGroupMtn> userGroupMtnList;
    private List<PassVault> passVaultList;
    private Map<String,Object> listData;
    private List<Category> categoryList;
    private Category category;
    private Account account;
    private Transaction transaction;
    private List<Transaction> transactionList;
    private List<Account> accountList;
}
