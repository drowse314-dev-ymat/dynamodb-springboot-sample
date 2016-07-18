set -eu

aws dynamodb create-table --endpoint-url=http://0.0.0.0:8000 \
    --table-name Message \
    --attribute-definitions \
        AttributeName=Chapter,AttributeType=S \
        AttributeName=UnixTime,AttributeType=N \
    --key-schema \
        AttributeName=Chapter,KeyType=HASH \
        AttributeName=UnixTime,KeyType=RANGE \
    --provisioned-throughput \
        ReadCapacityUnits=1,WriteCapacityUnits=1
