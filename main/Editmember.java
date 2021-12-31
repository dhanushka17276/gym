package com.intvaria.main;

import com.intvaria.DAO.MemberDAO;
import com.intvaria.entity.Member;
import com.intvaria.entity.Options;
import com.intvaria.main.*;
import com.intvaria.event.EventMenu;
import com.intvaria.form.Form;
import com.intvaria.form.Form_1;
import com.intvaria.form.Register;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicScrollBarUI;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Editmember extends javax.swing.JFrame {

    Long membershipNumber;
    MemberDAO memberDao=new MemberDAO();
     byte[] image;
    String imagePath="";
    ImageIcon myImage;
    File f;
    public Editmember(String membershipNumb) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
            membershipNumber=Long.parseLong(membershipNumb);
             jScrollPane2.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
    @Override
    protected void configureScrollBarColors() {
        this.thumbColor =new Color(0,153,153);
    }
});
       
       getMemeber();
       
         opt1Y.setActionCommand("Yes");
       opt1N.setActionCommand("No");
       
        opt2Y.setActionCommand("Yes");
       opt2N.setActionCommand("No");
       
        opt3Y.setActionCommand("Yes");
       opt3N.setActionCommand("No");
       
        opt4Y.setActionCommand("Yes");
       opt4N.setActionCommand("No");
       
        opt5Y.setActionCommand("Yes");
       opt5N.setActionCommand("No");
       
        opt6Y.setActionCommand("Yes");
       opt6N.setActionCommand("No");
       
        opt7Y.setActionCommand("Yes");
       opt7N.setActionCommand("No");
       
        opt8Y.setActionCommand("Yes");
       opt8N.setActionCommand("No");
       
        opt9Y.setActionCommand("Yes");
       opt9N.setActionCommand("No");
       
        opt10Y.setActionCommand("Yes");
       opt10N.setActionCommand("No");
       
        opt11Y.setActionCommand("Yes");
       opt11N.setActionCommand("No");
       // showForm(new Register());
    }

     public Editmember() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));

       // showForm(new Register());
    }
    
     
     private void getMemeber(){
         Member member=memberDao.getSingleMember(membershipNumber);
         if(member.getId()!=null){
             txtMemeberNumber.setText(String.valueOf(member.getMembership_number()));
             txtFirstName.setText(member.getFirst_name());
             txtLastName.setText(member.getLast_name());
             txtNic.setText(member.getNic());
             txtmobile.setText(member.getMobile());
             txtTelephone.setText(member.getHome_telephone());
             txtEmgMobile.setText(member.getEmerg_contact());
             txtEmgName.setText(member.getEmerg_name());
             txtEmgRealtion.setText(member.getEmerg_relation());
             txtirthday.setText(member.getBirthday());
             txtHomeAddrress.setText(member.getHome_address());
             txtOfficeaddress.setText(member.getOffice_address());
            txtPackageName.setText(member.getPack().getName());
             txtPackageDates.setText("From "+member.getFinance().getStartDate() +" To "+member.getFinance().getEndDate());
             String gender=member.getGender();
             
               try {
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(member.getProImage()));
                    proImage.setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                    Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                }
             
             if(gender.equals("Male")){
                 comboGender.setSelectedIndex(0);
             }else{
                 comboGender.setSelectedIndex(1);
             }
             
             if(member.getOptions()!=null){
                 
             if(member.getOptions().getOpt1().equals("Yes")){
                 buttonGroup1.setSelected(opt1Y.getModel(), true);
             }else{
                  buttonGroup1.setSelected(opt1N.getModel(), true);
             } 
             
             if(member.getOptions().getOpt2().equals("Yes")){
                 buttonGroup2.setSelected(opt2Y.getModel(), true);
             }else{
                  buttonGroup2.setSelected(opt2N.getModel(), true);
             } 
             
             if(member.getOptions().getOpt3().equals("Yes")){
                 buttonGroup3.setSelected(opt3Y.getModel(), true);
             }else{
                  buttonGroup3.setSelected(opt3N.getModel(), true);
             } 
             
             if(member.getOptions().getOpt4().equals("Yes")){
                 buttonGroup4.setSelected(opt4Y.getModel(), true);
             }else{
                  buttonGroup4.setSelected(opt4N.getModel(), true);
             } 
             
             if(member.getOptions().getOpt5().equals("Yes")){
                 buttonGroup5.setSelected(opt5Y.getModel(), true);
             }else{
                  buttonGroup5.setSelected(opt5N.getModel(), true);
             } 
             
             if(member.getOptions().getOpt6().equals("Yes")){
                 buttonGroup6.setSelected(opt6Y.getModel(), true);
             }else{
                  buttonGroup6.setSelected(opt6N.getModel(), true);
             } 
             
             if(member.getOptions().getOpt7().equals("Yes")){
                 buttonGroup7.setSelected(opt7Y.getModel(), true);
             }else{
                  buttonGroup7.setSelected(opt7N.getModel(), true);
             } 
             
             if(member.getOptions().getOpt8().equals("Yes")){
                 buttonGroup8.setSelected(opt8Y.getModel(), true);
             }else{
                  buttonGroup8.setSelected(opt8N.getModel(), true);
             } 
             
             if(member.getOptions().getOpt9().equals("Yes")){
                 buttonGroup9.setSelected(opt9Y.getModel(), true);
             }else{
                  buttonGroup9.setSelected(opt9N.getModel(), true);
             } 
             
             if(member.getOptions().getOpt10().equals("Yes")){
                 buttonGroup10.setSelected(opt10Y.getModel(), true);
             }else{
                  buttonGroup10.setSelected(opt10N.getModel(), true);
             } 
             
             if(member.getOptions().getOpt11().equals("Yes")){
                 buttonGroup11.setSelected(opt11Y.getModel(), true);
             }else{
                  buttonGroup11.setSelected(opt11N.getModel(), true);
             } 
             
             }
            
         }
     }
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        roundPanel1 = new com.intvaria.swing.RoundPanel();
        body = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        roundPanel2 = new com.intvaria.swing.RoundPanel();
        header3 = new com.intvaria.component.Header();
        jLabel1 = new javax.swing.JLabel();
        proImage = new com.intvaria.swing.ImageAvatar();
        imageName = new javax.swing.JLabel();
        imagePath2 = new javax.swing.JLabel();
        JFileChooser = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        roundPanel5 = new com.intvaria.swing.RoundPanel();
        txtirthday = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        roundPanel19 = new com.intvaria.swing.RoundPanel();
        txtLastName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        roundPanel4 = new com.intvaria.swing.RoundPanel();
        txtFirstName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboGender = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        roundPanel7 = new com.intvaria.swing.RoundPanel();
        txtmobile = new javax.swing.JTextField();
        roundPanel11 = new com.intvaria.swing.RoundPanel();
        txtNic = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        roundPanel8 = new com.intvaria.swing.RoundPanel();
        txtEmgName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        roundPanel10 = new com.intvaria.swing.RoundPanel();
        jTextField9 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        roundPanel22 = new com.intvaria.swing.RoundPanel();
        txtEmgRealtion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        roundPanel14 = new com.intvaria.swing.RoundPanel();
        txtTelephone = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        opt1Y = new javax.swing.JRadioButton();
        opt1N = new javax.swing.JRadioButton();
        opt2Y = new javax.swing.JRadioButton();
        opt3Y = new javax.swing.JRadioButton();
        opt2N = new javax.swing.JRadioButton();
        opt3N = new javax.swing.JRadioButton();
        opt4N = new javax.swing.JRadioButton();
        opt4Y = new javax.swing.JRadioButton();
        opt5N = new javax.swing.JRadioButton();
        opt5Y = new javax.swing.JRadioButton();
        opt6N = new javax.swing.JRadioButton();
        opt6Y = new javax.swing.JRadioButton();
        opt7N = new javax.swing.JRadioButton();
        opt7Y = new javax.swing.JRadioButton();
        opt8N = new javax.swing.JRadioButton();
        opt8Y = new javax.swing.JRadioButton();
        opt9N = new javax.swing.JRadioButton();
        opt9Y = new javax.swing.JRadioButton();
        opt10N = new javax.swing.JRadioButton();
        opt10Y = new javax.swing.JRadioButton();
        opt11N = new javax.swing.JRadioButton();
        opt11Y = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        roundPanel9 = new com.intvaria.swing.RoundPanel();
        txtEmgMobile = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        roundPanel13 = new com.intvaria.swing.RoundPanel();
        txtOfficeaddress = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        roundPanel12 = new com.intvaria.swing.RoundPanel();
        txtHomeAddrress = new javax.swing.JTextField();
        txtMemeberNumber = new javax.swing.JLabel();
        txtPackageDates = new javax.swing.JLabel();
        txtPackageName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCloseHeader = new com.intvaria.swing.ButtonBadges();
        btnMinimize = new com.intvaria.swing.ButtonBadges();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1371, 746));
        setResizable(false);

        roundPanel1.setBackground(new java.awt.Color(25, 25, 25));

        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("   Edit  Member  Form");

        proImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/intvaria/image/profile.png"))); // NOI18N
        proImage.setOpaque(true);

        imageName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        imageName.setForeground(new java.awt.Color(153, 153, 153));
        imageName.setText("Image Name");

        imagePath2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        imagePath2.setForeground(new java.awt.Color(153, 153, 153));
        imagePath2.setText("Image Path");

        JFileChooser.setText("Choose");
        JFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooserActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(224, 224, 224));
        jLabel18.setText("Membership Number");

        jLabel19.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(224, 224, 224));
        jLabel19.setText("Membership Package");

        roundPanel5.setBackground(new java.awt.Color(25, 25, 25));

        txtirthday.setBackground(new java.awt.Color(25, 25, 25));
        txtirthday.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtirthday.setForeground(new java.awt.Color(255, 255, 255));
        txtirthday.setBorder(null);

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtirthday, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtirthday, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(224, 224, 224));
        jLabel6.setText("Birth Day");

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(224, 224, 224));
        jLabel17.setText("Last Name");

        roundPanel19.setBackground(new java.awt.Color(25, 25, 25));

        txtLastName.setBackground(new java.awt.Color(25, 25, 25));
        txtLastName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtLastName.setForeground(new java.awt.Color(255, 255, 255));
        txtLastName.setBorder(null);

        javax.swing.GroupLayout roundPanel19Layout = new javax.swing.GroupLayout(roundPanel19);
        roundPanel19.setLayout(roundPanel19Layout);
        roundPanel19Layout.setHorizontalGroup(
            roundPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel19Layout.setVerticalGroup(
            roundPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(224, 224, 224));
        jLabel9.setText("Telephone Number (Home)");

        roundPanel4.setBackground(new java.awt.Color(25, 25, 25));

        txtFirstName.setBackground(new java.awt.Color(25, 25, 25));
        txtFirstName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtFirstName.setForeground(new java.awt.Color(255, 255, 255));
        txtFirstName.setBorder(null);

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(224, 224, 224));
        jLabel4.setText("First Name");

        comboGender.setBackground(new java.awt.Color(102, 102, 102));
        comboGender.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        comboGender.setForeground(new java.awt.Color(255, 255, 255));
        comboGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        comboGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGenderActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(224, 224, 224));
        jLabel5.setText("Gender");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(224, 224, 224));
        jLabel8.setText("Mobile Number");

        roundPanel7.setBackground(new java.awt.Color(25, 25, 25));

        txtmobile.setBackground(new java.awt.Color(25, 25, 25));
        txtmobile.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtmobile.setForeground(new java.awt.Color(255, 255, 255));
        txtmobile.setBorder(null);

        javax.swing.GroupLayout roundPanel7Layout = new javax.swing.GroupLayout(roundPanel7);
        roundPanel7.setLayout(roundPanel7Layout);
        roundPanel7Layout.setHorizontalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtmobile)
                .addContainerGap())
        );
        roundPanel7Layout.setVerticalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        roundPanel11.setBackground(new java.awt.Color(25, 25, 25));

        txtNic.setBackground(new java.awt.Color(25, 25, 25));
        txtNic.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtNic.setForeground(new java.awt.Color(255, 255, 255));
        txtNic.setBorder(null);

        javax.swing.GroupLayout roundPanel11Layout = new javax.swing.GroupLayout(roundPanel11);
        roundPanel11.setLayout(roundPanel11Layout);
        roundPanel11Layout.setHorizontalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNic)
                .addContainerGap())
        );
        roundPanel11Layout.setVerticalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNic, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(224, 224, 224));
        jLabel11.setText("NIC Number");

        jLabel20.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(224, 224, 224));
        jLabel20.setText("Emergency Contact Details");

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(224, 224, 224));
        jLabel10.setText("Name");

        roundPanel8.setBackground(new java.awt.Color(25, 25, 25));

        txtEmgName.setBackground(new java.awt.Color(25, 25, 25));
        txtEmgName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtEmgName.setForeground(new java.awt.Color(255, 255, 255));
        txtEmgName.setBorder(null);

        javax.swing.GroupLayout roundPanel8Layout = new javax.swing.GroupLayout(roundPanel8);
        roundPanel8.setLayout(roundPanel8Layout);
        roundPanel8Layout.setHorizontalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEmgName, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel8Layout.setVerticalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmgName, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(224, 224, 224));
        jLabel12.setText("Telephone Number");

        roundPanel10.setBackground(new java.awt.Color(25, 25, 25));

        jTextField9.setBackground(new java.awt.Color(25, 25, 25));
        jTextField9.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setBorder(null);

        javax.swing.GroupLayout roundPanel10Layout = new javax.swing.GroupLayout(roundPanel10);
        roundPanel10.setLayout(roundPanel10Layout);
        roundPanel10Layout.setHorizontalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel10Layout.setVerticalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel21.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(224, 224, 224));
        jLabel21.setText("Relationship");

        roundPanel22.setBackground(new java.awt.Color(25, 25, 25));

        txtEmgRealtion.setBackground(new java.awt.Color(25, 25, 25));
        txtEmgRealtion.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtEmgRealtion.setForeground(new java.awt.Color(255, 255, 255));
        txtEmgRealtion.setBorder(null);

        javax.swing.GroupLayout roundPanel22Layout = new javax.swing.GroupLayout(roundPanel22);
        roundPanel22.setLayout(roundPanel22Layout);
        roundPanel22Layout.setHorizontalGroup(
            roundPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEmgRealtion)
                .addContainerGap())
        );
        roundPanel22Layout.setVerticalGroup(
            roundPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmgRealtion, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(224, 224, 224));
        jLabel15.setText("Health Information");

        jLabel16.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(224, 224, 224));
        jLabel16.setText("Are You a Heart Patient?");

        jLabel22.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(224, 224, 224));
        jLabel22.setText("Have You had a Heart Attack Before?");

        jLabel23.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(224, 224, 224));
        jLabel23.setText("Do you feel pain when exercising?");

        jLabel24.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(224, 224, 224));
        jLabel24.setText("Do you suffer from high blood pressure, high choleterol or diabetes?");

        jLabel25.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(224, 224, 224));
        jLabel25.setText("Do you suffer from asthma?");

        jLabel26.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(224, 224, 224));
        jLabel26.setText("Do you have any bone or muscle aches?");

        jLabel27.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(224, 224, 224));
        jLabel27.setText("Are you receiving treatment for any medical condition?");

        jLabel28.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(224, 224, 224));
        jLabel28.setText("Have you ever felt asthma / dizziness / shortness of breath lose while you exercising?");

        jLabel29.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(224, 224, 224));
        jLabel29.setText("Do you suffer from asthma?");

        jLabel30.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(224, 224, 224));
        jLabel30.setText("Have you had surgery?");

        jLabel31.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(224, 224, 224));
        jLabel31.setText("Has you doctor advices you not to Exercise");

        roundPanel14.setBackground(new java.awt.Color(25, 25, 25));

        txtTelephone.setBackground(new java.awt.Color(25, 25, 25));
        txtTelephone.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtTelephone.setForeground(new java.awt.Color(255, 255, 255));
        txtTelephone.setBorder(null);

        jLabel32.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(224, 224, 224));
        jLabel32.setText("Mobile Number");

        javax.swing.GroupLayout roundPanel14Layout = new javax.swing.GroupLayout(roundPanel14);
        roundPanel14.setLayout(roundPanel14Layout);
        roundPanel14Layout.setHorizontalGroup(
            roundPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTelephone)
                .addContainerGap())
        );
        roundPanel14Layout.setVerticalGroup(
            roundPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTelephone, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel33.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(224, 224, 224));
        jLabel33.setText("Home Telephone ");

        jLabel2.setText("jLabel2");

        opt1Y.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(opt1Y);
        opt1Y.setForeground(new java.awt.Color(204, 204, 204));
        opt1Y.setText("Yes");
        opt1Y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt1YActionPerformed(evt);
            }
        });

        opt1N.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(opt1N);
        opt1N.setForeground(new java.awt.Color(204, 204, 204));
        opt1N.setText("No");

        opt2Y.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup2.add(opt2Y);
        opt2Y.setForeground(new java.awt.Color(255, 255, 255));
        opt2Y.setText("Yes");

        opt3Y.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup3.add(opt3Y);
        opt3Y.setForeground(new java.awt.Color(255, 255, 255));
        opt3Y.setText("Yes");

        opt2N.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup2.add(opt2N);
        opt2N.setForeground(new java.awt.Color(255, 255, 255));
        opt2N.setText("No");

        opt3N.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup3.add(opt3N);
        opt3N.setForeground(new java.awt.Color(255, 255, 255));
        opt3N.setText("No");
        opt3N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt3NActionPerformed(evt);
            }
        });

        opt4N.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup4.add(opt4N);
        opt4N.setForeground(new java.awt.Color(255, 255, 255));
        opt4N.setText("No");
        opt4N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt4NActionPerformed(evt);
            }
        });

        opt4Y.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup4.add(opt4Y);
        opt4Y.setForeground(new java.awt.Color(255, 255, 255));
        opt4Y.setText("Yes");

        opt5N.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup5.add(opt5N);
        opt5N.setForeground(new java.awt.Color(255, 255, 255));
        opt5N.setText("No");
        opt5N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt5NActionPerformed(evt);
            }
        });

        opt5Y.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup5.add(opt5Y);
        opt5Y.setForeground(new java.awt.Color(255, 255, 255));
        opt5Y.setText("Yes");

        opt6N.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup6.add(opt6N);
        opt6N.setForeground(new java.awt.Color(255, 255, 255));
        opt6N.setText("No");
        opt6N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt6NActionPerformed(evt);
            }
        });

        opt6Y.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup6.add(opt6Y);
        opt6Y.setForeground(new java.awt.Color(255, 255, 255));
        opt6Y.setText("Yes");

        opt7N.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup7.add(opt7N);
        opt7N.setForeground(new java.awt.Color(255, 255, 255));
        opt7N.setText("No");
        opt7N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt7NActionPerformed(evt);
            }
        });

        opt7Y.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup7.add(opt7Y);
        opt7Y.setForeground(new java.awt.Color(255, 255, 255));
        opt7Y.setText("Yes");

        opt8N.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup8.add(opt8N);
        opt8N.setForeground(new java.awt.Color(255, 255, 255));
        opt8N.setText("No");
        opt8N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt8NActionPerformed(evt);
            }
        });

        opt8Y.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup8.add(opt8Y);
        opt8Y.setForeground(new java.awt.Color(255, 255, 255));
        opt8Y.setText("Yes");

        opt9N.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup9.add(opt9N);
        opt9N.setForeground(new java.awt.Color(255, 255, 255));
        opt9N.setText("No");
        opt9N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt9NActionPerformed(evt);
            }
        });

        opt9Y.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup9.add(opt9Y);
        opt9Y.setForeground(new java.awt.Color(255, 255, 255));
        opt9Y.setText("Yes");
        opt9Y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt9YActionPerformed(evt);
            }
        });

        opt10N.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup10.add(opt10N);
        opt10N.setForeground(new java.awt.Color(255, 255, 255));
        opt10N.setText("No");
        opt10N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt10NActionPerformed(evt);
            }
        });

        opt10Y.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup10.add(opt10Y);
        opt10Y.setForeground(new java.awt.Color(255, 255, 255));
        opt10Y.setText("Yes");
        opt10Y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt10YActionPerformed(evt);
            }
        });

        opt11N.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup11.add(opt11N);
        opt11N.setForeground(new java.awt.Color(255, 255, 255));
        opt11N.setText("No");
        opt11N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt11NActionPerformed(evt);
            }
        });

        opt11Y.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup11.add(opt11Y);
        opt11Y.setForeground(new java.awt.Color(255, 255, 255));
        opt11Y.setText("Yes");

        jButton1.setBackground(new java.awt.Color(255, 51, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(224, 224, 224));
        jLabel34.setText("Mobile Number");

        roundPanel9.setBackground(new java.awt.Color(25, 25, 25));

        txtEmgMobile.setBackground(new java.awt.Color(25, 25, 25));
        txtEmgMobile.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtEmgMobile.setForeground(new java.awt.Color(255, 255, 255));
        txtEmgMobile.setBorder(null);

        javax.swing.GroupLayout roundPanel9Layout = new javax.swing.GroupLayout(roundPanel9);
        roundPanel9.setLayout(roundPanel9Layout);
        roundPanel9Layout.setHorizontalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEmgMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel9Layout.setVerticalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmgMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(224, 224, 224));
        jLabel14.setText("Office Address");

        roundPanel13.setBackground(new java.awt.Color(25, 25, 25));

        txtOfficeaddress.setBackground(new java.awt.Color(25, 25, 25));
        txtOfficeaddress.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtOfficeaddress.setForeground(new java.awt.Color(255, 255, 255));
        txtOfficeaddress.setBorder(null);

        javax.swing.GroupLayout roundPanel13Layout = new javax.swing.GroupLayout(roundPanel13);
        roundPanel13.setLayout(roundPanel13Layout);
        roundPanel13Layout.setHorizontalGroup(
            roundPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtOfficeaddress)
                .addContainerGap())
        );
        roundPanel13Layout.setVerticalGroup(
            roundPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtOfficeaddress, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(224, 224, 224));
        jLabel13.setText("Home Address");

        roundPanel12.setBackground(new java.awt.Color(25, 25, 25));

        txtHomeAddrress.setBackground(new java.awt.Color(25, 25, 25));
        txtHomeAddrress.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtHomeAddrress.setForeground(new java.awt.Color(255, 255, 255));
        txtHomeAddrress.setBorder(null);

        javax.swing.GroupLayout roundPanel12Layout = new javax.swing.GroupLayout(roundPanel12);
        roundPanel12.setLayout(roundPanel12Layout);
        roundPanel12Layout.setHorizontalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHomeAddrress, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel12Layout.setVerticalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtHomeAddrress, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(roundPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(20, 20, 20)
                .addComponent(roundPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtMemeberNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMemeberNumber.setForeground(new java.awt.Color(255, 51, 51));
        txtMemeberNumber.setText("number");

        txtPackageDates.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPackageDates.setForeground(new java.awt.Color(102, 204, 0));
        txtPackageDates.setText("package");

        txtPackageName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPackageName.setForeground(new java.awt.Color(102, 204, 0));
        txtPackageName.setText("package");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(roundPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(109, 109, 109)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel33)
                            .addComponent(jLabel17)
                            .addComponent(roundPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(comboGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(406, 406, 406))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                                    .addGap(440, 440, 440)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel29)
                                .addComponent(jLabel30)
                                .addComponent(jLabel31)
                                .addGroup(roundPanel2Layout.createSequentialGroup()
                                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel27)
                                        .addComponent(jLabel28))
                                    .addGap(30, 30, 30)
                                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(roundPanel2Layout.createSequentialGroup()
                                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(opt4Y)
                                                .addComponent(opt5Y)
                                                .addComponent(opt6Y)
                                                .addComponent(opt7Y)
                                                .addComponent(opt8Y)
                                                .addComponent(opt9Y)
                                                .addComponent(opt10Y)
                                                .addComponent(opt11Y))
                                            .addGap(72, 72, 72)
                                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(opt11N)
                                                .addComponent(opt10N)
                                                .addComponent(opt9N)
                                                .addComponent(opt8N)
                                                .addComponent(opt7N)
                                                .addComponent(opt6N)
                                                .addComponent(opt5N)
                                                .addComponent(opt4N)))
                                        .addGroup(roundPanel2Layout.createSequentialGroup()
                                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(opt2Y)
                                                .addComponent(opt3Y)
                                                .addComponent(opt1Y, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(opt1N, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(opt3N)
                                                .addComponent(opt2N))))))
                            .addComponent(jLabel21)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1450, Short.MAX_VALUE)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(roundPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(377, 377, 377))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(roundPanel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel10))
                            .addComponent(roundPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(roundPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(439, 439, 439)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(417, 417, 417)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(header3, javax.swing.GroupLayout.PREFERRED_SIZE, 1325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(proImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imageName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imagePath2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMemeberNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                .addComponent(txtPackageName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtPackageDates, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(261, Short.MAX_VALUE))
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(header3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(imageName)
                                .addGap(15, 15, 15)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(imagePath2)
                                    .addComponent(txtMemeberNumber))
                                .addGap(16, 16, 16)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)))
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPackageName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPackageDates, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(roundPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roundPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(comboGender, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel33)
                                .addGap(18, 18, 18)
                                .addComponent(roundPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)))
                .addComponent(jLabel8)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(493, 493, 493)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(roundPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(roundPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roundPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addComponent(roundPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(roundPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel15)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(opt1Y, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(opt1N, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34))
                                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(opt2Y)
                                        .addComponent(opt2N)))
                                .addGap(34, 34, 34))
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(opt3Y)
                                .addComponent(opt3N)))))
                .addGap(27, 27, 27)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(opt4Y)
                    .addComponent(opt4N))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(opt5Y)
                    .addComponent(opt5N))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(opt6Y)
                    .addComponent(opt6N))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(opt7Y)
                    .addComponent(opt7N))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(opt8Y)
                    .addComponent(opt8N))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(opt9Y)
                    .addComponent(opt9N))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(opt10Y)
                    .addComponent(opt10N))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(opt11Y)
                    .addComponent(opt11N))
                .addGap(102, 102, 102)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(381, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(roundPanel2);

        body.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

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
                .addContainerGap(1039, Short.MAX_VALUE)
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
                    .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnCloseHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1357, Short.MAX_VALUE))
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

    private void btnCloseHeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseHeaderActionPerformed
        // showMessageDialog(null, "This is even shorter");
      this.dispose();
    }//GEN-LAST:event_btnCloseHeaderActionPerformed

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed

        //JFrame farame=(JFrame) Main.getFrames()[0];
        JFrame edit = this;
           edit.setExtendedState(JFrame.ICONIFIED);// One way
        

    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void opt11NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt11NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt11NActionPerformed

    private void opt10YActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt10YActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt10YActionPerformed

    private void opt10NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt10NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt10NActionPerformed

    private void opt9YActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt9YActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt9YActionPerformed

    private void opt9NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt9NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt9NActionPerformed

    private void opt8NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt8NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt8NActionPerformed

    private void opt7NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt7NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt7NActionPerformed

    private void opt6NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt6NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt6NActionPerformed

    private void opt5NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt5NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt5NActionPerformed

    private void opt4NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt4NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt4NActionPerformed

    private void opt3NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt3NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt3NActionPerformed

    private void opt1YActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt1YActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt1YActionPerformed

    private void comboGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboGenderActionPerformed

    private void JFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JFileChooserActionPerformed
      JFileChooser file=new JFileChooser();
        file.showOpenDialog(file);
        file.setCurrentDirectory(new File("user.dir"));
        FileNameExtensionFilter filter=new FileNameExtensionFilter("All Pic", "ong","jpg","jpeg","gif");
        file.showSaveDialog(null);

        int a =file.showSaveDialog(null);
       
             f =file.getSelectedFile();
            String p= f.getAbsolutePath();
            imagePath2.setText(p);
            imageName.setText(f.getName());
            proImage.setIcon(setIcon(p, null));
        
        
    }//GEN-LAST:event_JFileChooserActionPerformed

    public ImageIcon setIcon(String m,byte[] image){
        if(m!=null){
            myImage=new ImageIcon(m);
            
        }else{
            myImage=new ImageIcon(image);
        }
        
        Image img1=myImage.getImage();
        Image img2=img1.getScaledInstance(proImage.getWidth(), proImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon  i=new ImageIcon(img2);
        return i;
    }

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //update 
        String membershipNumber=txtMemeberNumber.getText();
        String firstName=txtFirstName.getText();
        String lastName=txtLastName.getText();
        String birthday=txtirthday.getText();
        String gender=comboGender.getSelectedItem().toString();
        String nic=txtNic.getText();
        String homeTel=txtTelephone.getText();
        String mobile=txtmobile.getText();
        String homeAddress=txtHomeAddrress.getText();
        String officeAdderss=txtOfficeaddress.getText();
        String emgName=txtEmgName.getText();
        String emgContact=txtEmgMobile.getText();
        String emgRelation=txtEmgRealtion.getText();
        Options options;
      //  String packageName=jComboBox3.getSelectedItem().toString();
        
        Member member=new Member();
        
        
            if(memberDao.getSingleMember(Long.parseLong(membershipNumber)).getId()!=null){
          
            member.setMembership_number(Long.parseLong(membershipNumber));
            member.setFirst_name(firstName);
            member.setLast_name(lastName);
            member.setBirthday(birthday);
            member.setGender(gender);
            member.setHome_telephone(homeTel);
            member.setMobile(mobile);
            member.setHome_address(homeAddress);
            member.setOffice_address(officeAdderss);
            member.setEmerg_name(emgName);
            member.setEmerg_contact(emgContact);
            member.setEmerg_relation(emgRelation);
            member.setNic(nic);
            
            try {
                if(f!=null){
                    member.setProImage(converImage(f));
                }else{
                    member.setProImage(null);
                }
                  
            } catch (Exception e) {
            }
          
            options=setOptionValuse(Long.parseLong(membershipNumber));
           boolean isSuccess=memberDao.updateMember(member, options);
           
           if(isSuccess==true){
                JOptionPane.showMessageDialog(null, "Member Updated");
                 //reset();
           }else{
                JOptionPane.showMessageDialog(null, "Member not updated . Try again !","Werning",JOptionPane.WARNING_MESSAGE);
           }
        }else{
                JOptionPane.showMessageDialog(null, "Member Nit Found ","Werning",JOptionPane.WARNING_MESSAGE);
            }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
        private Options setOptionValuse(Long memberId){
        Options options=new Options();
        options.setOpt1(buttonGroup1.getSelection().getActionCommand());
        options.setOpt2(buttonGroup2.getSelection().getActionCommand());
        options.setOpt3(buttonGroup3.getSelection().getActionCommand());
        options.setOpt4(buttonGroup4.getSelection().getActionCommand());
        options.setOpt5(buttonGroup5.getSelection().getActionCommand());
        options.setOpt6(buttonGroup6.getSelection().getActionCommand());
        options.setOpt7(buttonGroup7.getSelection().getActionCommand());
        options.setOpt8(buttonGroup8.getSelection().getActionCommand());
        options.setOpt9(buttonGroup9.getSelection().getActionCommand());
        options.setOpt10(buttonGroup10.getSelection().getActionCommand());
        options.setOpt11(buttonGroup11.getSelection().getActionCommand());
        options.setMember_Id(memberId);
        
        
        return options;
      
        
    }
    
    private byte[] converImage(File file) throws IOException{
         BufferedImage bImage = null ;
          String filePath = "src\\com\\intvaria\\image\\profile.png";
           byte [] data = null;
         if(file!=null){
             
             bImage = ImageIO.read(file);
              ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ImageIO.write(bImage, "jpg", bos );
       data = bos.toByteArray();
         }
     
      
      return data;
    } 
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //reset
        getMemeber();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Editmember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editmember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editmember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editmember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editmember().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JFileChooser;
    private javax.swing.JPanel body;
    private com.intvaria.swing.ButtonBadges btnCloseHeader;
    private com.intvaria.swing.ButtonBadges btnMinimize;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JComboBox<String> comboGender;
    private com.intvaria.component.Header header3;
    private javax.swing.JLabel imageName;
    private javax.swing.JLabel imagePath2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JRadioButton opt10N;
    private javax.swing.JRadioButton opt10Y;
    private javax.swing.JRadioButton opt11N;
    private javax.swing.JRadioButton opt11Y;
    private javax.swing.JRadioButton opt1N;
    private javax.swing.JRadioButton opt1Y;
    private javax.swing.JRadioButton opt2N;
    private javax.swing.JRadioButton opt2Y;
    private javax.swing.JRadioButton opt3N;
    private javax.swing.JRadioButton opt3Y;
    private javax.swing.JRadioButton opt4N;
    private javax.swing.JRadioButton opt4Y;
    private javax.swing.JRadioButton opt5N;
    private javax.swing.JRadioButton opt5Y;
    private javax.swing.JRadioButton opt6N;
    private javax.swing.JRadioButton opt6Y;
    private javax.swing.JRadioButton opt7N;
    private javax.swing.JRadioButton opt7Y;
    private javax.swing.JRadioButton opt8N;
    private javax.swing.JRadioButton opt8Y;
    private javax.swing.JRadioButton opt9N;
    private javax.swing.JRadioButton opt9Y;
    private com.intvaria.swing.ImageAvatar proImage;
    private com.intvaria.swing.RoundPanel roundPanel1;
    private com.intvaria.swing.RoundPanel roundPanel10;
    private com.intvaria.swing.RoundPanel roundPanel11;
    private com.intvaria.swing.RoundPanel roundPanel12;
    private com.intvaria.swing.RoundPanel roundPanel13;
    private com.intvaria.swing.RoundPanel roundPanel14;
    private com.intvaria.swing.RoundPanel roundPanel19;
    private com.intvaria.swing.RoundPanel roundPanel2;
    private com.intvaria.swing.RoundPanel roundPanel22;
    private com.intvaria.swing.RoundPanel roundPanel4;
    private com.intvaria.swing.RoundPanel roundPanel5;
    private com.intvaria.swing.RoundPanel roundPanel7;
    private com.intvaria.swing.RoundPanel roundPanel8;
    private com.intvaria.swing.RoundPanel roundPanel9;
    private javax.swing.JTextField txtEmgMobile;
    private javax.swing.JTextField txtEmgName;
    private javax.swing.JTextField txtEmgRealtion;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtHomeAddrress;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JLabel txtMemeberNumber;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtOfficeaddress;
    private javax.swing.JLabel txtPackageDates;
    private javax.swing.JLabel txtPackageName;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtirthday;
    private javax.swing.JTextField txtmobile;
    // End of variables declaration//GEN-END:variables
}
