
package org.example;

import java.sql.*;
        import java.util.Scanner;

public class menudriven {

    static final String url = "jdbc:oracle:thin:@db.freesql.com:1521/23ai_34ui2";
    static final String username = "SAKSHIRAJPUT6NOV_SCHEMA_OX2MS";
    static final String password = "D$FUVV13pTTX0WNDF2N311AJDH9HQC";  // ⚠ replace

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(url, username, password)) {

            System.out.println(" Connected to Database");

            while (true) {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Create Table");
                System.out.println("2. Insert Data");
                System.out.println("3. Select Data");
                System.out.println("4. Update Data");
                System.out.println("5. Delete Data");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        createTable(con);
                        break;

                    case 2:
                        insertData(con, sc);
                        break;

                    case 3:
                        selectData(con);
                        break;

                    case 4:
                        updateData(con, sc);
                        break;

                    case 5:
                        deleteData(con, sc);
                        break;

                    case 6:
                        System.out.println(" Exiting...");
                        return;

                    default:
                        System.out.println(" Invalid choice");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 1 CREATE TABLE
    static void createTable(Connection con) {
        String query = "CREATE TABLE Student123 (id NUMBER, name VARCHAR2(50))";

        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println(" Table created successfully");
        } catch (Exception e) {
            System.out.println("⚠ Table already exists");
        }
    }

    //2 INSERT
    static void insertData(Connection con, Scanner sc) {
        String query = "INSERT INTO Student123 (id, name) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            ps.setInt(1, id);
            ps.setString(2, name);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println(" Data inserted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3 SELECT
    static void selectData(Connection con) {
        String query = "SELECT * FROM Student123";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n--- Student Records ---");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Name: " + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4 UPDATE
    static void updateData(Connection con, Scanner sc) {
        String query = "UPDATE Student123 SET name = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {

            System.out.print("Enter ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            ps.setString(1, name);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println(" Data updated");
            else
                System.out.println(" ID not found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  DELETE
    static void deleteData(Connection con, Scanner sc) {
        String query = "DELETE FROM Student123 WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {

            System.out.print("Enter ID to delete: ");
            int id = sc.nextInt();

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println(" Data deleted");
            else
                System.out.println(" ID not found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}