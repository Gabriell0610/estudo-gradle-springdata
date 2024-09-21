package com.jornada.mentoria.mentoriaapi.service;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String from;

    public void enviarEmailSimples(String emailDestino, String assunto, String texto) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(from); // Quem está enviando o email
            mailMessage.setTo(emailDestino); //Quem vai receber o email
            mailMessage.setSubject(assunto);
            mailMessage.setText(texto);
            this.emailSender.send(mailMessage);
        }catch (Exception e ) {
            System.out.println(e.getMessage());
        }
    }

    public void enviarEmailComAnexo(String emailDestino, String assunto, String texto) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from);
        helper.setTo(emailDestino);
        helper.setSubject(assunto);
        helper.setText(texto);

        //Forma 1
        File file1 = new File("C:\\Users\\Micro\\Desktop\\Estudo de Programação\\Linguagens\\JAVA\\mentoria-api\\src\\main\\resources\\image-portfolio.jpg");
        FileSystemResource file = new FileSystemResource(file1);

        helper.addAttachment(file1.getName(), file);

        emailSender.send(message);

    }

    public void enviarEmailComTemplate(String emailDestino, String assunto, String name) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(from);
            helper.setTo(emailDestino);
            helper.setSubject(assunto);
            String email = gerarConteudoComTemplate(name, from);
            helper.setText(email, true);

            emailSender.send(helper.getMimeMessage());


        }catch(MessagingException | IOException | TemplateException e ) {
            e.printStackTrace();
        }
    }

    public String gerarConteudoComTemplate(String nome, String email) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nome);
        dados.put("email", email);

        Template template = fmConfiguration.getTemplate("template-email.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }


}
