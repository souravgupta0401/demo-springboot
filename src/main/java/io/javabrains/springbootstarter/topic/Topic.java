package io.javabrains.springbootstarter.topic;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@DynamoDBTable(tableName="Topics")
public class Topic {
	
	@DynamoDBHashKey(attributeName="Id")
	private String Id;
	@DynamoDBAttribute
	private String topic;
	@DynamoDBAttribute
	private String desc;
	public Topic() {
		
	}
	public Topic(String id, String topic, String desc) {
		super();
		this.Id = id;
		this.topic = topic;
		this.desc = desc;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		this.Id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
