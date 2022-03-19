package br.mba.fiap.abctech.abctechservice.application;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class PropertiesComponent {
    private final Properties properties;

    public PropertiesComponent() {
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.yml");

        try {
            this.properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() { return properties.getProperty("build.name"); }
    public String getVersion() { return properties.getProperty("build.version"); }

}
