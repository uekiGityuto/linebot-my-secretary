package com.example.api;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PushGarbageControllerTest {

	@Autowired
	PushGarbageController pushGarbageController;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@Test
	public void TestBurnableGarbageRemind() {
		try {
			pushGarbageController.burnableGarbageRemind();
		} catch (URISyntaxException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

	@Test
	public void TestRecyclableGarbageRemind() {
		try {
			pushGarbageController.paperGarbageRemind();
		} catch (URISyntaxException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

	@Test
	public void TestBottleGarbageRemind() {
		try {
			pushGarbageController.bottleGarbageRemind();
		} catch (URISyntaxException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

	@Test
	public void TestMetalGarbageRemind() {
		try {
			pushGarbageController.metalGarbageRemind();
		} catch (URISyntaxException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

}
