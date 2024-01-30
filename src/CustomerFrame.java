import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CustomerFrame extends JFrame {
    private Penyedia penyedia;
    private Customer customer;
    private DefaultListModel<String> mobilListModel;
    private JList<String> listMobil;
    public CustomerFrame(Penyedia penyedia, Customer customer) {
        this.penyedia = penyedia;
        this.customer = customer;
        initialize();
    }
    private void initialize() {
        setTitle("Menu Customer");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mobilListModel = new DefaultListModel<>();
        listMobil = new JList<>(mobilListModel);
        updateMobilList();

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnBack = new JButton("Kembali ke Menu Utama");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToMainMenu();
            }
        });
        bottomPanel.add(btnBack);

        JButton btnsewaMobil = new JButton("Sewa Mobil");
        btnsewaMobil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listMobil.getSelectedIndex();
                if (selectedIndex != -1) {
                    sewaMobil(selectedIndex);
                }
            }
        });
        bottomPanel.add(btnsewaMobil);

        add(new JScrollPane(listMobil), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void backToMainMenu() {
        this.dispose();
        MainMenuFrame mainMenu = new MainMenuFrame();
        mainMenu.setVisible(true);
    }
    private void sewaMobil(int selectedIndex) {
        int days = Integer.parseInt(JOptionPane.showInputDialog(this, "Masukkan jumlah hari penyewaan:"));
        String selectedModel = mobilListModel.getElementAt(selectedIndex);
        Mobil selectedMobil = penyedia.getMobil(selectedModel);
        if (selectedMobil != null) {
            customer.sewaMobil(selectedMobil, days);
            JOptionPane.showMessageDialog(this, "Anda telah menyewa " + selectedModel + " untuk " + days + " hari.");
        }
    }
    private void updateMobilList() {
        mobilListModel.clear();
        for (Mobil mobil : penyedia.getMobill()) {
            String displayText = mobil.getModel();
            mobilListModel.addElement(displayText);
        }
    }
}