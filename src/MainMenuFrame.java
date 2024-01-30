import javax.swing.*;
import java.awt.*;

class MainMenuFrame extends JFrame {
    public MainMenuFrame() {
        setTitle("Menu Utama");
        setSize(300, 200);
        setLayout(new FlowLayout());

        JButton btnProvider = new JButton("Penyedia");
        JButton btnCustomer = new JButton("Customer");

        btnProvider.addActionListener(e -> {
            dispose();
            RentalMobil.showPenyediaFrame();
        });

        btnCustomer.addActionListener(e -> {
            dispose();
            RentalMobil.showCustomerFrame();
        });

        add(btnProvider);
        add(btnCustomer);
    }
}