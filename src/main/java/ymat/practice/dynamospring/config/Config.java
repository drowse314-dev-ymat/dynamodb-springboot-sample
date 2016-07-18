package ymat.practice.dynamospring.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties
@ComponentScan(basePackages = { "ymat.practice.dynamospring.config" })
public class Config {
}
