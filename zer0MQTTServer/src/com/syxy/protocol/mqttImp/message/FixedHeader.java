package com.syxy.protocol.mqttImp.message;

import io.netty.util.internal.StringUtil;

/**
 * Mqtt协议的固定头部，有一个字节，由四个字段组成
 * 
 * @author zer0
 * @version 1.0
 * @date 2016-3-3
 */
public class FixedHeader {
	private final MessageType messageType;
	private boolean dup; //MQTT协议头第5bit，代表打开标志，表示是否第一次发送
	private QoS qos; //MQTT协议头前6,7bit，代表服务质量
	private boolean retain; //MQTT协议头第8bit，代表是否保持
	private int messageLength; //第二个字节
	
	public FixedHeader(MessageType messageType,
					   boolean dup,
					   QoS qos,
					   boolean retain,
					   int messageLength){
		this.messageType = messageType;
		this.dup = dup;
		this.qos = qos;
		this.retain = retain;
		this.messageLength = messageLength;
	}

	public boolean isDup() {
		return dup;
	}

	public void setDup(boolean dup) {
		this.dup = dup;
	}

	public QoS getQos() {
		return qos;
	}

	public void setQos(QoS qos) {
		this.qos = qos;
	}

	public boolean isRetain() {
		return retain;
	}

	public void setRetain(boolean retain) {
		this.retain = retain;
	}

	public int getMessageLength() {
		return messageLength;
	}

	public void setMessageLength(int messageLength) {
		this.messageLength = messageLength;
	}

	public MessageType getMessageType() {
		return messageType;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(StringUtil.simpleClassName(this))
					 .append('[')
					 .append("messageType=").append(messageType)
					 .append(", isDup=").append(dup)
					 .append(", qosLevel=").append(qos)
					 .append(", isRetain=").append(retain)
					 .append(", messageLength=").append(messageLength)
					 .append(']');
		return stringBuilder.toString();
	}
	
}
