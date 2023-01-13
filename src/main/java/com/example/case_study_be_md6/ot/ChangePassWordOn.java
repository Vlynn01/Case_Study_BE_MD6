package com.example.case_study_be_md6.ot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePassWordOn {
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;
}
