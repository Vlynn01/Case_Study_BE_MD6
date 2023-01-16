package com.example.case_study_be_md6.service.InterfaceService;

import com.example.case_study_be_md6.model.Notification.NotificationEnterprise;

import java.util.List;

public interface INotificationEnterpriseService {


    void save(NotificationEnterprise notificationEnterprise);

    NotificationEnterprise findById(int id);
    List<NotificationEnterprise> notificationEnterpriseSByEnterprise(int id);

    void updateStatusNotifi(int id);
}
