package com.example.pickspot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import Model.Container;
import Model.Slot;
import Service.PickerService;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

// this class contains unit tests for the 'PickspotApplication' class
@SpringBootTest
class PickspotApplicationTests {
    
    // create an instance of PickerService to be tested
    private final PickerService picker = new PickerService();

    // test case to check the behavior when all slots are occupied
    @Test
    void testFullYardReturnsEmpty() {
        // create a sample container object to be placed in the yard
        Container container = new Container(); // The fields of 'Container' need to be initialized if required
        
        // create a slot that is occupied (no room for the container)
        Slot slot = new Slot(0, 1, "small", false, true); // The slot is at position (0,1), small size, no cold unit, and occupied
        
        // create a list with just this one occupied slot
        List<Slot> full = List.of(slot);

        // test the pickers behavior- since the slot is occupied, the picker should return an empty Optional
        assertTrue(picker.chooseBestSlot(container, full).isEmpty());
    }
}
