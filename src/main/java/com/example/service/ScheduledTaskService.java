package com.example.service;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.api.PushConfirmController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScheduledTaskService {
	
	@Autowired PushConfirmController pushConfirmController;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    //cron書式(<second> <minute> <hour> <day-of-month> <month> <day-of-week> <year>)※<year>は省略可
    @Scheduled(cron="0 0 20 ? ** MON,THU", zone = "Asia/Tokyo")
    //@Scheduled(initialDelay=0, fixedDelay=100000)
    public void executeAlarm() {
        try {
            //pushする処理を呼び出す
        	pushConfirmController.pushAlarm();
        } catch (URISyntaxException e) {
            log.error("{}", e);
        }
        log.info("cron executed : " + sdf.format(new Date()));
    }
}