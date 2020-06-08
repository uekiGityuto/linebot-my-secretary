package com.example.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Epoch2Date {
	
	public static String getDateFromEpoch(long epochtime){
		 
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    return sdf.format(new Date(epochtime*1000));
	 
	}

}
