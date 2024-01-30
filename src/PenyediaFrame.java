import javax.swing.*;
import java.awt.*;
import java.util.List;

class PenyediaFrame extends JFrame {
    private Penyedia penyedia;
    public PenyediaFrame(Penyedia penyedia) {
        this.penyedia = penyedia;
        initialize();
        JButton btnBack = new JButton("Kembali ke Menu Utama");
        btnBack.addActionListener(e -> {
            dispose();
            RentalMobil.showMainMenuFrame();
        });
        add(btnBack, BorderLayout.SOUTH);
    }

    private void initialize() {
        setTitle("Menu Penyedia");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnAddMobil = new JButton("Tambah Mobil");
        JButton btnRemoveMobil = new JButton("Hapus Mobil");
        JButton btnUpdateMobil = new JButton("Perbarui Mobil");
        JButton btnListMobil = new JButton("Daftar Mobil");

        btnAddMobil.addActionListener(e -> addMobil());
        btnRemoveMobil.addActionListener(e -> removeMobil());
        btnUpdateMobil.addActionListener(e -> updateCar());
        btnListMobil.addActionListener(e -> listMobil());

        add(btnAddMobil);
        add(btnRemoveMobil);
        add(btnUpdateMobil);
        add(btnListMobil);

        setVisible(true);
    }

    private void addMobil() {
        JTextField txtModel = new JTextField(10);
        JTextField txtHarga = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Model:"));
        panel.add(txtModel);
        panel.add(Box.createHorizontalStrut(15)); // Spacer
        panel.add(new JLabel("Harga/hari:"));
        panel.add(txtHarga);

        int result = JOptionPane.showConfirmDialog(null, panel,
                "Tambah Mobil", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String model = txtModel.getText();
                double harga = Double.parseDouble(txtHarga.getText());
                penyedia.addMobil(new Mobil(model, harga));
                JOptionPane.showMessageDialog(this, "Mobil berhasil ditambahkan!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Harga harus berupa angka!");
            }
        }
    }

    private void removeMobil() {
        String model = JOptionPane.showInputDialog(this, "Masukkan model mobil yang ingin dihapus:");
        if (model != null && !model.isEmpty()) {
            penyedia.removeMobil(model);
            JOptionPane.showMessageDialog(this, "Mobil berhasil dihapus!");
        }
    }

    private void updateCar() {
        JTextField txtOldModel = new JTextField(10);
        JTextField txtNewModel = new JTextField(10);
        JTextField txtNewPrice = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Model Lama:"));
        panel.add(txtOldModel);
        panel.add(Box.createHorizontalStrut(15));
        panel.add(new JLabel("Model Baru:"));
        panel.add(txtNewModel);
        panel.add(Box.createHorizontalStrut(15));
        panel.add(new JLabel("Harga Baru/hari:"));
        panel.add(txtNewPrice);

        int result = JOptionPane.showConfirmDialog(null, panel,
                "Perbarui Mobil", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String oldModel = txtOldModel.getText();
                String newModel = txtNewModel.getText();
                double newHarga = Double.parseDouble(txtNewPrice.getText());
                penyedia.updateCar(oldModel, newModel, newHarga);
                JOptionPane.showMessageDialog(this, "Mobil berhasil diperbarui!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Harga harus berupa angka!");
            }
        }
    }

    private void listMobil() {
        List<Mobil> mobil = penyedia.getMobill();
        StringBuilder builder = new StringBuilder();
        for (Mobil Mobil : mobil) {
            builder.append(Mobil).append("\n");
        }
        JOptionPane.showMessageDialog(this, builder.toString(), "Daftar Mobil", JOptionPane.INFORMATION_MESSAGE);
    }
}