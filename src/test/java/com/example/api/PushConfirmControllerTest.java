package com.example.api;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PushConfirmControllerTest {

	PushConfirmController pushConfirmController = new PushConfirmController();
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@Test
	public void TestBurnableGarbageRemind() {
		try {
			pushConfirmController.burnableGarbageRemind();
		} catch (URISyntaxException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

	@Test
	public void TestRecyclableGarbageRemind() {
		try {
			pushConfirmController.paperGarbageRemind();
		} catch (URISyntaxException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

	@Test
	public void TestBottleGarbageRemind() {
		try {
			pushConfirmController.bottleGarbageRemind();
		} catch (URISyntaxException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

	@Test
	public void TestMetalGarbageRemind() {
		try {
			pushConfirmController.metalGarbageRemind();
		} catch (URISyntaxException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

}
