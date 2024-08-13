package nl.funda.helpers;

import java.security.SecureRandom;

public class Utils {

    public static String getRandomString(final int length) {
        final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final SecureRandom random = new SecureRandom();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString();
    }

    public static String getRandomEmail() {
        return String.format("%s@funda.nl", getRandomString(10));
    }

    public static char[] getRandomPassword() {
        return String.format("Aa1!%s", 4).toCharArray();
    }
}
