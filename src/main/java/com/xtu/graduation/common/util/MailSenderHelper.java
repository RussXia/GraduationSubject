package com.xtu.graduation.common.util;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


public class MailSenderHelper {
	private JavaMailSender mailSender;// 注入Spring封装的javamail，Spring的xml中已让框架装配  
    private TaskExecutor taskExecutor;// 注入Spring封装的异步执行器  
    
    private Log log = LogFactory.getLog(getClass());  
    private StringBuffer message = new StringBuffer();
    /**
     * 发送邮件
     * @param fromAddress	发件人
     * @param toAddress		收件人  
     * @param subject		邮件主题
     * @param content		邮件内容
     * @throws MessagingException
     * @throws IOException
     */
    public void sendMail(String fromAddress, String toAddress,String subject,String content ) throws MessagingException, IOException {  
        /*if (email.getAddress().length > 5) {// 收件人大于5封时，采用异步发送 
            sendMailByAsynchronousMode(email); 
            this.message.append("收件人过多，正在采用异步方式发送...<br/>"); 
        } else {*/  
        sendMailBySynchronizationMode( fromAddress,  toAddress, subject, content );  
        //this.message.append("正在同步方式发送邮件...<br/>");  
        //}  
    }  
    
    /**
     * 异步发送邮件
     * @param fromAddress	发件人
     * @param toAddress		收件人  
     * @param subject		邮件主题
     * @param content		邮件内容
     */
    public void sendMailByAsynchronousMode( final String fromAddress, final String toAddress,final String subject,final String content) {  
        taskExecutor.execute(new Runnable() {  
            public void run() {  
                try {  
                    sendMailBySynchronizationMode(fromAddress, toAddress,subject,content);  
                } catch (Exception e) {  
                    log.info(e);  
                }  
            }  
        });  
    }  
    /**
     * 同步发送邮件
     * @param fromAddress	发件人
     * @param toAddress		收件人  
     * @param subject		邮件主题
     * @param content		邮件内容
     * @throws MessagingException
     * @throws IOException
     */
    public void sendMailBySynchronizationMode( String fromAddress, String toAddress,String subject,String content )  
            throws MessagingException, IOException {  
        MimeMessage mime = mailSender.createMimeMessage();  
        MimeMessageHelper helper = new MimeMessageHelper(mime, true, "utf-8");  
        helper.setFrom(fromAddress);// 发件人  
        helper.setTo(toAddress);// 收件人  
        helper.setReplyTo(fromAddress);// 回复到  
        helper.setSubject(subject);// 邮件主题  
        helper.setText(content, true);// true表示设定html格式  
        mailSender.send(mime);  
    }  
    
    
    
	/**
	 * @return the mailSender
	 */
	public JavaMailSender getMailSender() {
		return mailSender;
	}
	/**
	 * @param mailSender the mailSender to set
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	/**
	 * @return the taskExecutor
	 */
	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}
	/**
	 * @param taskExecutor the taskExecutor to set
	 */
	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	/**
	 * @return the log
	 */
	public Log getLog() {
		return log;
	}
	/**
	 * @param log the log to set
	 */
	public void setLog(Log log) {
		this.log = log;
	}
	/**
	 * @return the message
	 */
	public StringBuffer getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(StringBuffer message) {
		this.message = message;
	}  
}
