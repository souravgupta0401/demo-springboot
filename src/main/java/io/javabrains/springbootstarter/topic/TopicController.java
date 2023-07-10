package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		System.out.println("Hello");
		return topicService.getAllTopics();
	}
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id){
		return topicService.getTopic(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void updateTopic(@RequestBody Topic topic) {
		topicService.updateTopic(topic);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void setTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.setTopic(id,topic);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	

}
