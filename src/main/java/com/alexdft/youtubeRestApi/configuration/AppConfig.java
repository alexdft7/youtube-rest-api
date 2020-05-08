package com.alexdft.youtubeRestApi.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.alexdft.youtubeRestApi.configuration")
@EnableWebMvc
public class AppConfig {
}
