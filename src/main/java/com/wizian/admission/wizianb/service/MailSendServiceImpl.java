package com.wizian.admission.wizianb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
@Component
@RequiredArgsConstructor
public class MailSendServiceImpl implements MailSendService {

    private final JavaMailSenderImpl javaMailSender;
    private int authNumber;

    @Override
    public void makeRandomNumber() {
        Random random = new Random();
        int checkNum = random.nextInt(888888)+111111;
        authNumber = checkNum;
    }

    @Override
    public String joinEmail(String email) {

        makeRandomNumber();
        String toMail = email;
        String title = "인증";
        String message = "인증번호"+authNumber;

        mailSend(message,toMail,title);

        return Integer.toString(authNumber);
    }

    @Override
    public void mailSend(String message, String toMail, String title) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,false,"UTF-8");
            helper.setTo(toMail);               //이메일주소
            helper.setSubject(title);           //이메일제목
            helper.setText(message,true);  //전송할 이메일 내용

            //이메일 전송
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
