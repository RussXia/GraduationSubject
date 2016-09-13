package com.xtu.graduation.message.enity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Xia
 * @since Message.java 2016年3月29日 
 */
@Entity
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long messageId;
	
	/** 信息发送者的id */
	private Long senderId;
	
	/** 信息发送者的用户类型:管理员、老师、学生 */
	private String senderUserType;
	
	/** 信息接受者的id */
	private Long reciverId;
	
	/**信息接受者的用户类型:管理员、老师、学生 */
	private String reciverUserType;
	
	/** 信息的内容 */
	private String messageContent;

	/**
	 * @return the messageId
	 */
	public Long getMessageId() {
		return messageId;
	}
	
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", senderId=" + senderId + ", senderUserType=" + senderUserType
				+ ", reciverId=" + reciverId + ", reciverUserType=" + reciverUserType + ", messageContent="
				+ messageContent + "]";
	}



	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the senderId
	 */
	public Long getSenderId() {
		return senderId;
	}

	/**
	 * @param senderId the senderId to set
	 */
	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	/**
	 * @return the senderUserType
	 */
	public String getSenderUserType() {
		return senderUserType;
	}

	/**
	 * @param senderUserType the senderUserType to set
	 */
	public void setSenderUserType(String senderUserType) {
		this.senderUserType = senderUserType;
	}

	/**
	 * @return the reciverId
	 */
	public Long getReciverId() {
		return reciverId;
	}

	/**
	 * @param reciverId the reciverId to set
	 */
	public void setReciverId(Long reciverId) {
		this.reciverId = reciverId;
	}

	/**
	 * @return the reciverUserType
	 */
	public String getReciverUserType() {
		return reciverUserType;
	}

	/**
	 * @param reciverUserType the reciverUserType to set
	 */
	public void setReciverUserType(String reciverUserType) {
		this.reciverUserType = reciverUserType;
	}

	/**
	 * @return the messageContent
	 */
	public String getMessageContent() {
		return messageContent;
	}

	/**
	 * @param messageContent the messageContent to set
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
}
