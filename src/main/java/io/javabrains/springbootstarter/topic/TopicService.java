package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic>getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
		}
	public Topic getTopic(String id){
		return topicRepository.findById(id);
	}
	public void updateTopic(Topic topic) {
				topicRepository.save(topic);
	}
	public void setTopic(String id, Topic t1) {
				topicRepository.save(t1);
		}
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);;
	}
	
}
