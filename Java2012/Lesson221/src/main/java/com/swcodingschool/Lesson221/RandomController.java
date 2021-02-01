package com.swcodingschool.Lesson221;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Step 3. Create a Resource Controller.
 */
@RestController
public class RandomController {

	
	@GetMapping("/random")
	public Random greeting() {
		return new Random();
	}

}
