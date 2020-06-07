package com.example.api;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@RunWith(SpringRunner.class)
@SpringBootTest
public class PushConfirmControllerTest {
	
	PushConfirmController pushConfirmController = new PushConfirmController();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	@Test
	public void execute() {
		try {
			pushConfirmController.pushAlarm();
		} catch (URISyntaxException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

}
