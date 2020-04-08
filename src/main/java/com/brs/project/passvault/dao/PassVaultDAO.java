package com.brs.project.passvault.dao;

import com.brs.project.passvault.entity.PassVault;

import java.util.List;
import java.util.Map;

public interface PassVaultDAO {
    PassVault insertPassword(PassVault passVault);
    String updatePassword(PassVault passVault);
    String deletePassword(String id);
    PassVault getPassword(String id);
    Map<String,Object> getListPassword(String usrId, Integer page);
}
