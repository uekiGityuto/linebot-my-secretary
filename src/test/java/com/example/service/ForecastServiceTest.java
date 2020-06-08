package com.example.service;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ForecastServiceTest {
	
	@Autowired
	ForecastService forecastService;

	@Test
	void testIsRain() throws IOException{
		if(forecastService.isRain()) {
			System.out.println("今日は雨が降るから傘を忘れずに！");
		} else {
			System.out.println("今日は雨は降らないよ！");
		}
	}

}
