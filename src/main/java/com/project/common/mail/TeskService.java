package com.project.common.mail;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TeskService {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    //@Scheduled(fixedRate = 1000)
    @Scheduled(cron = "3-50 * * * * ?")
    public void reportCurrentTime(){
        System.out.println("当前时间是" + dateFormat.format(new Date()));
    }

}
