package com.example.api;

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BasicInfo;
import com.example.service.ForecastService;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;

import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PushForecastController {

	@Autowired
	ForecastService forecastService;

	private String CHANNEL_TOKEN = BasicInfo.CHANNEL_TOKEN;
	private String USER_ID = BasicInfo.USER_ID;
	LineMessagingClient client = LineMessagingClient.builder(CHANNEL_TOKEN).build();

	// 雨の予報であれば傘を持っていくようにリマインドをpush
	@GetMapping("forecast")
	public void rainRemind() throws MalformedURLException {
		try {
			if (forecastService.isRain()) {
				BotApiResponse response = client
						.pushMessage(new PushMessage(USER_ID, new TextMessage("今日は雨が降るから傘を忘れずに！\n詳細は天気予報確認してね！"))).get();
				log.info("Sent messages: {}", response);
			} else {
				BotApiResponse response = client
						.pushMessage(new PushMessage(USER_ID, new TextMessage("今日は雨が降らないから洗濯しても良いかも！\n詳細は天気予報確認してね！"))).get();
				log.info("Sent messages: {}", response);
			}
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

}
