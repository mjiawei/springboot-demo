package com.jiawei.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jiawei.utils.EmailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @RequestMapping("sendEmail")
    public String sendEmail() throws JsonProcessingException {
        logger.info("开始发送邮件");
        boolean isSend = EmailUtils.sendEmail("这是一封测试邮件", new String[]{"mjiawei@126.com"}, null, "<h3><a href='http://www.baidu.com'>百度一下，你就知道</a></h3>", null);
        logger.info("邮件发送完成");
        return "发送邮件:" + isSend;

    }
}
