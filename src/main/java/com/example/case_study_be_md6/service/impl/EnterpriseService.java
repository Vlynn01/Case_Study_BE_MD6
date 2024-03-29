package com.example.case_study_be_md6.service.impl;

import com.example.case_study_be_md6.model.Enterprise;

import com.example.case_study_be_md6.repository.IAppUserRepo;
import com.example.case_study_be_md6.repository.IEnterpriseRepo;
import com.example.case_study_be_md6.service.InterfaceService.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService implements IEnterpriseService {
    @Autowired
    IEnterpriseRepo enterpriseRepo;

    @Autowired
    IAppUserRepo iAppUserRepo;

    @Override
    public void save(Enterprise enterprise){
        enterpriseRepo.save(enterprise);
    }

    @Override

    public List<Enterprise> findAll() {
        return (List<Enterprise>) enterpriseRepo.findAll();
    }

    @Override
    public void editProfile(Enterprise enterprise) {
        enterpriseRepo.editProfile(enterprise.getNameEnterprise(),enterprise.getAddressMainEnterprise(),enterprise.getDescribeEnterprise(),enterprise.getIdEnterprise());
    }

    @Override

    public List<Enterprise> getAllEnterprise() {
       return (List<Enterprise>) enterpriseRepo.findAll();
    }

    @Override
    public List<Enterprise> getAllEnterpriseNotConfirmOrderByTime() {
        return enterpriseRepo.getAllEnterpriseNotConfirmOrderByTime();
    }

    @Override
    public List<Enterprise> getAllEnterpriseConfirmOrderByTime() {
        return enterpriseRepo.getAllEnterpriseConfirmOrderByTime();
    }


    @Override
    public Enterprise findEnterpriseById(int id) {
        return enterpriseRepo.findById(id).get();
    }

    @Override
    public void confirmRegisterEnterprise(String password,int status, int id) {
        enterpriseRepo.confirmRegisterEnterprise(password,status,id);
    }
    @Override
    public void delete(int id){
        enterpriseRepo.deleteById(id);
    }


    @Override
    public void setStatusEnterpriseTo1(int id) {
        enterpriseRepo.setStatusEnterpriseTo1(id);
    }
    @Override
    public void setStatusEnterpriseTo0(int id) {
        enterpriseRepo.setStatusEnterpriseTo0(id);
    }



// ĐỔi mật khẩu
    @Override
    public void changPassword(String email, String password) {
        iAppUserRepo.changPassword(email,password);
    }


//    @Override
//    public List<Enterprise> listEnterpriseOderByRates() {
//        return enterpriseRepo.listEnterpriseOderByRates();
//    }

    @Override
    public Enterprise findByGmailEnterprise(String name){
        return enterpriseRepo.findByGmailEnterprise(name);
    }

    public List<Enterprise> findAllEnterprise(){
        return enterpriseRepo.findAllEnterprise();
    }

}
