package ymat.practice.dynamospring.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.IDynamoDBMapper;


@Configuration
@ConfigurationProperties(prefix = "dynamodb")
@Slf4j
public class DynamoDbConfig {

    @Autowired
    public AwsConfig awsConfig;


    @Getter @Setter
    private String region;

    @Getter @Setter
    private String endpoint;


    @Bean
    public IDynamoDBMapper getDynamoDBMapper() {
        AmazonDynamoDB dynamoDb = new AmazonDynamoDBAsyncClient(
                new BasicAWSCredentials(awsConfig.getAccessKey(), awsConfig.getSecretKey()));

        dynamoDb.setRegion(Region.getRegion(Regions.valueOf(getRegion())));
        dynamoDb.setEndpoint(getEndpoint());

        return new DynamoDBMapper(dynamoDb);
    }

}
