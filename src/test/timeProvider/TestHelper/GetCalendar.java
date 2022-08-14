package test.timeProvider.TestHelper;

import java.util.Calendar;

public class GetCalendar {
    public Calendar getCalendar(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);

        return calendar;
    }
}
