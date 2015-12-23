/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Pays;
import exceptions.PaysNotFoundException;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import metier.IPaysMetier;
import metier.MainHandler;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author Quentin
 */
public class FormFrame extends JFrame implements ActionListener {

    private JPanel mainPanel, formPanel;
    private FormFrame formFrame;
    private JTextField IDJTF, libellefrJTF, libelleenJTF, indicatifJTF, nationaliteJTF, monnaie_codeJTF, monnaie_pdJTF, tauxJTF, drapeauJTF, dangerJTF, coords1JTF, coords2JTF, coords3JTF, coords4JTF, coords5JTF;
    private JLabel IDJL, libellefrJL, libelleenJL, indicatifJL, nationaliteJL, monnaie_codeJL, monnaie_pdJL, tauxJL, dangerJL, drapeauJL, coords1JL, coords2JL, coords3JL, coords4JL, coords5JL;
    private MainHandler mainHandler;
    private String usage;
    private JComboBox JCB;
    private JButton finish;
    private Pays argpays;

    FormFrame(MainHandler mainHandler, final String usage, Pays argpays) throws PaysNotFoundException {
        this.setResizable(false);

        this.usage = usage;
        this.argpays = argpays;
        mainPanel = new JPanel();
        formPanel = new JPanel();
        this.mainHandler = mainHandler;
        //this.setLayout(new FlowLayout());
        this.getContentPane().add(mainPanel);
        init();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                close();
            }

            public void close() {
                int dialButton = JOptionPane.OK_CANCEL_OPTION;
                int dialResult;
                dialResult = JOptionPane.showConfirmDialog(null, "Vous etes sur le point de quitter sans avoir" + usage, "Attention !", dialButton);
                if (dialResult == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });
    }

    public void init() throws PaysNotFoundException {

        finish = new JButton(usage);

        //Init text fields
        if (argpays != null) {
            IDJTF = new JTextField(String.valueOf(argpays.getID()));
            indicatifJTF = new JTextField(argpays.getIndicatif());
            libellefrJTF = new JTextField(argpays.getLibelleFr());
            libelleenJTF = new JTextField(argpays.getLibelleEn());
            nationaliteJTF = new JTextField(argpays.getNationalite());
            monnaie_codeJTF = new JTextField(argpays.getMonnaieCode());
            monnaie_pdJTF = new JTextField(String.valueOf(argpays.getMonnaiePerdiem()));
            drapeauJTF = new JTextField(argpays.getDrapeau());
            tauxJTF = new JTextField(String.valueOf(argpays.getTauxChange()));
            dangerJTF = new JTextField(String.valueOf(argpays.isDanger()));
            coords1JTF = new JTextField(argpays.getCoords1());
            coords2JTF = new JTextField(argpays.getCoords2());
            coords3JTF = new JTextField(argpays.getCoords3());
            coords4JTF = new JTextField(argpays.getCoords4());
            coords5JTF = new JTextField(argpays.getCoords5());

        } else {
            IDJTF = new JTextField();
            indicatifJTF = new JTextField();
            libellefrJTF = new JTextField();
            libelleenJTF = new JTextField();
            nationaliteJTF = new JTextField();
            monnaie_codeJTF = new JTextField();
            monnaie_pdJTF = new JTextField();
            drapeauJTF = new JTextField();
            tauxJTF = new JTextField();
            dangerJTF = new JTextField();
            coords1JTF = new JTextField();
            coords2JTF = new JTextField();
            coords3JTF = new JTextField();
            coords4JTF = new JTextField();
            coords5JTF = new JTextField();
        }
        //init jlabels
        IDJL = new JLabel("ID");
        indicatifJL = new JLabel("Indicatif");
        libellefrJL = new JLabel("LibelleFR");
        libelleenJL = new JLabel("LibelleEN");
        nationaliteJL = new JLabel("Nationalité");
        monnaie_codeJL = new JLabel("Code Monnaie");
        monnaie_pdJL = new JLabel("Monnaie per diem");
        drapeauJL = new JLabel("Drapeau");
        tauxJL = new JLabel("Taux");
        dangerJL = new JLabel("danger (boolean)");
        coords1JL = new JLabel("c1");
        coords2JL = new JLabel("c2");
        coords3JL = new JLabel("c3");
        coords4JL = new JLabel("c4");
        coords5JL = new JLabel("c5");

        //finish.setEnabled(false);
        finish.addActionListener(this);
        mainPanel.setLayout(new GridLayout(1, 2));
        //formPanel construction pour l'ajout
        if (usage.equals("add") || argpays != null) {
            formPanel.setLayout(new GridLayout(16, 2));
            formPanel.add(IDJL);
            formPanel.add(IDJTF);
            formPanel.add(indicatifJL);
            formPanel.add(indicatifJTF);
            formPanel.add(libellefrJL);
            formPanel.add(libellefrJTF);
            formPanel.add(libelleenJL);
            formPanel.add(libelleenJTF);
            formPanel.add(nationaliteJL);
            formPanel.add(nationaliteJTF);
            formPanel.add(monnaie_codeJL);
            formPanel.add(monnaie_codeJTF);
            formPanel.add(monnaie_pdJL);
            formPanel.add(monnaie_pdJTF);
            formPanel.add(tauxJL);
            formPanel.add(tauxJTF);
            formPanel.add(dangerJL);
            formPanel.add(dangerJTF);
            formPanel.add(drapeauJL);
            formPanel.add(drapeauJTF);
            formPanel.add(coords1JL);
            formPanel.add(coords1JTF);
            formPanel.add(coords2JL);
            formPanel.add(coords2JTF);
            formPanel.add(coords3JL);
            formPanel.add(coords3JTF);
            formPanel.add(coords4JL);
            formPanel.add(coords4JTF);
            formPanel.add(coords5JL);
            formPanel.add(coords5JTF);

        } else {
            JCB = new JComboBox();
            //menu déroulant de choix
            ListableBeanFactory bf;
            bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
            IPaysMetier instance = (IPaysMetier) bf.getBean("paysMetier");
            List<Pays> result = instance.findAllPays();
            for (Pays pays : result) {
                JCB.addItem(pays.getLibelleFr());
                System.out.println("libelle : " + pays.getLibelleFr());
            }
            formPanel.setLayout(new FlowLayout());
            formPanel.add(JCB);
        }

        mainPanel.add(formPanel);
        mainPanel.add(finish);
        mainPanel.setSize(new Dimension(600, 320));
        this.revalidate();
        this.setVisible(true);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == finish) {
            if (usage == "add") {
                
                System.out.println("Ajout d'un pays");
                ListableBeanFactory bf;
                bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
                IPaysMetier instance = (IPaysMetier) bf.getBean("paysMetier");
                Map<String, String> arg = new HashMap();
                arg.put("ID", IDJTF.getText());
                arg.put("indicatif", indicatifJTF.getText());
                arg.put("nationalite", nationaliteJTF.getText());
                arg.put("libelle_fr", libellefrJTF.getText());
                arg.put("libelle_en", libelleenJTF.getText());
                arg.put("monnaie_code", monnaie_codeJTF.getText());
                arg.put("monnaie_perdiem", monnaie_pdJTF.getText());
                arg.put("taux_change", tauxJTF.getText());
                arg.put("danger", dangerJTF.getText());
                arg.put("drapeau", drapeauJTF.getText());
                arg.put("coords1", coords1JTF.getText());
                arg.put("coords2", coords2JTF.getText());
                arg.put("coords3", coords3JTF.getText());
                arg.put("coords4", coords4JTF.getText());
                arg.put("coords5", coords5JTF.getText());
                instance.createPays(arg);
                super.dispose();
            }
            if (usage == "del") {
                System.out.println("Delete d'un pays");
                System.out.println(JCB.getSelectedItem().toString());
                ListableBeanFactory bf;
                bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
                IPaysMetier instance = (IPaysMetier) bf.getBean("paysMetier");

                instance.deletePays(JCB.getSelectedItem().toString());
                super.dispose();
            }
            if (usage == "update" && argpays == null) {
                try {
                    System.out.println("Update d'un pays");
                    System.out.println(JCB.getSelectedItem());
                    ListableBeanFactory bf;
                    bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
                    IPaysMetier instance = (IPaysMetier) bf.getBean("paysMetier");

                    Pays result = instance.findPays((String) JCB.getSelectedItem());
                    FormFrame formFrame = new FormFrame(mainHandler, "update", result);
                    super.dispose();
                } catch (PaysNotFoundException ex) {
                    Logger.getLogger(FormFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            } 
            if (usage == "update" && argpays != null){
                ListableBeanFactory bf;
                bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
                IPaysMetier instance = (IPaysMetier) bf.getBean("paysMetier");

                Map<String, String> arg = new HashMap();
                arg.put("ID", IDJTF.getText());
                arg.put("indicatif", indicatifJTF.getText());
                arg.put("nationalite", nationaliteJTF.getText());
                arg.put("libelle_fr", libellefrJTF.getText());
                arg.put("libelle_en", libelleenJTF.getText());
                arg.put("monnaie_code", monnaie_codeJTF.getText());
                arg.put("monnaie_perdiem", monnaie_pdJTF.getText());
                arg.put("taux_change", tauxJTF.getText());
                arg.put("danger", dangerJTF.getText());
                arg.put("drapeau", drapeauJTF.getText());
                arg.put("coords1", coords1JTF.getText());
                arg.put("coords2", coords2JTF.getText());
                arg.put("coords3", coords3JTF.getText());
                arg.put("coords4", coords4JTF.getText());
                arg.put("coords5", coords5JTF.getText());
                instance.updatePays(argpays.getLibelleFr(), arg);
                super.dispose();
            }
        }

    }
}
