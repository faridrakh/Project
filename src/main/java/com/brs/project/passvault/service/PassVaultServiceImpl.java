package com.brs.project.passvault.service;

import com.brs.project.common.helper.CommonUtils;
import com.brs.project.passvault.dao.PassVaultDAO;
import com.brs.project.passvault.entity.PassVault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PassVaultServiceImpl implements PassVaultService {
    private PassVaultDAO passVaultDAO;
    private final CommonUtils commonUtils  = new CommonUtils();

    public PassVaultServiceImpl(PassVaultDAO passVaultDAO) {
        this.passVaultDAO = passVaultDAO;
    }

    @Override
    public PassVault insertPassword(PassVault passVault) {
        passVault.setId(commonUtils.generateUUID());
        passVault.setDtCreate(commonUtils.generateDate());
        passVault.setCreateBy(passVault.getUsrId());
        return passVaultDAO.insertPassword(passVault);
    }

    @Override
    public String updatePassword(PassVault passVault) {
        passVault.setDtUpdate(commonUtils.generateDate());
        passVault.setUpdateBy(passVault.getUsrId());
        return passVaultDAO.updatePassword(passVault);
    }

    @Override
    public String deletePassword(String id) {
        return passVaultDAO.deletePassword(id);
    }

    @Override
    public PassVault getPassword(String id) {
        return null;
    }

    @Override
    public List<PassVault> getListPassword(String usrId) {
        return passVaultDAO.getListPassword(usrId);
    }
}
