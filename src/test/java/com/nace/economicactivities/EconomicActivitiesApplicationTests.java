package com.nace.economicactivities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EconomicActivitiesApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void integrationTest_RetrieveNACEDataFromDBUsingTheEndpoints() throws Exception {
		this.mockMvc.perform(get("/getNaceDetails")).andExpect(status().is2xxSuccessful());
		this.mockMvc.perform(get("/getNaceDetails/399469")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Undifferentiated goods-producing activities of private households for own use")));
	}
}

