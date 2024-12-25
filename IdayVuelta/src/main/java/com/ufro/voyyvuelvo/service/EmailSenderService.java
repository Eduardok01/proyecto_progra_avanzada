package com.ufro.voyyvuelvo.service;

import com.ufro.voyyvuelvo.model.Pasaje;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail(Pasaje pasaje, File pdfFile) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("voyyvuelvocomprapasajes@gmail.com");
            helper.setTo(pasaje.getUsuario().getEmail());
            helper.setSubject("Pasaje VoyYVuelvo");
            helper.setText("Pasaje Adjunto", true);

            helper.addAttachment(pdfFile.getName(), pdfFile);

            mailSender.send(message);
            pdfFile.delete();

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }




}
