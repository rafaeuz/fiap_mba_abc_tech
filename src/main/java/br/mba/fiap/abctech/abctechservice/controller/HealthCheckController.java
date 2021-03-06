package br.mba.fiap.abctech.abctechservice.controller;


import br.mba.fiap.abctech.abctechservice.application.PropertiesComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    public HealthCheckController(@Autowired PropertiesComponent propertiesComponent) {
    }

    @GetMapping()
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Service is healthy!");
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.yml");
        try {
            properties.load(inputStream);
         } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(properties.getProperty("build.name") + " - " + properties.getProperty("build.version"));
    }

}
