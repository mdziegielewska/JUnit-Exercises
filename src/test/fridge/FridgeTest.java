package test.fridge;

import main.fridge.Fridge;
import main.fridge.NoSuchItemException;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@DisplayName("Fridge test")
public class FridgeTest {
    @BeforeEach
    public void initTest() {
        Fridge fridge = new Fridge();
        String[] food = new String[]{"egg", "milk", "ham"};

        for(String f : food) {
            fridge.put(f);
        }
    }

    @AfterAll
    public void endTest() {

    }
}
