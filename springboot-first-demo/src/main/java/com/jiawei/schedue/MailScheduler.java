package com.jiawei.schedue;

import com.jiawei.utils.EmailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class MailScheduler {


    private static final Logger logger = LoggerFactory.getLogger(MailScheduler.class);

    @Scheduled(cron="0 0/1 * * * ?") //每分钟执行一次
    public void email(){
        logger.info("定时邮件==start!");
        LocalDateTime localDateTime = LocalDateTime.now();
        boolean isSend = EmailUtils.sendEmail("定时邮件", new String[]{"mengmeng.zhao@BKJK.com"}, null, "<h3><a href='http://www.baidu.com'>百度一下，你就知道</a></h3>", null);
        logger.info("定时邮件发送："+isSend+"==end!");
    }
}
