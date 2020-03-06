package Exercise4_3_8;

import java.util.Random;
import java.util.logging.Logger;

/*
Класс, в котором скрыта логика настоящей почты
*/
public class RealMailService implements MailService {
    private static final Logger LOGGER = Logger.getLogger(RealMailService.class.getName());
    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.

        MyClass.Spy shtirltis = new MyClass.Spy(LOGGER);
        MyClass.Thief oushen = new MyClass.Thief(50);
        MyClass.Inspector inspector = new MyClass.Inspector();
        System.out.println("Mail send to Spy");
        Sendable mailAfterSpy = shtirltis.processMail(mail);
        System.out.println("Mail send to Thief");
        Sendable mailAfterThief = oushen.processMail(mailAfterSpy);

        if (new Random().nextBoolean()) {
            System.out.println("Mail send to Inspector");
            Sendable mailAfterInspector = inspector.processMail(mailAfterThief);
            System.out.println("Process sending complete with Inspector:\n" + mailAfterInspector.toString());
        }
        else {
            System.out.println("Process sending complete\n" + mailAfterThief.toString());
        }
        System.out.println("Total stolen: " + oushen.getStolenValue());
        return mail;
    }
}