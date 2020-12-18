package dk.si.exam.gateway;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("producer")
@RibbonClient(name = "producer", configuration = RibbonConfig.class)
public interface MessageClient {

    @PostMapping("/kafka/message")
    String send(Message message);

}