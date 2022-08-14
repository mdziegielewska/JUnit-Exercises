package main.fridge;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for exercises.
 * Visit <a href="http://practicalunittesting.com">...</a> for more information.
 *
 * @author Tomek Kaczanowski
 */

public class NoSuchItemException extends Exception {
    public NoSuchItemException(String message) {
        super(message);
    }
}
