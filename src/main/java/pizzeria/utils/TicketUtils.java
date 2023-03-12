package pizzeria.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class TicketUtils {

    private TicketUtils() {}

    public static String ticketGenerator() {
        return RandomStringUtils.randomAlphabetic(7);
    }

}
