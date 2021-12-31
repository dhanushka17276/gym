package com.intvaria.component;

import com.intvaria.entity.LoggedUser;
import com.intvaria.main.Exit;
import com.intvaria.main.Main;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JRootPane;

public class Header extends javax.swing.JPanel {

   LoggedUser user;
    
    public Header() {
        initComponents();
        setOpaque(false);
        setBackground(new Color(51, 51, 51));
      
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCloseHeader = new com.intvaria.swing.ButtonBadges();
        btnMinimize = new com.intvaria.swing.ButtonBadges();

        btnCloseHeader.setBackground(new java.awt.Color(25, 25, 25));
        btnCloseHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/intvaria/icon/close.png"))); // NOI18N
        btnCloseHeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseHeaderActionPerformed(evt);
            }
        });

        btnMinimize.setBackground(new java.awt.Color(25, 25, 25));
        btnMinimize.setForeground(new java.awt.Color(247, 58, 58));
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/intvaria/icon/minimize-window-20.png"))); // NOI18N
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(539, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnCloseHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnCloseHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseHeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseHeaderActionPerformed
      // showMessageDialog(null, "This is even shorter");
        Exit frame = new Exit(1);
      
        frame.setVisible(true);
    }//GEN-LAST:event_btnCloseHeaderActionPerformed

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        
        //JFrame farame=(JFrame) Main.getFrames()[0];
                Frame[] farame1=Main.getFrames();

                for(int i=0;i<farame1.length;i++){
                     farame1[i].setExtendedState(JFrame.ICONIFIED);// One way
                }

       

    }//GEN-LAST:event_btnMinimizeActionPerformed

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        area.add(new Area(new Rectangle2D.Double(0, 20, getWidth(), getHeight())));
        g2.fill(area);
        g2.dispose();
        super.paint(grphcs);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.intvaria.swing.ButtonBadges btnCloseHeader;
    private com.intvaria.swing.ButtonBadges btnMinimize;
    // End of variables declaration//GEN-END:variables
}
