package io.javabrains.springbootstarter.topic;

import java.util.List;
import java.util.Optional;


public interface TopicRepository {
	public List<Topic> findAll();
	public Topic findById(String id);
	public void save(Topic topic);
	void deleteById(String id);
	
}
