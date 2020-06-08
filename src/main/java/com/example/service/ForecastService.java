package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.example.gson.Forecast;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ForecastService {

	public boolean isRain() throws MalformedURLException {

		String commonUrl = "http://api.openweathermap.org/data/2.5/forecast";
		String cityId = "1850144";
		String appId = "e98cb41ace2ace29dedc832af2bd9a2f";
		String requestURL = commonUrl + "?id=" + cityId + "&units=metric&APPID=" + appId;
		URL url = new URL(requestURL);
		log.info("URL:{}", requestURL);
		String jsonData = null;

		// JSON形式で天気予報を取得
		try (InputStream is = url.openStream();) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			jsonData = sb.toString();
			log.info("Weather forecast results(JSON):{}:", jsonData);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// JSONデータをPOJOにマッピング
		Gson gson = new Gson();
		Forecast forecast = gson.fromJson(jsonData, Forecast.class);

		// 現在～15時間後までの3時間毎の予報を取り出し、雨の予報があればTRUEを返す
		for (int i = 0; i < 5; i++) {
			long epoch = forecast.list.get(i).dt;
			log.info("日時:{}", Epoch2Date.getDateFromEpoch(epoch));
			log.info("天気(description):{}", forecast.list.get(i).weather.get(0).description);
			String icon = forecast.list.get(i).weather.get(0).icon;
			log.info("天気(icon):{}", icon);
			switch (icon) {
			case "01d":
			case "01n":
			case "02d":
			case "02n":
			case "03d":
			case "03n":
			case "04d":
			case "04n":
			case "50d":
			case "50n":			
				break;
			case "09d":
			case "09n":
			case "10d":
			case "10n":
			case "11d":
			case "11n":
			case "13d":
			case "13n":
				return true;
			}
		}
		return false;
	}

}
