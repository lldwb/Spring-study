package org.example.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.UserDao;

import java.util.*;

@Slf4j
public class UserDaoImpl implements UserDao {
    private String string;
    private Integer integer;
    private List<String> list = new ArrayList<>();
    private Set<String> set = new HashSet<>();
    private Map<String, Object>  map = new HashMap<>();

    public void setString(String string) {
        this.string = string;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public UserDaoImpl(String string, Integer integer, List<String> list, Set<String> set, Map<String, Object> map) {
        this.string = string;
        this.integer = integer;
        this.list = list;
        this.set = set;
        this.map = map;
    }

    @Override
    public void add() {
        log.debug("UserDaoImpl");
        log.debug("string" + string);
        log.debug("integer" + integer);
        log.debug("list" + list);
        log.debug("set" + set);
        log.debug("map" + map);
    }
}
