package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class User {
    public void user() {
        log.info("user");
        String string = null;
//        string.equals(string);
    }
}
