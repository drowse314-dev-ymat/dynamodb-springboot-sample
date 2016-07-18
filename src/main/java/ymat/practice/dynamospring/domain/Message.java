package ymat.practice.dynamospring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "Message")
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @DynamoDBHashKey
    @DynamoDBAttribute(attributeName = "Chapter")
    @Getter @Setter
    private String chapter;

    @DynamoDBRangeKey
    @DynamoDBAttribute(attributeName = "UnixTime")
    @Getter @Setter
    private Long unixTime;

    @DynamoDBAttribute(attributeName = "Character")
    @Getter @Setter
    private String character;

    @DynamoDBAttribute(attributeName = "Message")
    @Getter @Setter
    private String message;


    @Override
    public String toString() {
        return String.format(
                "%s:['%s']@%d",
                getCharacter(), getMessage(), getUnixTime());
    }

}
