import javax.swing.*;
import java.util.Scanner;

public class RentalMobil {
    private static Scanner scanner = new Scanner(System.in);
    private static Penyedia penyedia = new Penyedia("aa", "aa");
    private static Customer customer = new Customer("aa", "aa");

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
    private static void createAndShowGUI() {
        MainMenuFrame mainMenuFrame = new MainMenuFrame();
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setVisible(true);
    }
    public static void showPenyediaFrame() {
        PenyediaLoginFrame PenyediaLoginFrame = new PenyediaLoginFrame(penyedia);
        PenyediaLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PenyediaLoginFrame.setVisible(true);
    }
    public static void showCustomerFrame() {
        CustomerLoginFrame customerLoginFrame = new CustomerLoginFrame(penyedia, customer);
        customerLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerLoginFrame.setVisible(true);
    }
    public static void showMainMenuFrame() {
        MainMenuFrame mainMenuFrame = new MainMenuFrame();
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setVisible(true);
    }
}