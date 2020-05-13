package com.brs.project.passvault.service;

import com.brs.project.passvault.entity.PassVault;
import com.sytan.base.lib.ApplicationException;

import java.util.List;
import java.util.Map;

public interface PassVaultService {
    PassVault insertPassword(PassVault passVault) throws ApplicationException;
    String updatePassword(PassVault passVault) throws ApplicationException;
    String deletePassword(String id) throws ApplicationException;
    PassVault getPassword(String id) throws ApplicationException;
    Map<String,Object> getListPassword(String usrId, Integer page) throws ApplicationException;
}
