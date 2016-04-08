package initialisation.mess.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import initialisation.mess.service.SampleService;

@Component
public class ServiceInitialiserFacsimile {

    private final SampleService sampleService;

    @Autowired
    public ServiceInitialiserFacsimile(SampleService ss) {
        this.sampleService = ss;
    }

    @PostConstruct
    public void initialiseAllTheServices() {
        this.sampleService.init();
    }

}
