package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:config.properties")
public interface ServerConfig extends Config {

    @Key("url_online_store")
    String url_online_store();

    @Key("url_online_store_compare")
    String url_online_store_compare();
}