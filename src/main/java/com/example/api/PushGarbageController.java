package com.example.api;

import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BasicInfo;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.template.ConfirmTemplate;
import com.linecorp.bot.model.response.BotApiResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PushGarbageController {

	private String CHANNEL_TOKEN = BasicInfo.CHANNEL_TOKEN;
	private String USER_ID = BasicInfo.USER_ID;
	LineMessagingClient client = LineMessagingClient.builder(CHANNEL_TOKEN).build();

	// 燃やすゴミのリマインドをpush
	@GetMapping("garbage/burnable")
	public void burnableGarbageRemind() throws URISyntaxException {
		try {
			BotApiResponse response = client
					.pushMessage(new PushMessage(USER_ID, new TemplateMessage("明日は「燃やすごみ」の日だよ！",
							new ConfirmTemplate("明日は「燃やすごみ」の日だよ！\nごみ捨ては終わった？\nボタンを押して回答してね！",
									new MessageAction("はい", "ゴミ捨て完了！"), new MessageAction("いいえ", "まだゴミ捨てやってない、、")))))
					.get();
			log.info("Sent messages: {}", response);
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

	// 紙・布類ゴミのリマインドをpush
	@GetMapping("garbage/paper")
	public void paperGarbageRemind() throws URISyntaxException {
		try {
			BotApiResponse response = client
					.pushMessage(new PushMessage(USER_ID, new TemplateMessage("明日は「紙・布類ごみ」の日だよ！",
							new ConfirmTemplate("明日は「紙・布類ごみ」の日だよ！\nごみ捨ては終わった？\nボタンを押して回答してね！",
									new MessageAction("はい", "ゴミ捨て完了！"), new MessageAction("いいえ", "まだゴミ捨てやってない、、")))))
					.get();
			log.info("Sent messages: {}", response);
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

	// 紙・布類ごみのリマインドをpush
	@GetMapping("garbage/bottle")
	public void bottleGarbageRemind() throws URISyntaxException {
		try {
			BotApiResponse response = client
					.pushMessage(new PushMessage(USER_ID, new TemplateMessage("明日は「びん・かん・ペットボトル類ごみ」の日だよ！",
							new ConfirmTemplate("明日は「びん・かん・ペットボトル類ごみ」の日だよ！\nごみ捨ては終わった？\nボタンを押して回答してね！",
									new MessageAction("はい", "ゴミ捨て完了！"), new MessageAction("いいえ", "まだゴミ捨てやってない、、")))))
					.get();
			log.info("Sent messages: {}", response);
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

	// 金属・陶器・ガラスごみのリマインドをpush
	@GetMapping("garbage/metal")
	public void metalGarbageRemind() throws URISyntaxException {
		try {
			BotApiResponse response = client
					.pushMessage(new PushMessage(USER_ID, new TemplateMessage("明日は「金属・陶器・ガラスごみ」の日だよ！",
							new ConfirmTemplate("明日は「金属・陶器・ガラスごみ」の日だよ！\nごみ捨ては終わった？\nボタンを押して回答してね！",
									new MessageAction("はい", "ゴミ捨て完了！"), new MessageAction("いいえ", "まだゴミ捨てやってない、、")))))
					.get();
			log.info("Sent messages: {}", response);
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

}