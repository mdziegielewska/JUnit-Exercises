package main.timeProvider;

import java.util.Calendar;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for exercises.
 * Visit <a href="http://practicalunittesting.com">...</a> for more information.
 *
 * @author Tomek Kaczanowski
 */

public class HelloRedesigned {
    private final TimeProvider timeProvider;

    public HelloRedesigned(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public String sayHello() {
        Calendar current = timeProvider.getTime();
        if (current.get(Calendar.HOUR_OF_DAY) >= 8 && current.get(Calendar.HOUR_OF_DAY) < 12) {
            return "Good Morning!";
        } else if ((current.get(Calendar.HOUR_OF_DAY) >= 12 && current.get(Calendar.HOUR_OF_DAY) < 18)) {
            return "Good Afternoon!";
        } else if ((current.get(Calendar.HOUR_OF_DAY) >= 18 && current.get(Calendar.HOUR_OF_DAY) < 22)) {
            return "Good Evening!";
        } else {
            return "Good Night!";
        }
    }
}
