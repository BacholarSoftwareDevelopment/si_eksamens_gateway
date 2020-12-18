package dk.si.exam.gateway;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("consumer")
@RibbonClient(name = "consumer", configuration = RibbonConfig.class)
public interface MessageReceiveClient {

    @GetMapping("/kafka/message")
    List<Message> receive();

}