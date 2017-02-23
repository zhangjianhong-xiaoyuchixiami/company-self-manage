package org.qydata.tools;

import org.apache.commons.mail.HtmlEmail;

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
            HtmlEmail email = new HtmlEmail   ();

            email.setTLS(true);
            //发送主机服务器
            email.setHostName("smtp.mxhichina.com");
            //登陆邮件服务器的用户名和密码
            email.setAuthentication("member@qianyandata.com", "92f!x.8fce0e65");
            //发送人
            email.setFrom("member@qianyandata.com");
            //接收人
            email.addTo(to);
            //标题
            email.setSubject("激活邮件");
            //编码
            email.setCharset("utf-8");
            //内容
            email.setHtmlMsg("<html><h1>此邮件为激活账号邮件！请点击下面链接完成激活操作</h1><h3><a href='http://localhost/user/action?code="+code+"'>http://localhost/user/action</a></h3></html>");
            //发送
            email.send();
        }catch (Exception e) {
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
            HtmlEmail email = new HtmlEmail   ();

            email.setTLS(true);
            //发送主机服务器
            email.setHostName("smtp.mxhichina.com");
            //登陆邮件服务器的用户名和密码
            email.setAuthentication("member@qianyandata.com", "92f!x.8fce0e65");
            //发送人
            email.setFrom("member@qianyandata.com");
            //接收人
            email.addTo(to);
            //标题
            email.setSubject("修改密码邮件");
            //编码
            email.setCharset("utf-8");
            //内容
            email.setHtmlMsg("<html><h1>此邮件为修改账号密码邮件！请点击下面链接完成修改操作！</h1><h3><a href='http://localhost/user/update-password?email="+to+"&password="+password+"'>http://localhost/user/update-password</a></h3>");
            //发送
            email.send();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * javax.mail发送邮件
     * @param to
     * @param code
     * @return
     */
    public static boolean sendMailOld(String to,String code){
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

}


