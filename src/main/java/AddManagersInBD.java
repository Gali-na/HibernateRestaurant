import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;


public class AddManagersInBD {
    public static void addMamager() {
        EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Manager managerFirst = new Manager("Olga", "Pavlova", "olgapavlova");
        Manager managerSecond = new Manager("Mihail", "Kotow", "mihailkotow");
        Manager managerThird = new Manager("Tatyna", "Mishina", "tatynamishina");
       try {
           entityManager.persist(managerFirst);
           entityManager.persist(managerSecond);
           entityManager.persist(managerThird);
           entityManager.getTransaction().commit();
       }catch (PersistenceException| IllegalArgumentException e)  {
           e.getMessage();
           entityManager.getTransaction().rollback();
       }
        entityManager.close();
    }
}
