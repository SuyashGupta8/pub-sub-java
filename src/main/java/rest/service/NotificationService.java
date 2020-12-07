package rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojo.Notifications;
import services.BuildTopic;
import services.DataPublisher;
import utils.Configurations;
import utils.JsonParser;

@RestController
@RequestMapping(path = "/notifications")
public class NotificationService {

    @Autowired
    private BuildTopic bTopic ;

    @Autowired
    private DataPublisher publisher;

    @PostMapping(path = "/members", consumes = "application/json", produces = "application/json")
    public ResponseEntity create( @RequestBody Notifications notification) {

        Configurations configurations = JsonParser.getConfigurations();

        try{
            bTopic.createTopic(configurations.getProjectId(), configurations.getTopic());
            publisher.publish(configurations.getProjectId(), configurations.getTopic(), notification);

        }catch(Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok(200);

        // make sure to check whether the new person does not already exist
        //return ResponseEntity.ok(personService.save(person));
    }
}
