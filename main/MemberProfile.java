package com.intvaria.main;

import com.intvaria.DAO.MemberDAO;
import com.intvaria.entity.Member;
import com.intvaria.main.*;
import com.intvaria.event.EventMenu;
import com.intvaria.form.Form;
import com.intvaria.form.Form_1;
import com.intvaria.form.Register;

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class MemberProfile extends javax.swing.JFrame {

    Long membershipNumber;
    MemberDAO memberDao=new MemberDAO();
    
    public MemberProfile(Long memebr) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
jScrollPane1.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
    @Override
    protected void configureScrollBarColors() {
        this.thumbColor =new Color(0,153,153);
    }
    
});
    membershipNumber=memebr;
   getMemeber(membershipNumber);
        
    }

      public MemberProfile() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
  
    }
    
        private void getMemeber(Long membershipNumber){
         Member member=memberDao.getSingleMember(membershipNumber);
         if(member.getId()!=null){
             txtMembershipNumber.setText(String.valueOf(member.getMembership_number()));
            txtFirstName.setText(member.getFirst_name());
            txtLastName.setText(member.getLast_name());
             txtNic.setText(member.getNic());
           txtMobile.setText(member.getMobile());
            txtTelephone.setText(member.getHome_telephone());
            txtEmgMobile.setText(member.getEmerg_contact());
             txtEmgName.setText(member.getEmerg_name());
             txtEmgRelation.setText(member.getEmerg_relation());
             txtBirthday.setText(member.getBirthday());
            txtxHomeAddress.setText(member.getHome_address());
             txtOfficeAddress.setText(member.getOffice_address());
          txtPackage.setText(member.getPack().getName());
           txtxValidityTime.setText("From "+member.getFinance().getStartDate() +" To "+member.getFinance().getEndDate());
            String gender=member.getGender();
            txtGender.setText(gender);
            if(member.getFinance().isStatus()){
                txtValidity.setText("Valid");
                txtValidity.setForeground(Color.GREEN);
            }else{
                  txtValidity.setText("Expired");
                  txtValidity.setForeground(Color.red);
            }
               try {
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(member.getProImage()));
                    proImage.setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                    Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                }
             
           txtOpt1.setText(member.getOptions().getOpt1());
           txtOpt2.setText(member.getOptions().getOpt2());
           txtOpt3.setText(member.getOptions().getOpt3());
           txtOpt4.setText(member.getOptions().getOpt4());
           txtOpt5.setText(member.getOptions().getOpt5());
           txtOpt6.setText(member.getOptions().getOpt6());
           txtOpt7.setText(member.getOptions().getOpt7());
           txtOpt8.setText(member.getOptions().getOpt8());
           txtOpt9.setText(member.getOptions().getOpt9());
           txtOpt10.setText(member.getOptions().getOpt10());
           txtOpt11.setText(member.getOptions().getOpt11());
           
            
         }
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

        jLabel37 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        roundPanel1 = new com.intvaria.swing.RoundPanel();
        body = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtxHomeAddress = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        proImage = new com.intvaria.swing.ImageAvatar();
        jLabel20 = new javax.swing.JLabel();
        txtNic = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtGender = new javax.swing.JLabel();
        txtValidity = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtMembershipNumber = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtxValidityTime = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPackage = new javax.swing.JLabel();
        txtOfficeAddress = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBirthday = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtEmgMobile = new javax.swing.JLabel();
        txtLastName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JLabel();
        txtMobile = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtEmgName = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtEmgRelation = new javax.swing.JLabel();
        txtOpt1 = new javax.swing.JLabel();
        txtOpt2 = new javax.swing.JLabel();
        txtOpt3 = new javax.swing.JLabel();
        txtOpt4 = new javax.swing.JLabel();
        txtOpt5 = new javax.swing.JLabel();
        txtOpt6 = new javax.swing.JLabel();
        txtOpt7 = new javax.swing.JLabel();
        txtOpt8 = new javax.swing.JLabel();
        txtOpt9 = new javax.swing.JLabel();
        txtOpt10 = new javax.swing.JLabel();
        txtOpt11 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCloseHeader = new com.intvaria.swing.ButtonBadges();
        btnMinimize = new com.intvaria.swing.ButtonBadges();

        jLabel37.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(224, 224, 224));
        jLabel37.setText("Health Information");

        jButton2.setBackground(new java.awt.Color(0, 204, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Subbmit");

        jLabel38.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(224, 224, 224));
        jLabel38.setText("Are You a Heart Patient?");

        jLabel39.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(224, 224, 224));
        jLabel39.setText("Have You had a Heart Attack Before?");

        jLabel40.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(224, 224, 224));
        jLabel40.setText("Do you feel pain when exercising?");

        jLabel41.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(224, 224, 224));
        jLabel41.setText("Do you suffer from high blood pressure, high choleterol or diabetes?");

        jLabel42.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(224, 224, 224));
        jLabel42.setText("Do you suffer from asthma?");

        jLabel43.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(224, 224, 224));
        jLabel43.setText("Do you have any bone or muscle aches?");

        jLabel44.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(224, 224, 224));
        jLabel44.setText("Are you receiving treatment for any medical condition?");

        jLabel45.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(224, 224, 224));
        jLabel45.setText("Have you ever felt asthma / dizziness / shortness of breath lose while you exercising?");

        jLabel46.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(224, 224, 224));
        jLabel46.setText("Do you suffer from asthma?");

        jLabel47.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(224, 224, 224));
        jLabel47.setText("Have you had surgery?");

        jLabel48.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(224, 224, 224));
        jLabel48.setText("Has you doctor advices you not to Exercise");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        roundPanel1.setBackground(new java.awt.Color(25, 25, 25));

        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(25, 25, 25));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel4.setBackground(new java.awt.Color(25, 25, 25));

        jLabel53.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(224, 224, 224));
        jLabel53.setText("Do you suffer from high blood pressure, high choleterol or diabetes?");

        jLabel57.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(224, 224, 224));
        jLabel57.setText("Have you ever felt asthma / dizziness / shortness of breath lose while you exercising?");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(224, 224, 224));
        jLabel4.setText("Membership Id");

        jLabel32.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(224, 224, 224));
        jLabel32.setText("Contact Number");

        txtxHomeAddress.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtxHomeAddress.setForeground(new java.awt.Color(224, 224, 224));
        txtxHomeAddress.setText("Kegalle");

        jLabel59.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(224, 224, 224));
        jLabel59.setText("Have you had surgery?");

        proImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/intvaria/image/profile.png"))); // NOI18N
        proImage.setOpaque(true);

        jLabel20.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(224, 224, 224));
        jLabel20.setText("Mobile Number");

        txtNic.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtNic.setForeground(new java.awt.Color(224, 224, 224));
        txtNic.setText("44444444");

        jLabel19.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(224, 224, 224));
        jLabel19.setText("Last Name");

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(224, 224, 224));
        jLabel10.setText("Home Tel");

        jLabel52.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(224, 224, 224));
        jLabel52.setText("Do you feel pain when exercising?");

        jLabel56.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(224, 224, 224));
        jLabel56.setText("Are you receiving treatment for any medical condition?");

        jLabel29.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(224, 224, 224));
        jLabel29.setText("Relationship");

        txtGender.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtGender.setForeground(new java.awt.Color(224, 224, 224));
        txtGender.setText("Male");

        txtValidity.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtValidity.setForeground(new java.awt.Color(224, 224, 224));
        txtValidity.setText("Yes");

        jLabel22.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(224, 224, 224));
        jLabel22.setText("Emergency Contact Details");

        jLabel49.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(224, 224, 224));
        jLabel49.setText("Health Information");

        jLabel23.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(224, 224, 224));
        jLabel23.setText("Validity");

        txtMembershipNumber.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtMembershipNumber.setForeground(new java.awt.Color(224, 224, 224));
        txtMembershipNumber.setText(" 001");

        jLabel60.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(224, 224, 224));
        jLabel60.setText("Has you doctor advices you not to Exercise");

        jLabel24.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(224, 224, 224));
        jLabel24.setText("Office Address");

        txtxValidityTime.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtxValidityTime.setForeground(new java.awt.Color(224, 224, 224));
        txtxValidityTime.setText("6 month");

        jLabel54.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(224, 224, 224));
        jLabel54.setText("Do you suffer from asthma?");

        jLabel58.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(224, 224, 224));
        jLabel58.setText("Do you suffer from asthma?");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(224, 224, 224));
        jLabel8.setText("Home Address");

        txtPackage.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtPackage.setForeground(new java.awt.Color(224, 224, 224));
        txtPackage.setText("silver");

        txtOfficeAddress.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtOfficeAddress.setForeground(new java.awt.Color(224, 224, 224));
        txtOfficeAddress.setText("colomvo");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(224, 224, 224));
        jLabel6.setText("Nic");

        txtBirthday.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtBirthday.setForeground(new java.awt.Color(224, 224, 224));
        txtBirthday.setText("1995");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(224, 224, 224));
        jLabel5.setText("First Name");

        jLabel18.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(224, 224, 224));
        jLabel18.setText("Membership Package");

        txtEmgMobile.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtEmgMobile.setForeground(new java.awt.Color(224, 224, 224));
        txtEmgMobile.setText("55555555");

        txtLastName.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtLastName.setForeground(new java.awt.Color(224, 224, 224));
        txtLastName.setText("silva");

        txtFirstName.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtFirstName.setForeground(new java.awt.Color(224, 224, 224));
        txtFirstName.setText("umesh");

        txtMobile.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtMobile.setForeground(new java.awt.Color(224, 224, 224));
        txtMobile.setText("4445555");

        jLabel21.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(224, 224, 224));
        jLabel21.setText("Date Of Birth");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(224, 224, 224));
        jLabel9.setText("Valid Period");

        jLabel51.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(224, 224, 224));
        jLabel51.setText("Have You had a Heart Attack Before?");

        jLabel55.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(224, 224, 224));
        jLabel55.setText("Do you have any bone or muscle aches?");

        txtTelephone.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtTelephone.setForeground(new java.awt.Color(224, 224, 224));
        txtTelephone.setText("55555");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(224, 224, 224));
        jLabel7.setText("Gender");

        jLabel33.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(224, 224, 224));
        jLabel33.setText("Name");

        txtEmgName.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtEmgName.setForeground(new java.awt.Color(224, 224, 224));
        txtEmgName.setText("silva");

        jLabel50.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(224, 224, 224));
        jLabel50.setText("Are You a Heart Patient?");

        txtEmgRelation.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtEmgRelation.setForeground(new java.awt.Color(224, 224, 224));
        txtEmgRelation.setText("father");

        txtOpt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtOpt1.setForeground(new java.awt.Color(204, 204, 204));
        txtOpt1.setText("opt1");

        txtOpt2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtOpt2.setForeground(new java.awt.Color(204, 204, 204));
        txtOpt2.setText("opt2");

        txtOpt3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtOpt3.setForeground(new java.awt.Color(204, 204, 204));
        txtOpt3.setText("opt3");

        txtOpt4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtOpt4.setForeground(new java.awt.Color(204, 204, 204));
        txtOpt4.setText("opt4");

        txtOpt5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtOpt5.setForeground(new java.awt.Color(204, 204, 204));
        txtOpt5.setText("opt5");

        txtOpt6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtOpt6.setForeground(new java.awt.Color(204, 204, 204));
        txtOpt6.setText("opt6");

        txtOpt7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtOpt7.setForeground(new java.awt.Color(204, 204, 204));
        txtOpt7.setText("opt7");

        txtOpt8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtOpt8.setForeground(new java.awt.Color(204, 204, 204));
        txtOpt8.setText("opt8");

        txtOpt9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtOpt9.setForeground(new java.awt.Color(204, 204, 204));
        txtOpt9.setText("opt9");

        txtOpt10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtOpt10.setForeground(new java.awt.Color(204, 204, 204));
        txtOpt10.setText("opt10");

        txtOpt11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtOpt11.setForeground(new java.awt.Color(204, 204, 204));
        txtOpt11.setText("opt11");

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 204, 204));
        jLabel70.setText("Member Profile");

        jPanel2.setBackground(new java.awt.Color(25, 25, 25));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnCloseHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnCloseHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel29))
                        .addGap(135, 135, 135)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmgRelation)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGap(170, 170, 170)
                                        .addComponent(jLabel70)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEmgName)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(170, 170, 170)
                                                .addComponent(proImage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(72, 72, 72)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel32)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel23))
                                        .addGap(113, 113, 113)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMobile, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                        .addComponent(txtBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtOfficeAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValidity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmgMobile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel22)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)))
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(117, 117, 117)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtxValidityTime)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFirstName)
                                    .addComponent(txtMembershipNumber)))
                            .addComponent(txtNic)
                            .addComponent(txtTelephone)
                            .addComponent(txtxHomeAddress)
                            .addComponent(txtGender)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56)
                            .addComponent(jLabel57)
                            .addComponent(jLabel58)
                            .addComponent(jLabel59)
                            .addComponent(jLabel60))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOpt11)
                            .addComponent(txtOpt10)
                            .addComponent(txtOpt9)
                            .addComponent(txtOpt8)
                            .addComponent(txtOpt7)
                            .addComponent(txtOpt6)
                            .addComponent(txtOpt5)
                            .addComponent(txtOpt4)
                            .addComponent(txtOpt3)
                            .addComponent(txtOpt2)
                            .addComponent(txtOpt1)))
                    .addComponent(jLabel49))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel70)
                        .addGap(21, 21, 21)
                        .addComponent(proImage, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel5)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel7)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel6)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel10)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel8))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMembershipNumber)
                                    .addComponent(jLabel18)
                                    .addComponent(txtPackage))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFirstName)
                                    .addComponent(jLabel19)
                                    .addComponent(txtLastName))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtGender)
                                    .addComponent(jLabel21)
                                    .addComponent(txtBirthday))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNic)
                                    .addComponent(jLabel20)
                                    .addComponent(txtMobile))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTelephone)
                                    .addComponent(jLabel24)
                                    .addComponent(txtOfficeAddress))
                                .addGap(29, 29, 29)
                                .addComponent(txtxHomeAddress))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValidity)
                            .addComponent(jLabel23))))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtxValidityTime)
                    .addComponent(jLabel9))
                .addGap(42, 42, 42)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtEmgName)
                    .addComponent(jLabel32)
                    .addComponent(txtEmgMobile))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtEmgRelation))
                .addGap(38, 38, 38)
                .addComponent(jLabel49)
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtOpt1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtOpt2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtOpt3))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(txtOpt4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtOpt5))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtOpt6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtOpt7))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtOpt8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(txtOpt9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(txtOpt10))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(txtOpt11))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 476, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        body.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1351, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed

        //JFrame farame=(JFrame) Main.getFrames()[0];
        JFrame f=this;

        f.setExtendedState(JFrame.ICONIFIED);// One way

    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void btnCloseHeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseHeaderActionPerformed
        // showMessageDialog(null, "This is even shorter");
        this.dispose();
    }//GEN-LAST:event_btnCloseHeaderActionPerformed

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
            java.util.logging.Logger.getLogger(MemberProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MemberProfile(().setVisible(true);
                Long x=(long) 1;
                new MemberProfile(x).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private com.intvaria.swing.ButtonBadges btnCloseHeader;
    private com.intvaria.swing.ButtonBadges btnMinimize;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.intvaria.swing.ImageAvatar proImage;
    private com.intvaria.swing.RoundPanel roundPanel1;
    private javax.swing.JLabel txtBirthday;
    private javax.swing.JLabel txtEmgMobile;
    private javax.swing.JLabel txtEmgName;
    private javax.swing.JLabel txtEmgRelation;
    private javax.swing.JLabel txtFirstName;
    private javax.swing.JLabel txtGender;
    private javax.swing.JLabel txtLastName;
    private javax.swing.JLabel txtMembershipNumber;
    private javax.swing.JLabel txtMobile;
    private javax.swing.JLabel txtNic;
    private javax.swing.JLabel txtOfficeAddress;
    private javax.swing.JLabel txtOpt1;
    private javax.swing.JLabel txtOpt10;
    private javax.swing.JLabel txtOpt11;
    private javax.swing.JLabel txtOpt2;
    private javax.swing.JLabel txtOpt3;
    private javax.swing.JLabel txtOpt4;
    private javax.swing.JLabel txtOpt5;
    private javax.swing.JLabel txtOpt6;
    private javax.swing.JLabel txtOpt7;
    private javax.swing.JLabel txtOpt8;
    private javax.swing.JLabel txtOpt9;
    private javax.swing.JLabel txtPackage;
    private javax.swing.JLabel txtTelephone;
    private javax.swing.JLabel txtValidity;
    private javax.swing.JLabel txtxHomeAddress;
    private javax.swing.JLabel txtxValidityTime;
    // End of variables declaration//GEN-END:variables
}
