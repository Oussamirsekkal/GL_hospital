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

  
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Connexion");


       setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 

        
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
        gbc.anchor = GridBagConstraints.EAST; 
        add(loginButton, gbc);
        

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
              

     
                boolean authentificationReussie = Controle.authenticate(username, password);

               if (authentificationReussie) {
                    Object[] options = {"Ouvrir la page principale"};
                    int result = JOptionPane.showOptionDialog(LoginWindow.this,
                            "Connexion reussie !",
                            "Succes",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            options,
                            options[0]);

                    if (result == 0) { 

                        MainPage mainPage = new MainPage();
                        mainPage.setVisible(true);
                        dispose();
                    }
                }
                else {
                     Object[] options = {"Ressayer", "Annuler"};
                    int result = JOptionPane.showOptionDialog(LoginWindow.this,
                            "echec de la connexion. Veuillez verifier vos informations.",
                            "echec",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.ERROR_MESSAGE,
                            null,
                            options,
                            options[0]);

                    if (result == JOptionPane.YES_OPTION) {
                        
                    } else {
                        System.exit(0);
                    }
                }
                System.out.println("username : " +username);
                System.out.println(password);
            }
            
        });
    }
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 16)); 
        return label;
    }
    private JTextField createTextField() {
   
        usernameField = new JTextField(20);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        return usernameField;
    }
    
    private JPasswordField createPasswordField() {
 
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        return passwordField;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }

            LoginWindow loginWindow = new LoginWindow();
            loginWindow.setVisible(true);
        });
    }
}
