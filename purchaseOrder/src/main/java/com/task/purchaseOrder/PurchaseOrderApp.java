package com.task.purchaseOrder;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseOrderApp {

    public static void main(String[] args) {
        String jsonFilePath = "C:\\hotelmgtsys\\purchaseOrder\\purchaseOrder\\src\\main\\resources";
        PurchaseOrder purchaseOrder = readJsonFromFile("C:\\hotelmgtsys\\purchaseOrder\\purchaseOrder\\src\\main\\resources\\PurchaseOrder.json");

        if (purchaseOrder != null) {
            saveToDatabase(purchaseOrder);
        }
    }

    private static PurchaseOrder readJsonFromFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("C:\\hotelmgtsys\\purchaseOrder\\purchaseOrder\\src\\main\\resources\\PurchaseOrder.json"), PurchaseOrder.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void saveToDatabase(PurchaseOrder purchaseOrder) {
        String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=PurchaseOrderDB;encrypt=true;integratedSecurity=true;";
        String dbUser = "sa";
        String dbPassword = "Ashish@0914";

        String sql = "INSERT INTO PurchaseOrder (OrderNumber, creationDate, vendorName, productCode, productName, quantityOrdered, orderedBy, lastUpdatedDate, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, purchaseOrder.getOrderNumber());
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(purchaseOrder.getCreationDate().getTime()));
            preparedStatement.setString(3, purchaseOrder.getVendorName());
            preparedStatement.setString(4, purchaseOrder.getProductCode());
            preparedStatement.setString(5, purchaseOrder.getProductName());
            preparedStatement.setDouble(6, purchaseOrder.getQuantityOrdered());
            preparedStatement.setString(7, purchaseOrder.getOrderedBy());
            preparedStatement.setTimestamp(8, new java.sql.Timestamp(purchaseOrder.getLastUpdatedDate().getTime()));
            preparedStatement.setString(9, purchaseOrder.getStatus());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new purchase order was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

