package com.bridgelabz.demo.service.implementors;

import com.bridgelabz.demo.model.Greeting;
import com.bridgelabz.demo.model.User;
import com.bridgelabz.demo.repositories.IGreetingRepository;
import com.bridgelabz.demo.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello  %s !";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = user.toString().isEmpty() ? "Hello World" : user.getFirstName()+ " "+user.getLastName();
        Greeting greeting=new Greeting();
        greeting.setIncrementAndGet(counter.incrementAndGet());
        greeting.setFormat(message);
        return greetingRepository.save(greeting);
    }
}
