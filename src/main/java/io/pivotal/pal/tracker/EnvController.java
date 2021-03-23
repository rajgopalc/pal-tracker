package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String instanceAddress;
    private String port;
    private String memoryLimit;
    private String instanceIndex;

    public EnvController(@Value("${port:NOT SET}") String port, @Value("${memory.limit:NOT SET}")String memoryLimit, @Value("${cf.instance.index:NOT SET}")String instanceIndex, @Value("${cf.instance.addr:NOT SET}") String instanceAddress) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.instanceIndex=instanceIndex;
        this.instanceAddress=instanceAddress;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<>();

        env.put("PORT", this.port);
        env.put("MEMORY_LIMIT", this.memoryLimit);
        env.put("CF_INSTANCE_INDEX", this.instanceIndex);
        env.put("CF_INSTANCE_ADDR", this.instanceAddress);

        return env;
    }
}
