package no.sag.innebandy.job;

import no.sag.innebandy.data.model.User;
import no.sag.innebandy.data.repo.UserRepository;
import no.sag.innebandy.service.CalendarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.List;

@Component
@EnableScheduling
public class EmailNotificationTask
{
    private static final Logger LOG = LoggerFactory.getLogger(EmailNotificationTask.class);

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${innebandy.notification.email.enabled}")
    private boolean mailNotificationEnabled;

    @Scheduled(cron = "0 0 12 ? * SUN-TUE")
    public void remaindUsersToRegisterForNextTraining()
    {
        try
        {
            LOG.info("Email notification enabled=" + mailNotificationEnabled);
            if (mailNotificationEnabled)
            {
                final LocalDate nextTraingDay = calendarService.nextTrainingDate();
                final List<User> users = userRepository.findByEnabled(true);
                for (User user : users)
                {
                    if (user.hasNotAnswerd(nextTraingDay))
                    {
                        sendEmail(user, nextTraingDay);
                        LOG.info("Sent mail to " + user.getEmail());
                    }
                }
            }
        }
        catch (Exception e)
        {
            LOG.error("Failed to send email", e);
        }
    }

    private void sendEmail(final User user, final LocalDate nextTrainingDate) throws MessagingException
    {
        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);
        helper.setTo(user.getEmail());

        //helper.setReplyTo("someone@localhost");
        helper.setFrom("manstadinnebandy@gmail.com");
        helper.setSubject("Påminnelse om innebandytrening");
        helper.setText(createText(user, nextTrainingDate));

        mailSender.send(mail);
    }

    private String createText(final User user, final LocalDate nextTrainingDate)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Hei ").append(user.getName()).append("!\n");
        sb.append("Kommer du på trening");

        if (nextTrainingDate.equals(LocalDate.now())) {
            sb.append(" i dag");
        }
        else if (nextTrainingDate.minusDays(1).equals(LocalDate.now())) {
            sb.append(" i morgen");
        }
        else if (nextTrainingDate.minusDays(2).equals(LocalDate.now())) {
            sb.append(" til tirsdag");
        }

        sb.append("?\n\n");
        sb.append("Registrer svaret ditt på nettsiden.\n");
        sb.append("https://manstad-innebandy.herokuapp.com\n\n");
        sb.append("Mvh Manstad innebandy");

        return sb.toString();
    }
}
