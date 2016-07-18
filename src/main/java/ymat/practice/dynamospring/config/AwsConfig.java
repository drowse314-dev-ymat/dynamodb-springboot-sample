package ymat.practice.dynamospring.config;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "aws")
public class AwsConfig {

    @Getter @Setter
    private String accessKey;

    @Getter @Setter
    private String secretKey;


    @Bean
    AwsConfig getAwsConfig() {
        return this;
    }

}
