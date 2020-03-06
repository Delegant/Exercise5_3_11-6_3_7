package Exercise4_3_8;

import java.util.Random;
public class SomeSendable {

    private static String[] arrFromTo = {"Man1", "Man2", "Women1", "Women2", MyClass.AUSTIN_POWERS};
    private static String[] arrText = {"Hello World!", "Magic people voodoo people", "Imagine how it would be", "To be at the top", "Austin powers make love", MyClass.BANNED_SUBSTANCE, MyClass.WEAPONS};

    public static Sendable generateSendable() {

        Sendable someSend;
        String from = arrFromTo[new Random().nextInt(arrFromTo.length)];
        String to = arrFromTo[new Random().nextInt(arrFromTo.length)];
        String text = arrText[new Random().nextInt(arrText.length)];
        if (new Random().nextBoolean()) {
            someSend = new MailPackage(from, to, new Package(text,new Random().nextInt(100)));
        }
        else {
            someSend = new MailMessage(from, to, text);
        }
        System.out.println("\nCrate new " + someSend.getClass().getName()+ ":\n" + someSend.toString());
        return someSend;
    }
}