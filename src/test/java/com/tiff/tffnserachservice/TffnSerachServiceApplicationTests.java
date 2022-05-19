package com.tiff.tffnserachservice;

import com.tiff.tffnserachservice.controller.TiffnerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class TffnSerachServiceApplicationTests {

	@Autowired
	TiffnerController tiffnerController;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(tiffnerController);
	}

}
