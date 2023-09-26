package top.lldwb.spring.ch03.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService {
    static {
        log.debug("参数");
    }
    public void save(){
        log.info("输出save");
    }
}
