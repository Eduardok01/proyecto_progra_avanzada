package com.ufro.voyyvuelvo.service;

import com.ufro.voyyvuelvo.model.Pasaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(Pasaje pasaje) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("voyyvuelvocomprapasajes@gmail.com");
        message.setTo(pasaje.getUsuario().getEmail());
        message.setSubject("Compra pasaje VoyYVuelvo");

        message.setText(
                "Origen:" + pasaje.getAsiento().getViaje().getOrigen() + "\n" +
                "Destino:" + pasaje.getAsiento().getViaje().getOrigen() + "\n" +
                "Salida:" + pasaje.getAsiento().getViaje().getOrigen() + "\n" +
                "Numero Asiento:" + pasaje.getAsiento().getNumero() + "\n" +
                "Titular Pasaje: " + pasaje.getUsuario().getRut()
        );

        mailSender.send(message);
    }


}
