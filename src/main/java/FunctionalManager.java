import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.Scanner;

public class FunctionalManager {

    public static void managerRegistrationCheck(Manager manager) {
        String response = "";
        EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
        String managerName = null;
        try {
            Query query = entityManager.createQuery("SELECT m.name FROM Manager m WHERE m.password =:password");
            query.setParameter("password", manager.getPassword());
            managerName = (String) query.getSingleResult();
        } catch (NoResultException e) {
            e.getMessage();
        }
        entityManager.close();
        if (managerName == null) {
            System.out.println("You are not a restaurant manager");
        }
        if (managerName != null) {
            System.out.println("Registration check passed successfully");
            System.out.println(addProduct());
        }
    }

    private static String addProduct() {
        Scanner scanner = new Scanner(System.in);
        String answer ="";
        System.out.println("Add a new dish to the restaurant menu");
        System.out.println("Enter the name of the product");
        String name = scanner.nextLine();
        System.out.println("Enter the discount of the product");
        Integer discount = scanner.nextInt();
        System.out.println("Enter the price of the product");
        Integer price = scanner.nextInt();
        System.out.println("Enter the weight of the product");
        Integer weight = scanner.nextInt();
        Menu menu = new Menu(name, price, weight, discount);
        EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(menu);
            entityManager.getTransaction().commit();
        } catch (PersistenceException | IllegalArgumentException e) {
            e.getMessage();
            entityManager.getTransaction().rollback();
            answer="Product has not been added";
        }
        answer="Product was added successfully";
        entityManager.close();
        return answer;
    }

}
