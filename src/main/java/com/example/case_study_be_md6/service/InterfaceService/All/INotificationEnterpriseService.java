package com.example.case_study_be_md6.service.InterfaceService.All;

import com.example.case_study_be_md6.model.notification.NotificationEnterprise;

import java.util.List;

public interface INotificationEnterpriseService {


    void save(NotificationEnterprise notificationEnterprise);

    NotificationEnterprise findById(int id);

    List<NotificationEnterprise> notificationEnterpriseSByEnterprise(int id);

    void updateStatusNotifi(int id);
}
