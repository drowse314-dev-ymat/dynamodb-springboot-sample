package ymat.practice.dynamospring;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.IDynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import ymat.practice.dynamospring.config.Config;
import ymat.practice.dynamospring.domain.Message;


@SpringBootApplication
@Import({Config.class})
@Slf4j
public class Application implements CommandLineRunner {

    @Autowired
    private IDynamoDBMapper dynamoDBMapper;


    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("start!!");

        dynamoDBMapper.save(new Message("round9", 92L, "Rem", "Good morning"));
        dynamoDBMapper.save(new Message("round9", 95L, "Subaru", "Rem...? you're... alright?"));

        Map<String, AttributeValue> params = new HashMap<String, AttributeValue>() {
            {
                put(":chapter", new AttributeValue().withS("round9"));
                put(":from", new AttributeValue().withN("0"));
                put(":to", new AttributeValue().withN("100"));
            }
        };
        dynamoDBMapper.query(
                Message.class,
                new DynamoDBQueryExpression<Message>()
                        .withKeyConditionExpression(
                                "Chapter = :chapter and UnixTime between :from and :to")
                        .withExpressionAttributeValues(params))
                .stream()
                .forEach(m -> log.info(m.toString()));

        log.info("finish!!");
    }

}
