package dk.si.exam.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GatewayController {

    @Autowired
    private MessageClient messageClient;

    @Autowired
    private MessageReceiveClient messageReceiveClient;

    @PostMapping("/message")
    public String sendMessage(@RequestBody Message message){
        return messageClient.send(message);
    }

    @GetMapping("/message/{userId}/{topic}")
    public List<Message> receiveMessage(@PathVariable("userId") String userId, @PathVariable("topic") String topic){
        return messageReceiveClient.receive(userId, topic);
    }

}
