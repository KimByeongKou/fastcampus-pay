package com.fastcampuspay.utility;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;

public class TestDynamoDB {
    private static final String TABLE_NAME = "MoneyIncreaseEventByRegion";
    private static final String ACCESS_KEY = "";
    private static final String SECRET_KEY = "";

    public static void main(String[] args) throws InterruptedException {
        AwsBasicCredentials credentials = AwsBasicCredentials.create(ACCESS_KEY, SECRET_KEY);
        // Create a DynamoDbClient with the default credential provider
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                .region(Region.AP_NORTHEAST_2) // Change the region to your desired region
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        // Now you can use the dynamoDbClient to access AWS resources
        // ... (add your DynamoDB operations here)

        // Add an item to the table
        // putItem(dynamoDbClient, "example_id_2", "John Doe2", 303);

        // Read the item from the table
        //getItem(dynamoDbClient, "example_id_1");
        queryItem(dynamoDbClient, "example_id_2");

        Thread.sleep(100000);
        // Close the client
        dynamoDbClient.close();
    }

    private static void putItem(DynamoDbClient dynamoDbClient, String id, String name, int age) {
        try {
            HashMap<String, AttributeValue> attrMap = new HashMap<>();
            attrMap.put("PK", AttributeValue.builder().s(id).build());
            attrMap.put("SK", AttributeValue.builder().s(id).build());
            attrMap.put("name", AttributeValue.builder().s(name).build());
            // attrMap.put("age", AttributeValue.builder().s("age").n(String.valueOf(age)).build());

            PutItemRequest request = PutItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .item(attrMap)
                    .build();

            dynamoDbClient.putItem(request);
            System.out.println("Item added to the table.");
        } catch (DynamoDbException e) {
            System.err.println("Error adding an item to the table: " + e.getMessage());
        }
    }

    private static void getItem(DynamoDbClient dynamoDbClient, String id) {
        try {
            HashMap<String, AttributeValue> attrMap = new HashMap<>();
            attrMap.put("PK", AttributeValue.builder().s(id).build());
            attrMap.put("SK", AttributeValue.builder().s(id).build());

            GetItemRequest request = GetItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .key(attrMap)
                    .build();

            GetItemResponse response = dynamoDbClient.getItem(request);
            System.out.println("Item retrieved from the table:");
            response.item().forEach((key, value) -> System.out.println(key + ": " + value));
        } catch (DynamoDbException e) {
            System.err.println("Error getting an item from the table: " + e.getMessage());
        }
    }

    private static void queryItem(DynamoDbClient dynamoDbClient, String id) {
        try {
            HashMap<String, Condition> attrMap = new HashMap<>();
            attrMap.put("PK", Condition.builder()
                    .attributeValueList(AttributeValue.builder().s(id).build())
                    .comparisonOperator(ComparisonOperator.EQ)
                    .build());

            QueryRequest request = QueryRequest.builder()
                    .tableName(TABLE_NAME)
                    .keyConditions(attrMap)
                    .build();

            QueryResponse response = dynamoDbClient.query(request);
            System.out.println("Item retrieved from the table:");
            response.items().forEach((value) -> System.out.println(value));
        } catch (DynamoDbException e) {
            System.err.println("Error getting an item from the table: " + e.getMessage());
        }
    }
}
