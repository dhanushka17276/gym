package com.intvaria.main;

import com.intvaria.DAO.StockDAO;
import com.intvaria.connections.DBConnection;
import com.intvaria.entity.Category;
import com.intvaria.entity.Item;
import com.intvaria.entity.Stock;
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
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Edititem extends javax.swing.JFrame {

    int selectedItemId;
    StockDAO stockDao=new StockDAO();
    Item item;
    
    byte[] image;
    String imagePath="";
    ImageIcon myImage;
    File f;
    
    public Edititem(int itemId) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        selectedItemId=itemId;
        setCategory();
         setSingleItem();
    }
    
     public Edititem() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));

    }

      public void setCategory(){
              Vector comboBoxItems=new Vector();
        List<Category> catList=stockDao.getAllCategories();
        
        if(catList.size()>0){
          //  comboBoxItems.add("Select Package");
            for(int i=0 ; i< catList.size() ; i++){
                comboBoxItems.add(catList.get(i).getName());
            }
             final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
             combCategory.setModel(model);
        }
        }
      
      private void setSingleItem(){
         item=stockDao.getItemById(selectedItemId);
       // Stock stock=stockDAO.getStockByUserIdAndItemId(selectedUserId,selectedItemId,DBConnection.connect());
        if(item.getName()!=null){
            txtName.setText(item.getName());
            txtPrice.setText(String.valueOf(item.getPrice()));
            txtDescription.setText(item.getDescription());
            combCategory.setSelectedItem(item.getCategory());
            if(item.isStatus()==true){
                combStaus.setSelectedIndex(0);
                
            }else{
                 combStaus.setSelectedIndex(1);
            }
          
             try {
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(item.getImage()));
                    proImage.setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                    Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        combCategory = new javax.swing.JComboBox<String>();
        roundPanel5 = new com.intvaria.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        roundPanel19 = new com.intvaria.swing.RoundPanel();
        txtPrice = new javax.swing.JTextField();
        roundPanel4 = new com.intvaria.swing.RoundPanel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        combStaus = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        roundPanel10 = new com.intvaria.swing.RoundPanel();
        jTextField9 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnCloseHeader4 = new com.intvaria.swing.ButtonBadges();
        btnMinimize4 = new com.intvaria.swing.ButtonBadges();

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

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Edit Item");

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

        combCategory.setBackground(new java.awt.Color(102, 102, 102));
        combCategory.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        combCategory.setForeground(new java.awt.Color(255, 255, 255));
        combCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "In stock", "Out of Stock", " " }));
        combCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combCategoryActionPerformed(evt);
            }
        });

        roundPanel5.setBackground(new java.awt.Color(25, 25, 25));

        txtDescription.setBackground(new java.awt.Color(25, 25, 25));
        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(255, 255, 255));
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(224, 224, 224));
        jLabel6.setText("Description");

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(224, 224, 224));
        jLabel17.setText("Price");

        roundPanel19.setBackground(new java.awt.Color(25, 25, 25));

        txtPrice.setBackground(new java.awt.Color(25, 25, 25));
        txtPrice.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(255, 255, 255));
        txtPrice.setBorder(null);

        javax.swing.GroupLayout roundPanel19Layout = new javax.swing.GroupLayout(roundPanel19);
        roundPanel19.setLayout(roundPanel19Layout);
        roundPanel19Layout.setHorizontalGroup(
            roundPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPrice)
                .addContainerGap())
        );
        roundPanel19Layout.setVerticalGroup(
            roundPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        roundPanel4.setBackground(new java.awt.Color(25, 25, 25));

        txtName.setBackground(new java.awt.Color(25, 25, 25));
        txtName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setBorder(null);

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(224, 224, 224));
        jLabel4.setText("Item Name");

        combStaus.setBackground(new java.awt.Color(102, 102, 102));
        combStaus.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        combStaus.setForeground(new java.awt.Color(255, 255, 255));
        combStaus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Not available" }));
        combStaus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combStausActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(224, 224, 224));
        jLabel5.setText("Category");

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

        jLabel33.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(224, 224, 224));
        jLabel33.setText("Status");

        jLabel2.setText("jLabel2");

        jButton2.setBackground(new java.awt.Color(0, 204, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(roundPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(377, 377, 377))
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(595, 595, 595)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(header3, javax.swing.GroupLayout.PREFERRED_SIZE, 1325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(502, 502, 502)
                        .addComponent(proImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imageName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imagePath2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(109, 109, 109)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel33)
                            .addComponent(jLabel17)
                            .addComponent(jLabel5)
                            .addComponent(roundPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combCategory, 0, 453, Short.MAX_VALUE)
                            .addComponent(combStaus, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(582, 582, 582)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(header3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(imageName)
                        .addGap(15, 15, 15)
                        .addComponent(imagePath2)
                        .addGap(16, 16, 16)
                        .addComponent(JFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(13, 13, 13)
                        .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(13, 13, 13)
                        .addComponent(roundPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(combCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jLabel33)
                        .addGap(31, 31, 31)
                        .addComponent(combStaus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(806, 806, 806)
                .addComponent(jLabel12)
                .addGap(22, 22, 22)
                .addComponent(roundPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(753, 753, 753))
        );

        jScrollPane2.setViewportView(roundPanel2);

        body.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        btnCloseHeader4.setBackground(new java.awt.Color(25, 25, 25));
        btnCloseHeader4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/intvaria/icon/close.png"))); // NOI18N
        btnCloseHeader4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseHeader4ActionPerformed(evt);
            }
        });

        btnMinimize4.setBackground(new java.awt.Color(25, 25, 25));
        btnMinimize4.setForeground(new java.awt.Color(247, 58, 58));
        btnMinimize4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/intvaria/icon/minimize-window-20.png"))); // NOI18N
        btnMinimize4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimize4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimize4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnCloseHeader4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMinimize4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnCloseHeader4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1380, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1019, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
    
     private void updateItem(){
         String name=txtName.getText();
         String description=txtDescription.getText();
         Double price=Double.parseDouble(txtPrice.getText());
         String categoty=combCategory.getSelectedItem().toString();
         boolean status;
         
         if(combStaus.getSelectedIndex()==0){
             status=true;
         }else{
             status=false;
         }
         
         Item item=new Item();
         
         if(name.length()!=0 && txtPrice.getText().length()!=0){
             item.setName(name);
             item.setPrice(price);
             item.setId(selectedItemId);
             item.setDescription(description);
             item.setStatus(status);
             item.setCategory(categoty);
             try {
              item.setImage(converImage(f));
          } catch (IOException ex) {
              Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, ex);
          }
             
            boolean isSaved=stockDao.updateItem(item);
             
             if(isSaved==true){
                 JOptionPane.showMessageDialog(null, "Item update successfully");
             }else{
                  JOptionPane.showMessageDialog(null, "Item not updated. Try agin!" ,"Warning" , JOptionPane.WARNING_MESSAGE);
             }
         }else{
             JOptionPane.showMessageDialog(null, "Item name and price can't be empty !" ,"Warning" , JOptionPane.WARNING_MESSAGE);
         }
     }
     
      private byte[] converImage(File file) throws IOException{
         BufferedImage bImage ;
          String filePath = "src\\com\\intvaria\\image\\profile.png";
         if(file==null){
             bImage = ImageIO.read(new File(filePath));
         }else{
             bImage = ImageIO.read(file);
         }
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ImageIO.write(bImage, "jpg", bos );
      byte [] data = bos.toByteArray();
      
      return data;
    } 
     
    private void combCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combCategoryActionPerformed

    private void combStausActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combStausActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combStausActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // update 
        updateItem();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnCloseHeader4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseHeader4ActionPerformed
        // showMessageDialog(null, "This is even shorter");
        this.dispose();
    }//GEN-LAST:event_btnCloseHeader4ActionPerformed

    private void btnMinimize4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimize4ActionPerformed

        this.setExtendedState(JFrame.ICONIFIED);// One way
    }//GEN-LAST:event_btnMinimize4ActionPerformed

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
            java.util.logging.Logger.getLogger(Edititem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edititem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edititem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edititem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edititem(13).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JFileChooser;
    private javax.swing.JPanel body;
    private com.intvaria.swing.ButtonBadges btnCloseHeader4;
    private com.intvaria.swing.ButtonBadges btnMinimize4;
    private javax.swing.JComboBox<String> combCategory;
    private javax.swing.JComboBox<String> combStaus;
    private com.intvaria.component.Header header3;
    private javax.swing.JLabel imageName;
    private javax.swing.JLabel imagePath2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField9;
    private com.intvaria.swing.ImageAvatar proImage;
    private com.intvaria.swing.RoundPanel roundPanel1;
    private com.intvaria.swing.RoundPanel roundPanel10;
    private com.intvaria.swing.RoundPanel roundPanel19;
    private com.intvaria.swing.RoundPanel roundPanel2;
    private com.intvaria.swing.RoundPanel roundPanel4;
    private com.intvaria.swing.RoundPanel roundPanel5;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
