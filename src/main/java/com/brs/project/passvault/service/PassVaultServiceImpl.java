package com.brs.project.passvault.service;

import com.brs.project.common.helper.CommonConstants;
import com.brs.project.common.helper.CommonUtils;
import com.brs.project.passvault.dao.PassVaultDAO;
import com.brs.project.passvault.entity.PassVault;
import com.sytan.base.lib.ApplicationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PassVaultServiceImpl implements PassVaultService {
    private PassVaultDAO passVaultDAO;
    private final CommonUtils commonUtils  = new CommonUtils();

    public PassVaultServiceImpl(PassVaultDAO passVaultDAO) {
        this.passVaultDAO = passVaultDAO;
    }

    @Override
    public PassVault insertPassword(PassVault passVault) throws ApplicationException {
        passVault.setId(commonUtils.generateUUID());
        passVault.setDtCreate(commonUtils.generateDate());
        passVault.setCreateBy(passVault.getUsrId());
        return passVaultDAO.insertPassword(passVault);
    }

    @Override
    public String updatePassword(PassVault passVault) throws ApplicationException {
        PassVault tmp = passVaultDAO.getPassword(passVault.getId());
        passVault.setCreateBy(tmp.getCreateBy());
        passVault.setDtCreate(tmp.getDtCreate());
        passVault.setDtUpdate(commonUtils.generateDate());
        passVault.setUpdateBy(passVault.getUsrId());
        return passVaultDAO.updatePassword(passVault);
    }

    @Override
    public String deletePassword(String id) throws ApplicationException {
        PassVault passVault = getPassword(id);
        passVault.setDtUpdate(commonUtils.generateDate());
        passVault.setUpdateBy(passVault.getUsrId());
        passVault.setIsDel(CommonConstants.BOOLEAN_YES);
        return passVaultDAO.updatePassword(passVault);
    }

    @Override
    public PassVault getPassword(String id) throws ApplicationException {
        return passVaultDAO.getPassword(id);
    }

    @Override
    public Map<String,Object> getListPassword(String usrId, Integer page) throws ApplicationException {
        return passVaultDAO.getListPassword(usrId,page);
    }
}
