package com.fastcampuspay.utility;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DummyMoneyDataSimulator {
    private static final String DECREASE_API_ENDPOINT = "http://localhost:8083/money/decrease-eda";
    private static final String INCREASE_API_ENDPOINT = "http://localhost:8083/money/increase-eda";

    private static final String CREATE_MONEY_API_ENDPOINT = "http://localhost:8083/money/create-member-money";
    private static final String REGISTER_ACCOUNT_API_ENDPOINT = "http://localhost:8082/banking/account/register-eda";

    private static final String[] BANK_NAME = {"KBB", "신한한", "우리리"};
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        List<Integer> readyMemberList = new ArrayList<>();

        while (true) {
            int amount = random.nextInt(20001) - 10000; // Random number between -100000 and 100000
            int targetMembershipId = random.nextInt(100) + 1; // Random number between 1 and 100000

            registerAccountSimulator(REGISTER_ACCOUNT_API_ENDPOINT, targetMembershipId);
            createMemberMoneySimulator(CREATE_MONEY_API_ENDPOINT, targetMembershipId);
            Thread.sleep(1000);
            readyMemberList.add(targetMembershipId);

            increaseMemberMoneySimulator(INCREASE_API_ENDPOINT, amount, targetMembershipId);

            amount = random.nextInt(20001) - 10000; // Random number between -100000 and 100000
            Integer decreaseTargetMembershipId = readyMemberList.get(random.nextInt(readyMemberList.size()));
            increaseMemberMoneySimulator(DECREASE_API_ENDPOINT, amount, decreaseTargetMembershipId);

            try {
                Thread.sleep(1000); // Wait for 1 second before making the next API call
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void increaseMemberMoneySimulator(String apiEndpoint, int amount, int targetMembershipId) {
        try {
            URL url = new URL(apiEndpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            JSONObject jsonRequestBody = new JSONObject();
            jsonRequestBody.put("amount", amount);
            jsonRequestBody.put("targetMembershipId", targetMembershipId);

            call(apiEndpoint, conn, jsonRequestBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void registerAccountSimulator(String apiEndpoint, int targetMembershipId) {
        try {
            URL url = new URL(apiEndpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            Random random = new Random();

            JSONObject jsonRequestBody = new JSONObject();
            jsonRequestBody.put("bankAccountNumber", generateRandomAccountNumber());
            jsonRequestBody.put("bankName", BANK_NAME[random.nextInt(BANK_NAME.length)]);
            jsonRequestBody.put("membershipId", targetMembershipId);
            jsonRequestBody.put("valid", true);

            call(apiEndpoint, conn, jsonRequestBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createMemberMoneySimulator(String apiEndpoint, int targetMembershipId) {
        try {
            URL url = new URL(apiEndpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            JSONObject jsonRequestBody = new JSONObject();
            jsonRequestBody.put("membershipId", targetMembershipId);

            call(apiEndpoint, conn, jsonRequestBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void call(String apiEndpoint, HttpURLConnection conn, JSONObject jsonRequestBody) throws IOException {
        OutputStream outputStream = conn.getOutputStream();
        outputStream.write(jsonRequestBody.toString().getBytes());
        outputStream.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        System.out.println("API Response from " + apiEndpoint + ": " + response.toString());
    }

    private static String generateRandomAccountNumber() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10); // Generate a random digit (0 to 9)
            sb.append(digit);
        }

        return sb.toString();
    }
}
