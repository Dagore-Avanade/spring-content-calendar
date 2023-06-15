package dev.dagore.contentcalendar.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class MyWebConfig {
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplateBuilder().build();
  }
}
