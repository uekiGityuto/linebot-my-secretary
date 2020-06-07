package com.example.api;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@LineMessageHandler
public class WebhookController {

	// テキストが送られてきた際の応答処理
	@EventMapping
	public Message handleTextMessageEvent(MessageEvent<TextMessageContent> event) throws Exception {
		log.info("event: {}", event);

		// 入力されたテキストの取得
		TextMessageContent content = event.getMessage();
		// String replyToken = event.getReplyToken();
		String text = content.getText();

		// 入力されたテキストの内容に応じて応答
		switch (text) {
		case "はい":
			log.info("Returns echo message:さっすがー！");
			return new TextMessage("さっすがー！");
		case "いいえ":
			log.info("Returns echo message:捨てにいきましょー！");
			return new TextMessage("捨てにいきましょー！");
		default:
			log.info("Returns echo message: {}", text);
			return new TextMessage(text);
		}
	}

	@EventMapping
	public void handleDefaultMessageEvent(Event event) {
		log.info("event: {}", event);
	}

}