package com.brs.project.passvault.dao;

import com.brs.project.passvault.entity.PassVault;

import java.util.List;

public interface PassVaultDAO {
    PassVault insertPassword(PassVault passVault);
    String updatePassword(PassVault passVault);
    String deletePassword(String id);
    PassVault getPassword(PassVault passVault);
    List<PassVault> getListPassword(String usrId);
}
