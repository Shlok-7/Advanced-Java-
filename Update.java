import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {
    public static void main(String[] args) throws Exception {
        try (// Create Scanner object for user input
        Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter City: ");
            String city = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            // Create a new instance of the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shlokdb", "root", "Root");
            PreparedStatement ps = con.prepareStatement("update register set city=? where email=?");
            ps.setString(1, city);
            ps.setString(2, email);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Data insertion failed.");
            }

            // Close connection
            con.close();
        }

    }
}
