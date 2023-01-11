package com.example.case_study_be_md6.controller;

import com.example.case_study_be_md6.model.Enterprise;
import com.example.case_study_be_md6.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/mail")
public class MailController {
    @Autowired
    SendMailService sendMailService;

    @PostMapping("/send")
    public boolean send(@RequestBody Enterprise enterprise) {
        return sendMailService.sendMail(enterprise.getGmailEnterprise(), "Xác nhân !", enterprise.getNameEnterprise() + "\nMã xác nhận của bạn là: ");
    }

    @GetMapping("/confirm")
    public String confirm(@RequestParam("code") String code) {
        return sendMailService.confirmCode(code);
    }

    @GetMapping("/resetcode")
    public void resetcode() {
        sendMailService.rsCode();
    }
}
