package top.lldwb.spring.ch02.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class UserService {
    private String string;
    public void save(){
      log.debug("21");
    }
}
