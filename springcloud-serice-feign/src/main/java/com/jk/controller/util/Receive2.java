package com.jk.controller.util;

import com.jk.controller.ConstansConf;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

import static com.jk.controller.ConstansConf.sendEmailAccount;
import static com.jk.controller.ConstansConf.sendtitle;

/*
 *  孙丽景
 *
 *  发送邮箱
 */
@Component
@RabbitListener(queues = "topic_2")
public class Receive2 {

    @RabbitHandler
    public void process(String hello){



        try {
            // 参数配置
            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.smtp.host", ConstansConf.sendEmailSMTPHost);
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            // 根据配置创建会话对象, 用于和邮件服务器交互
            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);   // 设置为debug模式, 可以查看详细的发送 log
            // 创建一封邮件
            //Message message = createMimeMessage(session, sendEmailAccount, receiveMailAccount);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ConstansConf.sendEmailAccount));
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(hello));
            // 设置邮件标题
            message.setSubject(ConstansConf.sendtitle);
            // 设置邮件正文
            message.setText(ConstansConf.sendcontent);
            message.setSentDate(new Date());
            //保存设置
            message.saveChanges();

            // 根据 Session 获取邮件传输对象
            Transport transport = session.getTransport();
            // 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则会报错
            transport.connect(ConstansConf.sendEmailAccount, ConstansConf.sendEmailPassword);
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());
            // 关闭连接
            transport.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }



        System.out.println("发送邮件:" + hello);
    }
}
