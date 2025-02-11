import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shlokdb", "root", "Root");
            PreparedStatement ps = con.prepareStatement("delete from register  where email=?");
            ps.setString(1, email);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Data deleted successfully!");
            } else {
                System.out.println("Data deletion failed.");
            }

            // Close connection
            con.close();
        }

    }

}
