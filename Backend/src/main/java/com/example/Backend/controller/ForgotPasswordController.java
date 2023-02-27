package com.example.Backend.controller;

import com.example.Backend.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ForgotPasswordController {


    @GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
        return null;

    }

    @PostMapping("/forgot_password")
    public String processForgotPassword() {
        return null;
    }


    @GetMapping("/reset_password")
    public String showResetPasswordForm() {
        return null;

    }

    @PostMapping("/reset_password")
    public String processResetPassword() {
        return null;

    }
}
