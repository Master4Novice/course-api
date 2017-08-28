package io.abhi.ctrlr;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.abhi.data.Topics;

@RestController
public class TopicController {

	@RequestMapping("/topics")
	public List<Topics> getAllTopics() {
		return Arrays.asList(
				new Topics(1001,"Java","Java Language"),
				new Topics(1002,"C++","C++ Language"),
				new Topics(1003,"C","C Language")
				);
	}
}
