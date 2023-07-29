package com.fastcampuspay.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class DummyDataGenerator {

    // MySQL 데이터베이스 연결 정보
    private static final String DB_URL = "jdbc:mysql://localhost:3306/fastcampus_pay"; // 데이터베이스 URL
    private static final String DB_USER = "mysqluser"; // 데이터베이스 사용자명
    private static final String DB_PASSWORD = "mysqlpw"; // 데이터베이스 비밀번호

    // 샘플 주소 데이터 배열
    private static final String[] ADDRESSES = {"강남구", "관악구", "서초구"};

    public static void main(String[] args) {
        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 더미 데이터 생성
            generateDummyData(conn);

            // 연결 종료
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void generateDummyData(Connection conn) throws SQLException {
        String insertQuery = "INSERT INTO membership (membership_id, address, email, is_corp, is_valid, name) VALUES (?, ?, ?, ?, ?, ?)";
        Random random = new Random();

        // 데이터 생성을 위한 PreparedStatement 준비
        PreparedStatement pstmt = conn.prepareStatement(insertQuery);

        // 더미 데이터 개수 (여기서는 100개로 가정)
        int numberOfDummyData = 100;

        for (int i = 1; i <= numberOfDummyData; i++) {
            pstmt.setLong(1, i); // membership_id
            pstmt.setString(2, ADDRESSES[random.nextInt(ADDRESSES.length)]); // address (랜덤하게 선택)
            pstmt.setString(3, "email_" + i + "@example.com"); // email (일단은 간단하게 생성)
            pstmt.setBoolean(4, random.nextBoolean()); // is_corp (true 또는 false 랜덤하게 선택)
            pstmt.setBoolean(5, random.nextBoolean()); // is_valid (true 또는 false 랜덤하게 선택)
            pstmt.setString(6, "User " + i); // name

            // 쿼리 실행
            pstmt.executeUpdate();
        }

        // PreparedStatement 닫기
        pstmt.close();
    }
}
