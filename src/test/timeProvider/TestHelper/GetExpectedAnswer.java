package test.timeProvider.TestHelper;

public class GetExpectedAnswer {
    private String expectedAnswer;

    public String getExpectedAnswer(int hour) {
        if (hour >= 8 && hour < 12) {
            expectedAnswer = "Good Morning!";
        } else if (hour >= 12 && hour < 18) {
            expectedAnswer = "Good Afternoon!";
        } else if (hour >= 18 && hour < 22) {
            expectedAnswer = "Good Evening!";
        } else {
            expectedAnswer = "Good Night!";
        }

        return expectedAnswer;
    }
}
