package com.rabo.customer.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabo.customer.controller.CustomerStmtController;
import com.rabo.customer.models.CustomerStatement;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerStmtController.class, secure = false)

public class TestCustomerStmt {

	private CustomerStatement customerStmt;

	private String customerStmtJson;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Before
	public void init() throws JsonParseException, JsonMappingException, IOException {

		customerStmtJson = retriveJsonString();
		MockitoAnnotations.initMocks(this);
	}

	private String retriveJsonString() throws JsonParseException, JsonMappingException, IOException {
		// customerStmt = objectMapper.readValue(new File("F:\\rabo\\Custrecords.json"),
		// CustomerStatement.class);
		// customerStmtJson = objectMapper.writeValueAsString(customerStmt);

		return "[\r\n" + "  {\r\n" + "    \"txnReference\": 194261,\r\n"
				+ "    \"acountNumber\": \"NL91RABO0315273637\",\r\n"
				+ "    \"description\": \"Clothes from Jan Bakker\",\r\n" + "    \"startBalance\": 21.6,\r\n"
				+ "    \"mutation\": -41.83,\r\n" + "    \"endBalance\": -20.23\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"txnReference\": 194262,\r\n" + "    \"acountNumber\": \"NL91RABO0315273637\",\r\n"
				+ "    \"description\": \"Clothes from Jan Bakker\",\r\n" + "    \"startBalance\": 21.6,\r\n"
				+ "    \"mutation\": -41.83,\r\n" + "    \"endBalance\": -20.23\r\n" + "  }\r\n" + "  ";
	}

	@Test
	public void customerStmtControllerTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/validateCustStmts")
				.accept(MediaType.APPLICATION_JSON).content(customerStmtJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
}