import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {
    public static void main(String[] args) throws Exception {
        // Load MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shlokdb?useSSL=false&allowPublicKeyRetrieval=true", "root", "Root");

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Gender (male/female): ");
        String gender = scanner.nextLine();

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        // Close scanner (good practice)
        scanner.close();

        // Prepare SQL query with user inputs
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO register (name, email, password, gender, city) VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setString(4, gender);
        ps.setString(5, city);

        // Execute update
        int i = ps.executeUpdate();

        // Print result
        if (i > 0) {
            System.out.println("Data inserted successfully!");
        } else {
            System.out.println("Data insertion failed.");
        }

        // Close connection
        con.close();
    }
}
