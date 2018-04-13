package JDBCLearning;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class JDBCLearningClass {
    Scanner consoleIn = new Scanner(System.in);
    Connection connection;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new JDBCLearningClass().go();
    }

    private void go() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/msgtest?user=root&password=baurer9x8ee");

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM persoane");

        while (rs.next()) {
            System.out.println(rs.getString("nume"));
        }

        boolean cancellationToken = false;
        do {
            System.out.print(":");
            String input = consoleIn.nextLine();
            String[] inp = input.split(" ");
            String[] parts = Arrays.copyOfRange(inp, 1, inp.length);
            switch (inp[0]) {
                case "exit": {
                    cancellationToken = true;
                    break;
                }
                case "insert": {
                    insert(parts);
                    break;
                }
                case "select": {
                    showAll();
                    break;
                }
                case "nrWithImages": {
                    nrWithImages();
                }
                case "update": {
                    System.out.print("ID:");
                    int id = Integer.parseInt(consoleIn.nextLine());
                    updateNameOf(id);
                    break;
                }
                default: {
                    cancellationToken = true;
                    break;
                }
            }
        } while (!cancellationToken);
        connection.close();
    }

    private void showAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM persoane");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert(String[] parti) {
        if (parti.length == 2) {
            insertWithoutPicture(parti[0], parti[1]);
            return;
        }
        if (parti.length == 3) {
            insertWithPicture(parti[0], parti[1], parti[2]);
            return;
        }
        System.out.println("Arguments not well formed!");
    }

    private void insertWithoutPicture(String nume, String prenume) {
        try {
            PreparedStatement insertStatementNoPicture = connection.prepareStatement("INSERT INTO persoane (Nume, Prenume) VALUES (?, ?);");
            insertStatementNoPicture.setString(1, nume);
            insertStatementNoPicture.setString(2, prenume);
            insertStatementNoPicture.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Something went wrong!");
        }
    }

    private void insertWithPicture(String nume, String prenume, String path) {
        try (PreparedStatement insertStatementWithPicture = connection.prepareStatement("INSERT INTO persoane (Nume, Prenume,Poza) VALUES (?, ?, ?);"); InputStream picInputStream = new FileInputStream(path)){
            insertStatementWithPicture.setString(1, nume);
            insertStatementWithPicture.setString(2, prenume);
            insertStatementWithPicture.setBlob(3, picInputStream);
            insertStatementWithPicture.executeUpdate();
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }

    private void nrWithImages() {
        String procedure = "{call nrWithImage(?)}";
        try (CallableStatement callableStatement = connection.prepareCall(procedure)) {
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.executeUpdate();
            int nr = callableStatement.getInt(1);
            System.out.println(nr);
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }

    private void updateNameOf(int id) {
        try (Statement statement = connection.createStatement()) {
            System.out.print("New name:");
            String newName = consoleIn.nextLine();
            statement.executeUpdate("UPDATE  persoane SET Nume = '" + newName + "' WHERE id = " + id);
            System.out.println("Succes!");
        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }
    }

    private void updateNameOf(String[] input) {
        updateNameOf(Integer.parseInt(input[0]));
    }

    private void updateNameOf(String id) {
        updateNameOf(Integer.parseInt(id));
    }

}
