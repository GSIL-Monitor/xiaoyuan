package com.project.xiaoyuan.MyTest;

import com.project.common.mail.MyMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Resource
    MyMailService myMailService;

    @Test
    public void testSimple() {
        myMailService.sendSimpleMail("1774328193@qq.com",
                "这是一份邮件",
                "Do you want for code ,best yourself");
    }

    @Test
    public void test1Html() throws Exception{
        myMailService.sendHtmlMail("1774328193@qq.com",
                "这是一份邮件",
                "Do you want for code ,best yourself");
    }

    @Test
    public void test1Attach() throws Exception{
        myMailService.sendAttachmentsHtmlMail("1774328193@qq.com",
                "这是一份邮件",
                "Do you want for code ,best yourself",
                "/mail/飞鸽.docx");
    }

}
