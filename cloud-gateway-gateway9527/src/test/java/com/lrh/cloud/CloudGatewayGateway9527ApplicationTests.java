package com.lrh.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

@SpringBootTest
class CloudGatewayGateway9527ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void currentTime(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }

}
