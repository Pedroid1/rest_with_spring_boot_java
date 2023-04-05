package br.com.pedroid1;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String TEMPLATE_STRING = "Hello, %s!";
	private static final AtomicLong COUNTER_ATOMIC_LONG = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(COUNTER_ATOMIC_LONG.incrementAndGet(), String.format(TEMPLATE_STRING, name));
	}
}
