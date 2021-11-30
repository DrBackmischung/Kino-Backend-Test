package de.wi2020sebgroup1.cinema.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UserTest {
	
	@Test
    public void constructorTest() {
		User u = new User("Mathis", "Neunzig", "mathis.neunzig@gmail.com");
        assertEquals(u.getFirstName(), "Mathis");
        assertEquals(u.getLastName(), "Neunzig");
        assertEquals(u.getEmail(), "mathis.neunzig@gmail.com");
    }
	
}
