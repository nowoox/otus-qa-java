package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:config.properties")
public interface ServerConfig extends Config {
    @Key("url")
    String url();

    @Key("url-online-store")
    String url_online_store();
}