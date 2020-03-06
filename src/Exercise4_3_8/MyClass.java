package Exercise4_3_8;// Задача 4.3 для курса Java

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClass {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";


    public static void main(String[] args) {
        MailService[] arrSomeWorkers = {new SomeWorker(), new SomeWorker(), new SomeWorker()};

        UntrustworthyMailWorker messenger = new UntrustworthyMailWorker(arrSomeWorkers);
        for (int i = 0; i < 10; i++) {
            messenger.processMail(SomeSendable.generateSendable());
        }
    }

    public static class StolenPackageException extends RuntimeException {
       /* public StolenPackageException(String message) {
            super(message);
        }
   */}

    public static class IllegalPackageException extends RuntimeException {
   /*     public IllegalPackageException(String message) {
            super(message);
        }
   */}

    public static class UntrustworthyMailWorker implements MailService {

        protected MailService[] arrSomeWorkers;
        protected RealMailService russianPost;

        UntrustworthyMailWorker(MailService[] arrSomeWorkers) {
            this.arrSomeWorkers = arrSomeWorkers;
            this.russianPost = new RealMailService();
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService someworker : arrSomeWorkers) {
                mail = someworker.processMail(mail);
            }
            return russianPost.processMail(mail);
        }

        public RealMailService getRealMailService() {
            return russianPost;
        }
    }


    public static class Spy implements MailService {
        private final Logger LOGGER;

        Spy(Logger LOGGER) {
            this.LOGGER = LOGGER;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (!(mail instanceof MailMessage)) return mail;
            MailMessage messageMail = (MailMessage) mail;
            String from = messageMail.getFrom();
            String to = messageMail.getTo();

            if (!from.equals(AUSTIN_POWERS) & !to.equals(AUSTIN_POWERS)) {
                LOGGER.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                        new Object[]{from, to});
                return mail;
            }
            String message = messageMail.getMessage();
            LOGGER.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                    new Object[]{from, to, message});
            return mail;
        }
    }

    public static class Thief implements MailService {
        private int price;
        private static int totalPrice;

        public Thief(int price) {
            this.price = price;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (!(mail instanceof MailPackage)) {

                return mail;
            }
            MailPackage mailPkg = (MailPackage) mail;
            int mailPrice = mailPkg.getContent().getPrice();
            if (!(price <= mailPrice)) {
                System.out.println("ThiefNotSteal " + price);
                System.out.println("MailNotSteal " + ((MailPackage) mail).getContent().getPrice());
                return mail;
            }
            Package fakePkg = new Package("stones instead of " + mailPkg.getContent().getContent(), 0);
            Sendable fakeMail = new MailPackage(mailPkg.getFrom(), mailPkg.getTo(), fakePkg);
            totalPrice += mailPrice;
            System.out.println("equals: " + fakeMail.equals(mail));
            return fakeMail;
        }

        public int getStolenValue() {
            return totalPrice;
        }
    }


    public static class Inspector implements MailService {


        @Override
        public Sendable processMail(Sendable mail) {
            if (!(mail instanceof MailPackage)) return mail;
            MailPackage mailPackage = (MailPackage) mail;
            String content = mailPackage.getContent().getContent();
            if ((content == BANNED_SUBSTANCE) | (content == WEAPONS)) {
                throw new IllegalPackageException();
            }
            if (content.contains("stones")) {
                throw new StolenPackageException();
            }
            return mail;
        }
    }
}


