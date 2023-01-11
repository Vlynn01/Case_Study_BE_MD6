package com.example.case_study_be_md6.model.notification;

import com.example.case_study_be_md6.model.Enterprise;
import com.example.case_study_be_md6.model.UserApply;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
public class NotificationEnterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private UserApply userApply;

    @ManyToOne
    private Enterprise enterprise;

    private Time timeApply;

    private Date dateApply;

    private boolean statusConfirm = false;

    public NotificationEnterprise(UserApply userApply, Enterprise enterprise, Time timeApply, Date dateApply) {
        this.userApply = userApply;
        this.enterprise = enterprise;
        this.timeApply = timeApply;
        this.dateApply = dateApply;
    }

    public NotificationEnterprise() {
    }
}
