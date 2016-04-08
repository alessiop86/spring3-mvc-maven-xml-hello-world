package initialisation.mess.service;

import org.springframework.stereotype.Service;

import initialisation.mess.annotations.DoAdditionalStuff;

@Service
public class SampleService {

    public void init() {
        System.out.println("do some stuff");
        try {
            execute();
        }
        catch(Exception e) {
            System.err.println("I do not want to block to whole framework initialisation");
        }
    }

    @DoAdditionalStuff
    public void execute() {
        System.out.println("Phase 1");
    }
}
