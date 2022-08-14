package main.car;

import java.awt.*;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for exercises.
 * Visit <a href="http://practicalunittesting.com">...</a> for more information.
 *
 * @author Tomek Kaczanowski
 */

public interface Car {
    Engine getEngine();

    Color getColor();

    Manufacturer getManufacturer();
}