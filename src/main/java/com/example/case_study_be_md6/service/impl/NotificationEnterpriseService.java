package com.example.case_study_be_md6.service.impl;

import com.example.case_study_be_md6.model.notification.NotificationEnterprise;
import com.example.case_study_be_md6.repository.INotificationEnterpriseRepo;
import com.example.case_study_be_md6.service.InterfaceService.All.INotificationEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationEnterpriseService implements INotificationEnterpriseService {
    @Autowired
    INotificationEnterpriseRepo notificationEnterpriseRepo;

    @Override
    public void save(NotificationEnterprise notificationEnterprise) {
        notificationEnterpriseRepo.save(notificationEnterprise);
    }

    @Override
    public NotificationEnterprise findById(int id) {
        return notificationEnterpriseRepo.findById(id).get();
    }

    @Override
    public List<NotificationEnterprise> notificationEnterpriseSByEnterprise(int id) {
        return notificationEnterpriseRepo.notificationEnterpriseSByEnterprise(id);
    }

    @Override
    public void updateStatusNotifi(int id) {
        notificationEnterpriseRepo.updateStatusNotifi(id);
    }
}
