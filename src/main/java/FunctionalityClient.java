import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunctionalityClient<privat> {
    public static void showFunctional() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Function");
        System.out.println("View the menu inside and out->1");
        System.out.println("View the product only with a discount->2");
        System.out.println("Order of goods->3");
        int selectView = scanner.nextInt();
        if (selectView == 1) {
            System.out.println("The cost of goods on the menu from 50 to 300");
            System.out.println("Indicate at what price to place an order ");
            int from = scanner.nextInt();
            System.out.println("indicate to what price to place an order ");
            int to = scanner.nextInt();
            List<Menu> listMenu= selectionOfGoodsInTheRangeOfPrices(to, from);
            for (Menu menu : listMenu) {
                System.out.println(menu.toString());
            }
        }
        if (selectView == 2) {
            List<Menu> listMenu= selectionOfGoodsWithDiscount ();
            for (Menu menu : listMenu) {
                System.out.println(menu.toString());
            }
        }
        if (selectView == 3) {
            List <Menu> order= orderCreation();
            for (Menu m:order) {
                System.out.println(m.toString());
            }
        }
    }

    private static List<Menu> selectionOfGoodsInTheRangeOfPrices(int to, int from) {
        List<Menu> listMenu = new ArrayList<>();
        EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT m FROM Menu m WHERE m.price>=:from and m.price<=:to");
            query.setParameter("from", from);
            query.setParameter("to", to);
            listMenu = (List<Menu>) query.getResultList();
        } catch (NoResultException e) {
            e.getMessage();
        }
        entityManager.close();
        return listMenu;
    }

    private static List<Menu> selectionOfGoodsWithDiscount () {
        List<Menu> listMenu = new ArrayList<>();
        EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT m FROM Menu m WHERE m.discount>0");
            listMenu = (List<Menu>) query.getResultList();
        } catch (NoResultException e) {
            e.getMessage();
        }
        entityManager.close();
        return listMenu;
    }

    private static  List <Menu> orderCreation () {
        Scanner scanner = new Scanner(System.in);
        List <Menu> order = new ArrayList<>();
        int sumWeight=0;
        int i=1;
        String j="proceed";
        System.out.println("To order a product, enter the product number");
        System.out.println("");
        while (j.equals("proceed")) {
            for (Menu menu : getListMenu()) {
                System.out.println(menu.toString() + "->" + i);
                i++;
            }
            int dishNamber=scanner.nextInt()-1;
            sumWeight=sumWeight+(getListMenu().get(dishNamber)).getWeight();
            order.add(getListMenu().get(dishNamber));
            System.out.println("If you want to roll the order, press ->stop");
            System.out.println("to continue ordering click ->proceed");
            Scanner scanner1 = new Scanner(System.in);
            j=scanner1.nextLine();
            i=0;
            if(sumWeight>=1000) {
                System.out.println("Your order cannot exceed 1 kg, the order process is interrupted, below is your order");
                order.remove((order.size()-1));
                break;
            }
        }
        return  order;
    }

    private static List<Menu> getListMenu() {
        List<Menu> listMenu = new ArrayList<>();
        EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT m FROM Menu m");
            listMenu = (List<Menu>) query.getResultList();
        } catch (NoResultException e) {
            e.getMessage();
        }
        entityManager.close();
        return listMenu;
    }
}
