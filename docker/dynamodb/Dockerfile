FROM fingershock/dynamodb-local:latest

ENTRYPOINT ["/usr/bin/java", "-Djava.library.path=./DynamoDBLocal_lib", "-jar", "DynamoDBLocal.jar"]
CMD ["-dbPath","/dynamodb_data", "-sharedDb"]

EXPOSE 8000
