package com.example.api;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class PushForecastControllerTestTest {

	@Autowired
	PushForecastController pushForecastController;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@Test
	public void TestRainRemind() {
		try {
			pushForecastController.rainRemind();
		} catch (MalformedURLException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

}
