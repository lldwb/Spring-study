package org.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tauren implements Malelead{
    private Malelead malelead;

    public Tauren(Malelead malelead) {
        this.malelead = malelead;
    }

    @Override
    public void video() {
        log.debug("ntr前");
        malelead.video();
        log.debug("ntr后");
    }
}
