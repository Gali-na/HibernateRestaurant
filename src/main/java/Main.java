import javax.persistence.*;
import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        AddManagersInBD.addMamager();
        AddProductInMenu.fillingTheMenu();
        UserChoice.userDefinition();
        JPAEntityManagerFactory.getEntityManagerFactory().close();
    }
}


