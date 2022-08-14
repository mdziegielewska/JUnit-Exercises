package test.fridge;

import main.fridge.Fridge;
import main.fridge.NoSuchItemException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.fridge.TestHelper.CountItems;


@DisplayName("Fridge test")
public class FridgeTest {
    static Fridge fridge = new Fridge();
    static CountItems countItems = new CountItems();
    static String[] food = new String[]{"egg", "milk", "ham"};

    @DisplayName("Filling the fridge...")
    @BeforeAll
    public static void setUp() {
        for(String f : food) {
            if(!fridge.contains(f)) {
                fridge.put(f);
            }
        }

        Assertions.assertEquals(3, countItems.countAllItems(fridge));
    }

    @DisplayName("Fridge should contain")
    @ParameterizedTest(name = "Fridge should contain {0}")
    @ValueSource(strings = {"milk", "ham", "egg"})
    public void shouldContain(String item) {
        Assertions.assertTrue(fridge.contains(item), "true");
    }

    @DisplayName("Fridge should not contain")
    @ParameterizedTest(name = "Fridge should not contain {0}")
    @ValueSource(strings = {"cucumber", "salad", "yoghurt"})
    public void shouldNotContain(String item) {
        try {
            fridge.take(item);
        } catch (NoSuchItemException e) {
            Assertions.assertTrue(e.getMessage().contains(item));
        }
    }

    @DisplayName("Fridge should be empty")
    @Test
    public void shouldTakeAllExisingItems() throws NoSuchItemException {
        for(String f : food) {
            fridge.take(f);
        }

        Assertions.assertEquals(0, countItems.countAllItems(fridge));
    }
}
