import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GestionAlimentationA extends JFrame {
    private JComboBox<String> serviceDropdown;
    private GestionAlimentationDetails detailsWindow;

    public GestionAlimentationA() {
        setTitle("Gestion Alimentation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        initComponents();
        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(173, 216, 230));
        JLabel titleLabel = new JLabel("Géstion de l'alimentation", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(new Color(0, 0, 128)); 
        panel.add(titleLabel, BorderLayout.PAGE_START);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout()); 
        
        JLabel label = new JLabel("Services:");
        label.setFont(new Font("Arial", Font.BOLD, 24)); 
        
        topPanel.add(label);
        
      
           
        String[] services = {"Service A", "Service B", "Service C"};
        serviceDropdown = new JComboBox<>(services);
        Dimension preferredSize = new Dimension(200, 30); // Adjust width and height as needed
        serviceDropdown.setPreferredSize(preferredSize);
        
        topPanel.add(serviceDropdown);

        panel.add(topPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 12)); 
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 12)); 

        buttonPanel.add(submitButton);
        buttonPanel.add(resetButton);

        panel.add(buttonPanel, BorderLayout.PAGE_END);

        add(panel);

      
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Your logic on submit button click
                if (detailsWindow == null) {
                    detailsWindow = new GestionAlimentationDetails(serviceDropdown.getSelectedItem().toString());
                } else {
                   
                    int patientCount = 31; 
                    String bedIds = "1,2,3,4,5,6,19,22,31"; 
                    detailsWindow.updateService(serviceDropdown.getSelectedItem().toString(), patientCount, bedIds);
                }
                detailsWindow.setVisible(true);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           
                serviceDropdown.setSelectedIndex(0); 
              
            }
        });
    }

    public static void main(String[] args) {
        try {
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new GestionAlimentationA());
    }
}
class GestionAlimentationDetails extends JFrame {
    private JLabel serviceLabel;
    private JTextField patientCountField;
    private JTextArea bedIdsArea;

    public GestionAlimentationDetails(String service) {
        setTitle("Gestion Alimentations Details");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        initComponents(service);
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents(String service) {
      JPanel panel = new JPanel();
panel.setLayout(new BorderLayout());
panel.setBackground(new Color(173, 216, 230));

serviceLabel = new JLabel("Service: " + service, SwingConstants.CENTER);
serviceLabel.setFont(new Font("Arial", Font.BOLD, 16)); 
serviceLabel.setForeground(new Color(0, 0, 128)); 
panel.add(serviceLabel, BorderLayout.PAGE_START);

JPanel formPanel = new JPanel();
formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

JLabel patientCountLabel = new JLabel("Number of Patients:");
patientCountField = new JTextField();
patientCountField.setEditable(false); 
patientCountField.setMaximumSize(new Dimension(Integer.MAX_VALUE, patientCountField.getPreferredSize().height));

JLabel bedIdsLabel = new JLabel("IDs of Beds:");
bedIdsArea = new JTextArea();
bedIdsArea.setEditable(false); 
bedIdsArea.setRows(1);

formPanel.add(patientCountLabel);
formPanel.add(patientCountField);
formPanel.add(Box.createRigidArea(new Dimension(0, 10))); 
formPanel.add(bedIdsLabel);
formPanel.add(bedIdsArea);

panel.add(formPanel, BorderLayout.CENTER);


        panel.add(formPanel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GestionAlimentationDetails.this.setVisible(false);
            }
        });
        panel.add(backButton, BorderLayout.PAGE_END);

        add(panel);
    }

    public void updateService(String service, int patientCount, String bedIds) {
        serviceLabel.setText("Service: " + service);
        patientCountField.setText(String.valueOf(patientCount));
        bedIdsArea.setText(bedIds);
    }
}