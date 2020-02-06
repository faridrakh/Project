package com.brs.project.passvault.service;

import com.brs.project.passvault.entity.PassVault;

import java.util.List;

public interface PassVaultService {
    PassVault insertPassword(PassVault passVault);
    String updatePassword(PassVault passVault);
    String deletePassword(String id);
    PassVault getPassword(String id);
    List<PassVault> getListPassword(String usrId);
}
