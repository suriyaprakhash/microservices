package com.suriya.ms.client.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// SpringRunner is short hand for SpringJUnit4ClassRunner which extends 
// BlockJUnit4ClassRunner providing the functionality to launch a Spring TestContext Framework.
@RunWith(SpringRunner.class)
// WebMvcTest annotation is used for unit testing Spring MVC application. This
// can be used when a test focuses only Spring MVC components. In this test, we
// want to launch only FileUploadController. All other controllers and mappings
// will not be launched when this unit test is executed.
@WebMvcTest(value = FileUploadController.class, secure = false)
public class FileUploadControllerTest {

	// MockMvc is the main entry point for server-side Spring MVC test support. It
	// allows us to execute requests against the test context.
	@Autowired
	MockMvc mockMvc;

	@Test
	public void fileUpdloadTest() throws Exception {
		MockMultipartFile firstFile = new MockMultipartFile("inputfile", "filename.txt", "text/plain",
				"some xml".getBytes());
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/uploadfile").file(firstFile)).andExpect(status().is(200))
				.andExpect(content().string("true"));
	}

	@Test
	public void startTest() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/start")).andExpect(status().is(200))
				.andReturn();
		assertEquals("ready suriya", mvcResult.getResponse().getContentAsString());
	}

}
