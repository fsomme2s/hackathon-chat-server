package de.conet.hack.realtime.chat.server;

import org.wildfly.swarm.Swarm;

import java.net.URL;

/**
 * TODO jdoc
 */
public class App {

    public static void main(String[] args) throws Exception {
        ClassLoader cl = App.class.getClassLoader();
        URL cfg = cl.getResource("swarm-config.yml");

        new Swarm()
                .withConfig(cfg)
                .start()
                .deploy();
    }
}
