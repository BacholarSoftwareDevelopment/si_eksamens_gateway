package dk.si.exam.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;

@RestController
public class GatewayController {

    @Autowired
    private MessageClient messageClient;

    @PostMapping("/message")
    public String sendMessage(@RequestBody Message message){
        return messageClient.test(message);
    }

}
