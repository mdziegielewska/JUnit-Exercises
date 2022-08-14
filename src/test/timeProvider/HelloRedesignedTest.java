package test.timeProvider;

import main.timeProvider.HelloRedesigned;
import main.timeProvider.TimeProvider;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.timeProvider.TestHelper.GetCalendar;
import test.timeProvider.TestHelper.GetExpectedAnswer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Hello redesigned test")
public class HelloRedesignedTest {
    private static HelloRedesigned helloRedesigned;
    private static TimeProvider timeProvider;
    private final GetCalendar getCalendar = new GetCalendar();
    private final GetExpectedAnswer getExpectedAnswer = new GetExpectedAnswer();

    @DisplayName("Creating Time Provider mock...")
    @BeforeEach
    public void setUp() {
        timeProvider = mock(TimeProvider.class);
        helloRedesigned = new HelloRedesigned(timeProvider);
    }

    // Easy way
    @DisplayName("Should say Hello")
    @Test
    @Ignore
    public void shouldSayHello() {
        int hour;
        for(hour=1; hour <=24; hour++) {
            String expectedAnswer = getExpectedAnswer.getExpectedAnswer(hour);
            when(timeProvider.getTime())
                    .thenReturn(getCalendar.getCalendar(hour));

            Assertions.assertEquals(expectedAnswer, helloRedesigned.sayHello());
        }
    }

    // Longer but more readable way
    @DisplayName("Should say Good Morning")
    @ParameterizedTest(name = "It is {0}:00")
    @ValueSource(ints = {8, 9, 10, 11})
    public void shouldSayGoodMorning(int morningHour) {
        when(timeProvider.getTime())
                .thenReturn(getCalendar.getCalendar(morningHour));
        Assertions.assertEquals("Good Morning!", helloRedesigned.sayHello());
    }

    @DisplayName("Should say Good Afternoon")
    @ParameterizedTest(name = "It is {0}:00")
    @ValueSource(ints = {12, 13, 14, 15, 16, 17})
    public void shouldSayGoodAfternoon(int afternoonHour) {
        when(timeProvider.getTime())
                .thenReturn(getCalendar.getCalendar(afternoonHour));
        Assertions.assertEquals("Good Afternoon!", helloRedesigned.sayHello());
    }

    @DisplayName("Should say Good Evening")
    @ParameterizedTest(name = "It is {0}:00")
    @ValueSource(ints = {18, 19, 20, 21})
    public void shouldReturnGoodEvening(int eveningHour) {
        when(timeProvider.getTime())
                .thenReturn(getCalendar.getCalendar(eveningHour));
        Assertions.assertEquals("Good Evening!", helloRedesigned.sayHello());
    }

    @DisplayName("Should say Good Night")
    @ParameterizedTest(name = "It is {0}:00")
    @ValueSource(ints = {22, 23, 24, 1, 2, 3, 4, 5, 6, 7})
    public void shouldReturnGoodNight(int nightHour) {
        when(timeProvider.getTime())
                .thenReturn(getCalendar.getCalendar(nightHour));
        Assertions.assertEquals("Good Night!", helloRedesigned.sayHello());
    }
}
