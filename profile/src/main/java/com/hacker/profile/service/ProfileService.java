package com.hacker.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hacker.profile.entity.Profile;
import com.hacker.profile.repository.ProfileRepository;


@Service
public class ProfileService{
	@Lazy
    @Autowired
    private ProfileRepository repo;
    
    @Autowired
    private JavaMailSender mailSender;

    public void saveProfile(Profile profile) {
        repo.save(profile);
        sendConfirmationEmail(profile.getEmail(),profile.getVision(),profile.getName());
    }

    private void sendConfirmationEmail(String toEmail,String body,String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Regarding Job Oppurnities "+name);
        message.setText(body);
        
        mailSender.send(message);
    }
}