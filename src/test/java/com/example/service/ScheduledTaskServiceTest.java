package com.example.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

//cronのテストはPCの時刻を変更したうえでLineBotMySecretaryApplicationのmainメソッドを実行して確認する
@SpringBootTest
@Slf4j
class ScheduledTaskServiceTest {

	ScheduledTaskService scheduledTaskService = new ScheduledTaskService();
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@Test
	void testExecuteMetalGarbageRemind() {

		log.info("now : " + sdf.format(new Date()));
		scheduledTaskService.executeMetalGarbageRemind();
	}

}
