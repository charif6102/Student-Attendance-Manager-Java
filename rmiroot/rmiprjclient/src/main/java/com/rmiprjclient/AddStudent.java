/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.rmiprjclient;
import com.prjrmi.dao.StudentManager;
import com.prjrmi.model.Grade;
import com.prjrmi.model.Student;
import java.rmi.RemoteException;
/**
 *
 * @author abech
 */
public class AddStudent extends javax.swing.JFrame {

    /**
     * Creates new form AddStudent
     */
       final private StudentManager stub;

    
    public AddStudent(StudentManager stub) {
        this.stub=stub;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addUserPanel = new javax.swing.JPanel();
        firstNameLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        classroomLabel = new javax.swing.JLabel();
        classRoomList = new javax.swing.JComboBox<>();
        addStudentButton = new javax.swing.JButton();
        addUserTitlePanel = new javax.swing.JPanel();
        addStudentTitleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        addUserPanel.setBackground(new java.awt.Color(255, 255, 204));

        firstNameLabel.setText("First Name");

        lastNameLabel.setText("Last Name");

        classroomLabel.setText("Classroom");

        classRoomList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100", "200", "300", "400" }));

        addStudentButton.setBackground(new java.awt.Color(0, 204, 204));
        addStudentButton.setForeground(new java.awt.Color(255, 255, 255));
        addStudentButton.setText("Add Student");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addUserPanelLayout = new javax.swing.GroupLayout(addUserPanel);
        addUserPanel.setLayout(addUserPanelLayout);
        addUserPanelLayout.setHorizontalGroup(
            addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserPanelLayout.createSequentialGroup()
                .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addUserPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(firstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(classroomLabel))
                        .addGap(41, 41, 41)
                        .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firstNameTextField)
                            .addComponent(lastNameTextField)
                            .addComponent(classRoomList, 0, 437, Short.MAX_VALUE)))
                    .addGroup(addUserPanelLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(addStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(478, Short.MAX_VALUE))
        );
        addUserPanelLayout.setVerticalGroup(
            addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classroomLabel)
                    .addComponent(classRoomList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(addStudentButton)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        addUserTitlePanel.setBackground(new java.awt.Color(255, 255, 204));

        addStudentTitleLabel.setBackground(new java.awt.Color(204, 204, 255));
        addStudentTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        addStudentTitleLabel.setText("Add New Student");

        javax.swing.GroupLayout addUserTitlePanelLayout = new javax.swing.GroupLayout(addUserTitlePanel);
        addUserTitlePanel.setLayout(addUserTitlePanelLayout);
        addUserTitlePanelLayout.setHorizontalGroup(
            addUserTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserTitlePanelLayout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(addStudentTitleLabel)
                .addContainerGap(497, Short.MAX_VALUE))
        );
        addUserTitlePanelLayout.setVerticalGroup(
            addUserTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserTitlePanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(addStudentTitleLabel)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addUserTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(addUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addUserTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentButtonActionPerformed
                Student student = new Student();
                student.setFirstName(firstNameTextField.getText());
                student.setLastName(lastNameTextField.getText());
                student.setStdClassName(classRoomList.getItemAt(WIDTH));
                try {
                    stub.addStudent(student);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
    }//GEN-LAST:event_addStudentButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudentButton;
    private javax.swing.JLabel addStudentTitleLabel;
    private javax.swing.JPanel addUserPanel;
    private javax.swing.JPanel addUserTitlePanel;
    private javax.swing.JComboBox<String> classRoomList;
    private javax.swing.JLabel classroomLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    // End of variables declaration//GEN-END:variables
}
