package com.codenotfound.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codenotfound.kafka.producer.Sender;

@RestController
public class MesgImpl {
	
	@Autowired
	Sender sender;
	
	@Value("${kafka.topic.helloworld}")
	String topicname;
	
	@RequestMapping("/send")
	public String sendmsg()
	{
		sender.send(topicname, "Hi..This is Kafka testing");
		return "msg sent!!";
	}
	

}
