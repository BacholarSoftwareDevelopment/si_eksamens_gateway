package dk.si.exam.gateway;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("consumer")
@RibbonClient(name = "consumer", configuration = RibbonConfig.class)
public interface MessageReceiveClient {

    @GetMapping("/kafka/message/{userId}/{topic}")
    List<Message> receive(String userId, String topic);
}

//@FeignClient("server")
//@RibbonClient(name = "server", configuration = RibbonConfig.class)
//public interface MessageClient {
//
//    @PostMapping("/test")
//    String test(Message message);
//}
