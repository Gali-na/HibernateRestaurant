import java.util.Scanner;

public class UserChoice {
    public static void userDefinition () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our restaurant");
        System.out.println("If you are a manager ->1");
        System.out.println("If you are a guest ->2");
        int user=scanner.nextInt();
        if( user == 1) {
            UserChoice.userManager();
        }
        if( user == 2) {
            UserChoice.userGuest();
        }

    }
    public static void userManager () {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the following data to verify access");
        System.out.println("Your name");
        String name = scanner.nextLine();
        manager.setName(name);
        System.out.println("Your surname");
        String surname = scanner.nextLine();
        manager.setSurname(surname);
        System.out.println("Your password");
        String password = scanner.nextLine();
        manager.setPassword(password);
        FunctionalManager.managerRegistrationCheck(manager);
    }
    public static void userGuest () {
        System.out.println("Welcome to our restaurant");
        FunctionalityClient.showFunctional();
    }
}
