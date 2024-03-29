package com.example.case_study_be_md6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PostEnterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPostEnterprise;

    private String namePostEnterprise;

    private String addressMainEnterprise;

    private Time timePostEnterprise;

    private Date datePostEnterprise;

    private boolean statusPostEnterprise;

    private double salarySmallPostEnterprise;

    private double salaryBigPostEnterprise;
//  vị trí ứng tuyển
    private String vacanciesPostEnterprise;
//    hình thức job
    @ManyToOne
    private FormJob formJobPostEnterprise;
//    Ngày hết hạn
    private Date expirationDatePostEnterprise;
// độ ưu tiên bài đăng
    private int priorityPostEnterprise=0;

    @Column(name = "describe_post_enterprise", columnDefinition = "longtext")
    private String describePostEnterprise;

    private int quantityApplyPost=0;
//    Chọn gói
    @ManyToOne
    private Regime regime;
// Lĩnh vực
    @ManyToOne
    private Field field;

    @ManyToOne
    private Enterprise enterprise;
//
//   @ManyToMany(fetch = FetchType.EAGER)
//    private List<CvUser> cvUsers;
}
