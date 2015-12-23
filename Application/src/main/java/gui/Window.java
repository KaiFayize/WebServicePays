package gui;

import exceptions.UserNotFoundException;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import metier.MainHandler;

public class Window implements ActionListener {

    private JPanel textPanel, panelForTextFields, completionPanel;
    private JLabel titleLabel, loginLabel, pwLabel, passwordLabel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private MainHandler mh;
    private GestionPanel gp;

    private static JFrame frame;

    public JPanel createContentPane() {

        // We create a bottom JPanel to place everything on.
        //This sets the Border Layout to have a horizontal gap of 10
        //and a vertical gap of 10 between each widget.
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(new BorderLayout(10, 10));

        // Setting the preferredSize is basically making sure the widget
        // is not re-sized to be smaller or bigger than this unless it needs to be.
        // Also, when adding, we have the area of the JPanel as a second argument.
        titleLabel = new JLabel("Login Screen");
        titleLabel.setPreferredSize(new Dimension(290, 30));
        titleLabel.setHorizontalAlignment(0);
        totalGUI.add(titleLabel, BorderLayout.PAGE_START);

        // Creation of a Panel to contain the JLabels
        textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(70, 120));
        totalGUI.add(textPanel, BorderLayout.WEST);

        // Username Label
        loginLabel = new JLabel("Login :");
        loginLabel.setPreferredSize(new Dimension(70, 30));
        loginLabel.setHorizontalAlignment(4);
        textPanel.add(loginLabel);

        // Login Label
        pwLabel = new JLabel("Password :");
        pwLabel.setPreferredSize(new Dimension(70, 30));
        pwLabel.setHorizontalAlignment(4);
        textPanel.add(pwLabel);

        // TextFields Panel Container
        panelForTextFields = new JPanel();
        panelForTextFields.setPreferredSize(new Dimension(60, 50));
        totalGUI.add(panelForTextFields, BorderLayout.CENTER);

        // Login Textfield
        loginField = new JTextField(8);
        loginField.setPreferredSize(new Dimension(60, 30));
        panelForTextFields.add(loginField);

        // Password Textfield
        passwordField = new JPasswordField(8);
        passwordField.setPreferredSize(new Dimension(60, 30));
        panelForTextFields.add(passwordField);

        // Creation of a Panel to contain the completion JLabels
        completionPanel = new JPanel();
        completionPanel.setPreferredSize(new Dimension(70, 80));
        totalGUI.add(completionPanel, BorderLayout.LINE_END);

        // Button for Logging in
        // ADD IN A SINGLE PANEL /!\
        loginButton = new JButton("Login");
        loginButton.setBounds(110, 100, 80, 20);
        loginButton.addActionListener(this);
        totalGUI.add(loginButton, BorderLayout.SOUTH);

        totalGUI.setOpaque(true);
        return totalGUI;
    }

    // With this action performed, we simply check to see if the username and
    // password match "Bob" as the username and "Robert" as the password.
    // If they do, we set the labels ajacent to them to "Correct!" and color
    // them green.
    // At the end, we check if both labels are green. If they are, we set the
    // screen to be 'Logging In'.
    //what happens when login is clicked
    public void actionPerformed(ActionEvent e) {
        String login = loginField.getText();
        String password = passwordField.getText();
        if (e.getSource() == loginButton) {
            if (!login.equals("") && !password.equals("")) {
                System.out.println("Login " + login + " Password " + password);
                try {
                    beginGestion(login, password);
                } catch (UserNotFoundException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "The fields can't be null!", null, JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void beginGestion(String login, String password) throws UserNotFoundException {
        GestionPanel gp = new GestionPanel(login, password);
        if (gp.isConnected()) {
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "Wrong password/account!", null, JOptionPane.ERROR_MESSAGE);
            return;
        }

        frame.setContentPane(gp);
        System.out.println("On commence la gestion");
        frame.revalidate();
        frame.setResizable(true);

        frame.setMinimumSize(new Dimension(300, 100));;
        frame.setLocationRelativeTo(null);
        frame.pack();
    }

    private static void createAndShowGUI() {

        frame = new JFrame("Gestion");

        Window demo = new Window();
        frame.setResizable(false);
        frame.setContentPane(demo.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // We no longer manually re-size, we use pack to automatically size the frame.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
