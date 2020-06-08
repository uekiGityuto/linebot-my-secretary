package com.example.service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.api.PushForecastController;
import com.example.api.PushGarbageController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScheduledTaskService {

	@Autowired
	PushGarbageController pushGarbageController;
	@Autowired
	PushForecastController pushForecastController;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	// cron書式(<second> <minute> <hour> <day-of-month> <month> <day-of-week>　<year>)※<year>は省略可

	// 燃やすごみのリマインドをスケジューリング(毎週月・金曜日)
	@Scheduled(cron = "0 0 20 * * MON,THU", zone = "Asia/Tokyo")
	public void executeBurnableGarbageRemind() {
		try {
			// pushする処理を呼び出す
			pushGarbageController.burnableGarbageRemind();
		} catch (URISyntaxException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

	// 紙・布類ごみのリマインドをスケジューリング(毎週日曜日)
	@Scheduled(cron = "0 0 20 * * SUN", zone = "Asia/Tokyo")
	public void executePaperGarbageRemind() {
		try {
			// pushする処理を呼び出す
			pushGarbageController.paperGarbageRemind();
		} catch (URISyntaxException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

	// びん・かん・ペットボトル類ごみのリマインドをスケジューリング(毎週金曜日)
	@Scheduled(cron = "0 0 20 * * FRI", zone = "Asia/Tokyo")
	public void executeBottleGarbageRemind() {
		try {
			// pushする処理を呼び出す
			pushGarbageController.bottleGarbageRemind();
		} catch (URISyntaxException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

	// 金属・陶器・ガラスごみのリマインドをスケジューリング(翌日が第一・第三水曜日の火曜日)
	@Scheduled(cron = "0 0 20 * * TUE", zone = "Asia/Tokyo")
	public void executeMetalGarbageRemind() {
		// 翌日が第一・第三水曜日であれば処理を行う
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		if ((day >= 1 && day <= 7) || (day >= 15 && day <= 21)) {
			try {
				// pushする処理を呼び出す
				pushGarbageController.metalGarbageRemind();
			} catch (URISyntaxException e) {
				log.error("{}", e);
			}
			log.info("cron executed : " + sdf.format(new Date()));
		}
	}

	// びん・かん・ペットボトル類ごみのリマインドをスケジューリング(毎週金曜日)
	@Scheduled(cron = "0 0 6 * * *", zone = "Asia/Tokyo")
	public void executeRainRemind() {
		try {
			// pushする処理を呼び出す
			pushForecastController.rainRemind();
		} catch (MalformedURLException e) {
			log.error("{}", e);
		}
		log.info("cron executed : " + sdf.format(new Date()));
	}

}