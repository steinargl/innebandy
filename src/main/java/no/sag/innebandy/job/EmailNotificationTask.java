package no.sag.innebandy.job;

import no.sag.innebandy.service.CalendarService;
import no.sag.innebandy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;

@EnableScheduling
@Component
public class EmailNotificationTask
{
    private static final Logger LOG = LoggerFactory.getLogger(EmailNotificationTask.class);

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender mailSender;

    @Scheduled(initialDelay = 10000, fixedRate = 300000)
    public void remaindUsersToRegisterForNextTraining()
    {
        final LocalDate now = LocalDate.now();
        final LocalDate nextTraingDay = calendarService.nextTrainingDate();
        final LocalDate twoDaysBeforeTraining = nextTraingDay.minusDays(2);

        try
        {
            sendEmail();
        }
        catch (Exception e)
        {
            LOG.error("Failed to send email", e);
        }

    }

    private void sendEmail() throws MessagingException
    {
        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);
        helper.setTo("sglamseter@gmail.com");

        //helper.setReplyTo("someone@localhost");
        helper.setFrom("manstadinnebandy@gmail.com");
        helper.setSubject("Lorem ipsum");
        helper.setText("Lorem ipsum dolor sit amet [...]");

        mailSender.send(mail);
        //return helper;
    }

}
