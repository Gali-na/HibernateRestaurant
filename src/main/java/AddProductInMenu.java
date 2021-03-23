import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class AddProductInMenu {
    public static void fillingTheMenu () {
        EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Menu menuFirst = new Menu("carbonara paste", 150, 200, 10);
        Menu menuThird = new Menu("julienne", 80, 150, 5);
        Menu menuSecond = new Menu("mussel salad", 250, 200, 15);
        Menu menuFourth = new Menu("baked salmon", 130, 180, 0);
        Menu menuFifth = new Menu("pizza", 80, 300, 5);
        Menu menuSixth = new Menu("omelet", 39, 120, 0);
        Menu menuSeventh = new Menu("french fries", 50, 250, 5);
        try {
            entityManager.persist(menuFirst);
            entityManager.persist(menuThird);
            entityManager.persist(menuSecond);
            entityManager.persist( menuFourth);
            entityManager.persist(menuFifth);
            entityManager.persist(menuSixth);
            entityManager.persist(menuSeventh);
            entityManager.getTransaction().commit();
        }catch (PersistenceException | IllegalArgumentException e)  {
            e.getMessage();
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
    }

}
