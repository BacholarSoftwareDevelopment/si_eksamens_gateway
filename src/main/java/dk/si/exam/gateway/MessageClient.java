package dk.si.exam.gateway;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("server")
@RibbonClient(name = "server", configuration = RibbonConfig.class)
public interface MessageClient {

    @PostMapping("/test")
    String test(Message message);
}
