package io.javabrains.springbootstarter.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
@Repository
public class TopicRepositoryCRUD implements TopicRepository{
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public List<Topic> findAll(){
		DynamoDBScanExpression dynamoDBScanExpression = new DynamoDBScanExpression();
		PaginatedScanList<Topic> result = dynamoDBMapper.scan(Topic.class,dynamoDBScanExpression);
		return result.subList(0, result.size());
		
	}
	//queryExpression?

	public Topic findById(String id){
		//Topic t1;
		return dynamoDBMapper.load(Topic.class,id);
	}
	public void save(Topic topic) {
		dynamoDBMapper.save(topic);
	}
	public void deleteById(String id) {
		Topic t = new Topic();
		t.setId(id);
		Topic result = dynamoDBMapper.load(t);
		dynamoDBMapper.delete(result);
	}
}
