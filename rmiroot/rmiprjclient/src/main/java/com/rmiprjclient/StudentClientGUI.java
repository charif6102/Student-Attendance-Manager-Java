package com.rmiprjclient;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.prjrmi.dao.StudentManager;
import com.prjrmi.model.Grade;
import com.prjrmi.model.Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;


public class StudentClientGUI extends JFrame {

    private StudentManager stub;
    private JTable studentTable;
    private JComboBox<String> classSelector;
    private DefaultTableModel studentTableModel;
    private AddStudent addStudent;

    public StudentClientGUI() {
        super("Student Viewer");
        initializeRMI();
        initializeUI();
    }

    private void initializeRMI() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            stub = (StudentManager) registry.lookup("StudentManager");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur de connexion au serveur RMI: " + e.getMessage(),
                                          "Connection Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void initializeUI() {
 //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
       
        setLayout(new BorderLayout());
    
        // Title label
        JLabel titleLabel = new JLabel("Student Management Application", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);
    
        // Control panel
       
        add(new SelectorPanel(stub), BorderLayout.CENTER);
    //    add(new GradePanel(stub,1), BorderLayout.CENTER);
    
        setVisible(true);
    }
    
    


  
}