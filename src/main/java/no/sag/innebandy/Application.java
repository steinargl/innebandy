package no.sag.innebandy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
public class Application
{
    @Bean
    public JavaMailSenderImpl configureJavaMailSenderImpl()
    {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("manstadinnebandy@gmail.com");
        javaMailSender.setPassword("manstadinnebandy1626");

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.from", "manstadinnebandy@gmail.com");
        properties.setProperty("mail.smtp.user", "manstadinnebandy@gmail.com");
        properties.setProperty("mail.smtp.password", "manstadinnebandy1626");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        javaMailSender.setJavaMailProperties(properties);

        return javaMailSender;
    }

   /* @Bean
    public SimpleMailMessage configureSimpleMailMessage()
    {
        return new ApplicationSecurity();
    }*/

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter()
    {
        return new ApplicationSecurity();
    }

    public static void main(String[] args)
    {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        //System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}