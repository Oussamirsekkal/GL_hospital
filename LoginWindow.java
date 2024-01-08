import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    
    public LoginWindow() {
        setTitle("Connexion a l'application ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        // Création des composants
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Connexion");

        // layout de la fenetre connexion 
       setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Marges entre les composants

        // Ajout des composants à la fenêtre avec GridBagLayout
         gbc.gridx = 0;
        gbc.gridy = 0;
        add(createLabel("Nom d'utilisateur:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(createTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(createLabel("Mot de passe:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(createPasswordField(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST; // Aligner le bouton à droite
        add(loginButton, gbc);
        
        // Ajout d'un écouteur d'action au bouton de connexion
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique de connexion simplifiée pour l'exemple
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();


                Controle controleur = new Controle();
                boolean authentificationReussie = controleur.authenticate(username, password);

                if (authentificationReussie) {
                    JOptionPane.showMessageDialog(LoginWindow.this, "Connexion reussie !");
                    // Ajoutez ici la logique pour ouvrir la nouvelle fenêtre de l'application hospitalière
                } else {
                    JOptionPane.showMessageDialog(LoginWindow.this, "echec de la connexion. Veuillez verifier vos informations.");
                }
            }
        });
    }
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 16)); 
        return label;
    }
    private JTextField createTextField() {
        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        return textField;
    }
    private JPasswordField createPasswordField() {
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        return passwordField;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Utilisez le look and feel du système par défaut
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }

            LoginWindow loginWindow = new LoginWindow();
            loginWindow.setVisible(true);
        });
    }
}
