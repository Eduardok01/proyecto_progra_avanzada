package com.ufro.voyyvuelvo.controller;

import com.ufro.voyyvuelvo.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {

    @Autowired
    EmailSenderService emailSenderService;


}
