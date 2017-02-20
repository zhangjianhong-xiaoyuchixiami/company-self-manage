package org.qydata.tools;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by jonhn on 2017/2/15.
 */
public class SendEmail {

    /**
     * 发送激活邮件
     * @param to 收件人邮箱地址
     * @param code 激活码
     */
    public static boolean sendMail(String to, String code) {

        try {
            Properties props = new Properties();
            props.put("username", "17316206369@163.com");
            props.put("password", "jzzjh8866");
            props.put("mail.transport.protocol", "smtp" );
            props.put("mail.smtp.host", "smtp.163.com");
            props.put("mail.smtp.port", "25" );
            Session mailSession = Session.getInstance(props);

            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress("17316206369@163.com"));
            msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject("激活邮件");
            msg.setContent("<h1>此邮件为激活账号邮件！请点击下面链接完成激活操作！</h1><h3><a href='http://localhost/user/action?code="+code+"'>http://localhost/user/action</a></h3>","text/html;charset=UTF-8");
            msg.saveChanges();

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(props.getProperty("mail.smtp.host"), props
                    .getProperty("username"), props.getProperty("password"));
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 发送修改密码邮件
     * @param to 收件人邮箱地址
     * @param password 激活码
     */
    public static boolean sendForgotMail(String to, String password) {

        try {
            Properties props = new Properties();
            props.put("username", "17316206369@163.com");
            props.put("password", "jzzjh8866");
            props.put("mail.transport.protocol", "smtp" );
            props.put("mail.smtp.host", "smtp.163.com");
            props.put("mail.smtp.port", "25" );
            Session mailSession = Session.getInstance(props);

            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress("17316206369@163.com"));
            msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject("修改密码邮件");
            msg.setContent("<h1>此邮件为修改账号密码邮件！请点击下面链接完成修改操作！</h1><h3><a href='http://localhost/user/update-password?email="+to+"&password="+password+"'>http://localhost/user/action</a></h3>","text/html;charset=UTF-8");
            msg.saveChanges();

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(props.getProperty("mail.smtp.host"), props
                    .getProperty("username"), props.getProperty("password"));
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
