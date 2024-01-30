import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PenyediaLoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private Penyedia penyedia;

    public PenyediaLoginFrame(Penyedia penyedia) {
        this.penyedia = penyedia;
        initialize();
    }

    private void initialize() {
        setTitle("Login Penyedia");
        setSize(300, 150);
        setLayout(new GridLayout(3, 2, 5, 5));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();

        // Enter key to submit form
        txtPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        add(new JLabel("Username:"));
        add(txtUsername);
        add(new JLabel("Password:"));
        add(txtPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        add(btnLogin);

        setVisible(true);
    }
    private void performLogin() {
        if (txtUsername.getText().isEmpty() || txtPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Harap isi username dan password.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (penyedia.getUsername().equals(txtUsername.getText()) &&
                penyedia.getPassword().equals(new String(txtPassword.getPassword()))) {
            PenyediaFrame PenyediaFrame = new PenyediaFrame(penyedia);
            PenyediaFrame.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Username atau password salah.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}