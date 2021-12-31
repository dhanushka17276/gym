package com.intvaria.main;

import com.intvaria.DAO.UserDAO;
import com.intvaria.entity.LoggedUser;
import com.intvaria.event.EventMenu;
import com.intvaria.form.AllUsers;
import com.intvaria.form.Attendance;
import com.intvaria.form.Cards;

import com.intvaria.form.Form;
import com.intvaria.form.Form_1;
import com.intvaria.form.NewUser;
import com.intvaria.form.Packages;
import com.intvaria.form.Register;
import com.intvaria.form.Sales;
import com.intvaria.form.viewall;
import com.intvaria.form.viewallitem;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Main extends javax.swing.JFrame {

    UserDAO userDao=new UserDAO();
    boolean loginStaus=false;
    Long loggedUserId;
   
    
     public Main(Long userId) {
         initComponents();
        loggedUserId=userId;
       
        
        
           setBackground(new Color(0, 0, 0, 0));
        EventMenu event = new EventMenu() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    showForm(new Form_1());
                   
                } else if (index == 8) {
                    
                    int wantLogin=JOptionPane.showConfirmDialog(null, "Do you want to log out?");
                    if(wantLogin==JOptionPane.YES_OPTION){
                         loginStaus=userDao.updateLoginStaus(false,loggedUserId );
                    if(loginStaus==true){
                        Login loginFrame=new Login();
                   loginFrame.setVisible(true);
                   Main.this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Logout Fail Try Again!");
                    }
                    }
                   
                        
                   
                } else if (index == 1) {
                    showForm(new Register());
                   
                }else if (index == 2) {
                    showForm(new NewUser());
                   
                }else if (index == 4) {
                    showForm(new AllUsers());
                   
                }else if (index == 3) {
                    showForm(new viewall());
                   
                }
                else if (index == 5) {
                    showForm(new Packages());
                   
                } else if (index == 6) {
                    showForm(new viewallitem());
                   
                }else if (index == 7) {
                    showForm(new Sales());
                   
                }else if (index == 9) {
                    try {
                        showForm(new Attendance());
                    } catch (ParseException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }else if (index == 10) {
                    try {
                        showForm(new Cards());
                    } catch (ParseException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                else {
                    showForm(new Form(index));
                }
            }
        };
        menu1.initMenu(event);
        showForm(new Form_1());
    }
    public Main() {
        initComponents();
       
     
       // showForm(new Register());
    }

   
    
    private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.revalidate();
        body.repaint();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.intvaria.swing.RoundPanel();
        header2 = new com.intvaria.component.Header();
        menu1 = new com.intvaria.component.Menu();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        roundPanel1.setBackground(new java.awt.Color(25, 25, 25));

        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 1371, Short.MAX_VALUE)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private com.intvaria.component.Header header2;
    private com.intvaria.component.Menu menu1;
    private com.intvaria.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
