package gui;

import exceptions.PaysNotFoundException;
import exceptions.UserNotFoundException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import metier.MainHandler;
import gui.FormFrame;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GestionPanel extends JPanel implements ActionListener {

    private MainHandler mainHandler;
    private JMenuBar menuBar;
    private JMenuItem jmiAbout, jmiDoc;
    private JMenu jmAbout, jmDoc; 
    private JPanel mainPanel, bottom, top, mid, centerPanel;
    private JLabel login, password;
    private JLabel score;
    private JButton add, del, update;
    private Frame f;
    private FormFrame formFrame;

    //TestPanel
    public GestionPanel(String login, String password) throws UserNotFoundException {
        mainHandler = new MainHandler(login, password);

        if (mainHandler.getCurrentUser() != null) {
            init();
        }
    }

    public void init() {
        this.setLayout(new BorderLayout());

        //init Jlabel
        login = new JLabel("Connecté en tant que :" + mainHandler.getCurrentUser().getUser());
        System.out.println(mainHandler.getCurrentUser().getUser());
        add = new JButton("Ajouter un pays");
        add.addActionListener(this);
        del = new JButton("Supprimer un pays");
        del.addActionListener(this);
        update = new JButton("Modifier un pays");
        update.addActionListener(this);
        //init the top JPanel
        mid = new JPanel(new GridLayout(5, 1));
        top = new JPanel(new GridLayout(3, 1));
        mainPanel = new JPanel(new BorderLayout());
        top.add(login);
        mid.add(add);
        mid.add(del);
        mid.add(update);
        mainPanel.add(mid, BorderLayout.CENTER);
        mainPanel.add(top, BorderLayout.NORTH);
        
        //menubar
        menuBar = new JMenuBar();
            jmAbout = new JMenu("?");
            jmDoc = new JMenu("Documentation");
            jmiAbout = new JMenuItem("About");
            jmiDoc = new JMenuItem("User Guide");
            
            jmiDoc.addActionListener(new ActionListener(){
                    
                @Override
                    public void actionPerformed(ActionEvent e){
                    try {  
                        Desktop.getDesktop().browse(new URL("https://trac.lipn.univ-paris13.fr/projects/pays/wiki/UserManual").toURI());
                    } catch (IOException | URISyntaxException ex) {
                        Logger.getLogger(GestionPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    }
            });
            jmiAbout.addActionListener(new ActionListener(){
                    
                @Override
                    public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(centerPanel, "Copyright Quentin Amelot \n 2015 \n M1 - Info", "About this app :", 3);
                    
                    
                    }
            });
            jmAbout.add(jmiAbout);
            jmDoc.add(jmiDoc);
            menuBar.add(jmDoc);
            menuBar.add(jmAbout);
            
        //init the center JPanel
        /*centerPanel = new JPanel(new BorderLayout());
        centerPanel.setPreferredSize(new Dimension(200, 320));
        centerPanel.setBackground(Color.white);*/
		//mainPanel.add(centerPanel);

        //rank abilities
        switch (mainHandler.getCurrentUser().getRank()) {
            case "0":
                break;
            case "1":
                del.setEnabled(false);
                update.setEnabled(false);
                break;
            case "2":
                del.setEnabled(false);
                break;

        }

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(menuBar, BorderLayout.NORTH);
    }

    public boolean isConnected() {
        return mainHandler.getCurrentUser() == null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            System.out.println("Ajout d'un pays");
            try {
                FormFrame formFrame = new FormFrame(mainHandler, "add", null);
            } catch (PaysNotFoundException ex) {
                Logger.getLogger(GestionPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == del) {
            System.out.println("Suppression d'un pays");
            try {
                FormFrame formFrame = new FormFrame(mainHandler, "del", null);
            } catch (PaysNotFoundException ex) {
                Logger.getLogger(GestionPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == update) {
            System.out.println("Modification d'un pays");
            try {
                FormFrame formFrame = new FormFrame(mainHandler, "update", null);
            } catch (PaysNotFoundException ex) {
                Logger.getLogger(GestionPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
