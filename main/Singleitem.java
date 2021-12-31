package com.intvaria.main;

import com.intvaria.DAO.SaleDAO;
import com.intvaria.DAO.StockDAO;
import com.intvaria.connections.DBConnection;
import com.intvaria.entity.Item;
import com.intvaria.entity.Sale;
import com.intvaria.entity.Stock;
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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Singleitem extends javax.swing.JFrame {

    int selectedItemId;
    Long selectedUserId;
    StockDAO stockDAO=new StockDAO();
    Item item=null;
    SaleDAO saelDao=new SaleDAO();
    
    public Singleitem(int itemId,Long userId) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        selectedItemId=itemId;
        selectedUserId=userId;
        txtDiscount.setText("0");
        setSingleItem();
    }
    
   public Singleitem() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));

    }
    
    
    private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.revalidate();
        body.repaint();
    }
    
    private void setSingleItem(){
         item=stockDAO.getItemById(selectedItemId);
        Stock stock=stockDAO.getStockByUserIdAndItemId(selectedUserId,selectedItemId,DBConnection.connect());
        if(item.getName()!=null){
            txtItemName.setText(item.getName());
            txtItemPrice.setText("Rs: "+item.getPrice());
            txtItemDescription.setText(item.getDescription());
            txtItemQuantity.setText(String.valueOf(stock.getQty()));
             try {
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(item.getImage()));
                    proImage.setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                    Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.intvaria.swing.RoundPanel();
        body = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        roundPanel2 = new com.intvaria.swing.RoundPanel();
        header3 = new com.intvaria.component.Header();
        jLabel12 = new javax.swing.JLabel();
        roundPanel10 = new com.intvaria.swing.RoundPanel();
        jTextField9 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        proImage = new com.intvaria.swing.ImageAvatar();
        jLabel4 = new javax.swing.JLabel();
        txtItemName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtItemPrice = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtItemDescription = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtItemQuantity = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        roundPanel19 = new com.intvaria.swing.RoundPanel();
        txtQty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        roundPanel20 = new com.intvaria.swing.RoundPanel();
        txtDiscount = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnCloseHeader2 = new com.intvaria.swing.ButtonBadges();
        btnMinimize2 = new com.intvaria.swing.ButtonBadges();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        roundPanel1.setBackground(new java.awt.Color(25, 25, 25));

        body.setBackground(new java.awt.Color(51, 51, 51));
        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

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

        jLabel2.setText("jLabel2");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        proImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/intvaria/image/profile.png"))); // NOI18N
        proImage.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(224, 224, 224));
        jLabel4.setText("Item Name :");

        txtItemName.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtItemName.setForeground(new java.awt.Color(224, 224, 224));
        txtItemName.setText("Item Name1");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(224, 224, 224));
        jLabel5.setText("Price :");

        txtItemPrice.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtItemPrice.setForeground(new java.awt.Color(224, 224, 224));
        txtItemPrice.setText("rs.100");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(224, 224, 224));
        jLabel9.setText("Description");

        txtItemDescription.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtItemDescription.setForeground(new java.awt.Color(224, 224, 224));
        txtItemDescription.setText("Des");

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(224, 224, 224));
        jLabel11.setText("Available Quantity");

        txtItemQuantity.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtItemQuantity.setForeground(new java.awt.Color(224, 224, 224));
        txtItemQuantity.setText("10");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtItemName, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(txtItemPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtItemDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtItemQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(proImage, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(proImage, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtItemName))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtItemPrice))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtItemDescription))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtItemQuantity))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        jLabel1.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Make A Sale");

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Sale");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        roundPanel19.setBackground(new java.awt.Color(204, 204, 204));

        txtQty.setBackground(new java.awt.Color(204, 204, 204));
        txtQty.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        txtQty.setBorder(null);

        javax.swing.GroupLayout roundPanel19Layout = new javax.swing.GroupLayout(roundPanel19);
        roundPanel19.setLayout(roundPanel19Layout);
        roundPanel19Layout.setHorizontalGroup(
            roundPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtQty, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel19Layout.setVerticalGroup(
            roundPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtQty, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(224, 224, 224));
        jLabel7.setText("Qty");

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(224, 224, 224));
        jLabel14.setText("Discount %");

        roundPanel20.setBackground(new java.awt.Color(204, 204, 204));

        txtDiscount.setBackground(new java.awt.Color(204, 204, 204));
        txtDiscount.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        txtDiscount.setBorder(null);

        javax.swing.GroupLayout roundPanel20Layout = new javax.swing.GroupLayout(roundPanel20);
        roundPanel20.setLayout(roundPanel20Layout);
        roundPanel20Layout.setHorizontalGroup(
            roundPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel20Layout.setVerticalGroup(
            roundPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(roundPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(27, 27, 27)
                        .addComponent(roundPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

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
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(376, 376, 376)
                .addComponent(jLabel2)
                .addGap(560, 560, 560)
                .addComponent(header3, javax.swing.GroupLayout.PREFERRED_SIZE, 1325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(header3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 691, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(22, 22, 22)
                .addComponent(roundPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(753, 753, 753))
        );

        jScrollPane2.setViewportView(roundPanel2);

        body.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        btnCloseHeader2.setBackground(new java.awt.Color(25, 25, 25));
        btnCloseHeader2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/intvaria/icon/close.png"))); // NOI18N
        btnCloseHeader2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseHeader2ActionPerformed(evt);
            }
        });

        btnMinimize2.setBackground(new java.awt.Color(25, 25, 25));
        btnMinimize2.setForeground(new java.awt.Color(247, 58, 58));
        btnMinimize2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/intvaria/icon/minimize-window-20.png"))); // NOI18N
        btnMinimize2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimize2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(1271, Short.MAX_VALUE)
                .addComponent(btnMinimize2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnCloseHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMinimize2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnCloseHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnCloseHeader2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseHeader2ActionPerformed
        // showMessageDialog(null, "This is even shorter");
        this.dispose();
    }//GEN-LAST:event_btnCloseHeader2ActionPerformed

    private void btnMinimize2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimize2ActionPerformed

        this.setExtendedState(JFrame.ICONIFIED);// One way

    }//GEN-LAST:event_btnMinimize2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // save
        
        String qty=txtQty.getText();
        String descount=txtDiscount.getText();
        int stock=Integer.parseInt(txtItemQuantity.getText());
        Sale sale=new Sale();
        
        if(qty.length()!=0){
            if(Integer.parseInt(qty)<=stock){
                sale.setItem_id(selectedItemId);
                sale.setUser_id(selectedUserId);
                sale.setPrice(item.getPrice());
                sale.setQty(Integer.parseInt(qty));
                sale.setDiscount(Double.parseDouble(descount));
                boolean isSaved;
                try {
                    isSaved = saelDao.saveSale(sale);
                    if(isSaved==true){
                      JOptionPane.showMessageDialog(null, "Sale Completed");
                      txtItemQuantity.setText(String.valueOf(stock - Integer.parseInt(qty)));
                      txtQty.setText("");
                      txtDiscount.setText("0");
                       }else{
                        JOptionPane.showMessageDialog(null, "Sale Not Completed. Try agin!" , "Warning",JOptionPane.WARNING_MESSAGE);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(Singleitem.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Quantity!" , "Warning",JOptionPane.WARNING_MESSAGE); 
            }
        }else{
             JOptionPane.showMessageDialog(null, "Please Add Quantity!" , "Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Singleitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Singleitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Singleitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Singleitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Singleitem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private com.intvaria.swing.ButtonBadges btnCloseHeader;
    private com.intvaria.swing.ButtonBadges btnCloseHeader1;
    private com.intvaria.swing.ButtonBadges btnCloseHeader2;
    private com.intvaria.swing.ButtonBadges btnMinimize;
    private com.intvaria.swing.ButtonBadges btnMinimize1;
    private com.intvaria.swing.ButtonBadges btnMinimize2;
    private com.intvaria.component.Header header3;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField9;
    private com.intvaria.swing.ImageAvatar proImage;
    private com.intvaria.swing.RoundPanel roundPanel1;
    private com.intvaria.swing.RoundPanel roundPanel10;
    private com.intvaria.swing.RoundPanel roundPanel19;
    private com.intvaria.swing.RoundPanel roundPanel2;
    private com.intvaria.swing.RoundPanel roundPanel20;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JLabel txtItemDescription;
    private javax.swing.JLabel txtItemName;
    private javax.swing.JLabel txtItemPrice;
    private javax.swing.JLabel txtItemQuantity;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables
}
