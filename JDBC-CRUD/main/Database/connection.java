package main.database;
public class connection {
    public static final String URL ="jdbc:postgresql://localhost:5432/StudentManagementSystem";
    public static final String USER ="postgres";
    public static  String Password;

    static {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter database password: ");
        password = scanner.nextLine();
    }

    public static connection getConnection() {
        return DriveManager.getConnection(URL, USER, Password)
    }
}