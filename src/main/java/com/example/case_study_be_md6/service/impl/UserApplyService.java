package com.example.case_study_be_md6.service.impl;

import com.example.case_study_be_md6.model.CvUser;
import com.example.case_study_be_md6.model.Enterprise;
import com.example.case_study_be_md6.model.Notification.NotificationEnterprise;
import com.example.case_study_be_md6.model.UserApply;
import com.example.case_study_be_md6.repository.IUserApplyRepo;
import com.example.case_study_be_md6.service.InterfaceService.ICvUserService;
import com.example.case_study_be_md6.service.InterfaceService.INotificationEnterpriseService;
import com.example.case_study_be_md6.service.InterfaceService.IPostEnterpriseService;
import com.example.case_study_be_md6.service.InterfaceService.IUserApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class UserApplyService implements IUserApplyService {

    @Autowired
    IUserApplyRepo userApplyRepo;
    @Autowired
    ICvUserService cvUserService;
    @Autowired
    IPostEnterpriseService postEnterpriseService;

    @Autowired
    INotificationEnterpriseService notificationEnterpriseService;

    @Override
    public void save(UserApply userApply) {
        int idPost = userApply.getPostEnterprise().getIdPostEnterprise();
        CvUser cvUser = cvUserService.findByIdAppUser((int) userApply.getAppUser().getId());
        userApply.setNameCV(cvUser.getName());
        userApply.setMailCv(cvUser.getMail());
        userApply.setNumberCV(cvUser.getTelephone());
        userApply.setImgCV(cvUser.getImgCV());
        userApplyRepo.save(userApply);
        int quantity = postEnterpriseService.quantityApplyByIdPost(idPost) + 1;
        postEnterpriseService.setQuantityApplyPost(idPost, quantity);
        Enterprise enterpriseNotifi = postEnterpriseService.findById(idPost).getEnterprise();
        Time timeNow = Time.valueOf(java.time.LocalTime.now());
        long millis = System.currentTimeMillis();
        java.sql.Date dateNow = new java.sql.Date(millis);
        int priority = postEnterpriseService.priorityByIdPost(idPost);
        int priorityUpdate = priority + 3;
        postEnterpriseService.setPriorityIdPost(priorityUpdate, idPost);
        notificationEnterpriseService.save(new NotificationEnterprise(userApply, enterpriseNotifi, timeNow, dateNow));
    }

    @Override
    public UserApply findByIdAppUserAndIdPost(String imgcv, String mail, String numberTelephone, int idAppUser, int idPost) {
        return userApplyRepo.findByIdAppUserAndIdPost(imgcv, mail, numberTelephone, idAppUser, idPost);
    }


    @Override
    public void updateStatusConfirmUserApply(int id) {
        userApplyRepo.updateStatusConfirmUserApply(id);
    }

    @Override
    public UserApply findById(int id) {
        return userApplyRepo.findById(id).get();
    }

    @Override
    public List<UserApply> listUserApplyByIdPost(int id) {
        return userApplyRepo.listUserApplyByIdPost(id);
    }

    @Override
    public List<Integer> listIdPostByIdUserApply(int id) {
        return userApplyRepo.listIdPostByIdUserApply(id);
    }

    @Override
    public List<UserApply> listUserApplyByIdAppUser(int id) {
        return userApplyRepo.listUserApplyByIdAppUser(id);
    }

    @Override
    public UserApply findImgCvApply(int idUser, int idPost){
        return userApplyRepo.findImgCvApply(idUser,idPost);
    }
}

