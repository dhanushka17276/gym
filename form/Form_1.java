package com.intvaria.form;


import com.intvaria.DAO.MemberDAO;
import com.intvaria.DAO.PackageDAO;
import com.intvaria.entity.Fianace;
import com.intvaria.entity.Member;
import com.intvaria.entity.PackageDetails;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Form_1 extends javax.swing.JPanel {

    int sec;
    MemberDAO memberDao=new MemberDAO();
    Member currentMember=null; 
    Fianace membrFinace=null;
    PackageDAO pckDao=new PackageDAO();
     Timer t=null ;
    
    public Form_1() {
        initComponents();
        setOpaque(false);
      
       
        
        if(currentMember!=null){
            loadUser(currentMember,membrFinace);
            
        }
    }

    
    public void packageStatus(int x){
        
      
         t=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                 if(x==1){
                if(sec%2==0){
                    txtStatus.setText("Expired");
                  
                    if(jPanel3.isDisplayable()){
                          playBeep(x);
                    }
                }else{
                    txtStatus.setText("");
                     
                    
                }
                    
                
                sec--;
                 }
            }
        });
       
             t.start();
        
       
        
    }
    
    public void playBeep(int x){
     String filePath = "src\\com\\intvaria\\sound\\beep-04.wav";
      
        
        
        try {
            
            if(x==1){
                InputStream music=new FileInputStream(new File(filePath));
      
             AudioStream audios=new AudioStream(music);
            
         AudioPlayer.player.start(audios);
            }else{
                AudioPlayer.player.stop();
            }
              
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }
    
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.intvaria.swing.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();
        txtPackageStauts = new javax.swing.JLabel();
        txtPackage = new javax.swing.JLabel();
        txtEndDate = new javax.swing.JLabel();
        roundPanel2 = new com.intvaria.swing.RoundPanel();
        roundPanel4 = new com.intvaria.swing.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        imgProfile = new com.intvaria.swing.ImageAvatar();
        txtMobile = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtNic = new javax.swing.JLabel();
        txtAddress = new javax.swing.JLabel();
        roundPanel3 = new com.intvaria.swing.RoundPanel();
        jPanel4 = new javax.swing.JPanel();
        txtStatus1 = new javax.swing.JLabel();
        txtMembershipNumber = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(25, 25, 25));

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(220, 220, 220));
        jLabel2.setText("Package Details");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jPanel3.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 220, 220));
        jLabel3.setText("Package  :");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(220, 220, 220));
        jLabel4.setText("Validation :");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(220, 220, 220));
        jLabel5.setText("Package expiring date");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        txtStatus.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtStatus.setForeground(new java.awt.Color(255, 0, 0));
        txtStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtPackageStauts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPackageStauts.setForeground(new java.awt.Color(0, 102, 102));

        txtPackage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPackage.setForeground(new java.awt.Color(0, 102, 102));

        txtEndDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEndDate.setForeground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPackageStauts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPackage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPackage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPackageStauts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        roundPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(220, 220, 220));
        jLabel6.setText("Member Details");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        imgProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/intvaria/image/profile.png"))); // NOI18N

        txtMobile.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtMobile.setForeground(new java.awt.Color(220, 220, 220));
        txtMobile.setText("Mobile Number");
        txtMobile.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        txtName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(220, 220, 220));
        txtName.setText("Name :");
        txtName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        txtNic.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtNic.setForeground(new java.awt.Color(220, 220, 220));
        txtNic.setText("Nic");
        txtNic.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        txtAddress.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(220, 220, 220));
        txtAddress.setText("Address");
        txtAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(imgProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMobile, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(imgProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(txtName)
                        .addGap(18, 18, 18)
                        .addComponent(txtNic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAddress)
                        .addGap(18, 18, 18)
                        .addComponent(txtMobile)
                        .addGap(126, 126, 126))))
        );

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        roundPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jPanel4.setOpaque(false);

        txtStatus1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtStatus1.setForeground(new java.awt.Color(255, 255, 255));
        txtStatus1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtStatus1.setText("  Enter Membership Number");

        txtMembershipNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMembershipNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMembershipNumberActionPerformed(evt);
            }
        });
        txtMembershipNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMembershipNumberKeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtStatus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(txtMembershipNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 63, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMembershipNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
            .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMembershipNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMembershipNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMembershipNumberActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
      saveAttendence();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void saveAttendence(){
          String memborshipNumber=txtMembershipNumber.getText();
        Fianace finance=null;
        Member member=null; 
        currentMember=null;
        membrFinace=null;
        boolean isAttend=false;
        if(memborshipNumber.length()!=0){
            try {
                isAttend=memberDao.saveAttendance(Long.parseLong(memborshipNumber), false);
            } catch (ParseException ex) {
                Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(isAttend==true){
                 currentMember=memberDao.getSingleMember(Long.parseLong(memborshipNumber));
            membrFinace=memberDao.checkMemberFinance(Long.parseLong(memborshipNumber));
           loadUser(currentMember,membrFinace);
            }else{
                JOptionPane.showMessageDialog(null, "Anntend failed . Please try agin!" ,"Warning" , JOptionPane.WARNING_MESSAGE);
            }
           
        }else{
            JOptionPane.showMessageDialog(null, "Please Enter Membership Number");
        }
    }
    
    private void txtMembershipNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMembershipNumberKeyPressed
      // press enter
      
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           saveAttendence();
        }
    }//GEN-LAST:event_txtMembershipNumberKeyPressed

    private void loadUser(Member member,Fianace finance){
        PackageDetails pck=null;
         if(member.getId()!=null){
                txtName.setText("Name : "+member.getFirst_name() + " " + member.getLast_name());
                txtNic.setText("NIC : "+member.getNic());
                txtAddress.setText("Address : " +member.getHome_address());
                txtMobile.setText("Mobile Number : "+member.getMobile());
               if(finance.isStatus()){
                    txtPackageStauts.setText("Valid");
                    txtPackageStauts.setForeground(Color.green);
                     txtStatus.setText("Vaild");
                     txtStatus.setForeground(Color.green);
                    
                   //   packageStatus(0);
                   if(t!=null){
                       t.stop();
                   }
                       
               }else{
                   txtPackageStauts.setText("Expired");
                    txtPackageStauts.setForeground(Color.red);
                    txtStatus.setForeground(Color.red);
                    packageStatus(1);
               }
               txtEndDate.setText(String.valueOf(finance.getEndDate()));
               pck=pckDao.getPackegeById(finance.getPackageId());
               txtPackage.setText(pck.getName());
                try {
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(member.getProImage()));
                    imgProfile.setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                    Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
              JOptionPane.showMessageDialog(null, "Ivalid membership number. Plase check and enter again");  
            }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.intvaria.swing.ImageAvatar imgProfile;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private com.intvaria.swing.RoundPanel roundPanel1;
    private com.intvaria.swing.RoundPanel roundPanel2;
    private com.intvaria.swing.RoundPanel roundPanel3;
    private com.intvaria.swing.RoundPanel roundPanel4;
    private javax.swing.JLabel txtAddress;
    private javax.swing.JLabel txtEndDate;
    private javax.swing.JTextField txtMembershipNumber;
    private javax.swing.JLabel txtMobile;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtNic;
    private javax.swing.JLabel txtPackage;
    private javax.swing.JLabel txtPackageStauts;
    private javax.swing.JLabel txtStatus;
    private javax.swing.JLabel txtStatus1;
    // End of variables declaration//GEN-END:variables
}
