package de.wi2020sebgroup1.cinema.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.wi2020sebgroup1.cinema.model.User;
import de.wi2020sebgroup1.cinema.repo.UserRepo;

@SpringBootTest
public class UserControllerTest {
	
	MockMvc mvc;
	
	@Autowired
	@MockBean
	UserRepo repo;
    
    @Autowired
    WebApplicationContext wac;
	
	JacksonTester<User> jt;
	
	static User u1;
	static User u2;
	static User u3;
	static List<User> users = new ArrayList<>();
	
	@BeforeAll
	static void beforeAll() {
		u1 = new User("Mathis", "Neunzig", "mathis.neunzig@gmail.com");
		u1.setId(1);
		u2 = new User("Kitty", "Blume", "kitty.blume@gmail.com");
		u2.setId(2);
		u3 = new User("Totoro", "Miyasaki", "tonarinototoro@floof.gov.jp");
		u3.setId(3);
    	users.add(u1);
    	users.add(u2);
    	users.add(u3);
	}

    @BeforeEach
    void beforeEach() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
    @Test
    void testGetAll() throws Exception {
    	when(repo.findAll()).thenReturn(users);
        MvcResult result = this.mvc.perform(get("/api/v1/users"))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
            
        assertTrue(result.getResponse().getContentAsString().contains("\"id\":1"));
        assertTrue(result.getResponse().getContentAsString().contains("\"id\":2"));
        assertTrue(result.getResponse().getContentAsString().contains("\"id\":3"));
    }
	
}
