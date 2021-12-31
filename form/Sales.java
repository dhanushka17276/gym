/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intvaria.form;

import com.intvaria.DAO.SaleDAO;
import com.intvaria.DAO.UserDAO;
import com.intvaria.entity.Member;
import com.intvaria.entity.Sale;
import com.intvaria.entity.User;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dhanushka
 */
public class Sales extends javax.swing.JPanel {

    UserDAO userDao=new UserDAO();
    SaleDAO saleDao=new SaleDAO();
    public Sales() {
        initComponents();
        setOpaque(false);
        setUser();
        getNotCheckedSales();
    }
    
    
     public void setUser(){
              Vector comboBoxItems=new Vector();
        List<User> userList=userDao.getAllUsers();
        User user=userDao.getLoggedUserDetails();
         if(!user.getUserType().equals("coach")){
         
        
        if(userList.size()>0){
            comboBoxItems.add("All");
          //  comboBoxItems.add("Select Package");
            for(int i=0 ; i< userList.size() ; i++){
                if(!userList.get(i).getUserType().equals("admin")){
                   
                    comboBoxItems.add(userList.get(i).getFirstName() + " " +userList.get(i).getLastName() );
                }
               
            }
            
        }
         }else{
             comboBoxItems.add(user.getFirstName()+" "+user.getLastName());
         }
    
         final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
             combStock.setModel(model);
        }

     
     private void getNotCheckedSales(){
         DefaultTableModel dm = (DefaultTableModel)jTable1.getModel();
     dm.getDataVector().removeAllElements();
       dm.fireTableDataChanged();
         ArrayList<Sale> saleList=(ArrayList<Sale>) saleDao.getAllNotCheckedSales();
        String date,item,qty,price,discount,total;
        double totalValue=0, totalPrice=0,totalDesc=0,all=0;
        int totalqty=0;
        boolean isvalid;
        String validity;
        if(saleList.size()>0){
            for(int i=0;i < saleList.size();i++){
               
                date=String.valueOf(saleList.get(i).getDate());
                item=saleList.get(i).getItem().getName();
                qty=String.valueOf(saleList.get(i).getQty());
               price=String.valueOf(saleList.get(i).getPrice());
               discount=String.valueOf(saleList.get(i).getDiscount());
               totalValue=saleList.get(i).getPrice()-saleList.get(i).getDiscount();
               total=String.valueOf(totalValue);
               totalPrice=totalPrice+saleList.get(i).getPrice();
               all=all+totalValue;
               totalqty=totalqty+saleList.get(i).getQty();
               totalDesc=totalDesc+saleList.get(i).getDiscount();
               isvalid=saleList.get(i).isStatus();
               
               if(isvalid==true){
                   validity="Checked";
                   
               }else{
                   validity="Not Checked";
               }
               
                
                String toData[]={date,item,validity,qty,price,discount,total};
                DefaultTableModel tbMdel=(DefaultTableModel) jTable1.getModel();
                
                tbMdel.addRow(toData);
                
               
            }
            
            totalQty.setText(String.valueOf(totalqty));
            this.totalPrice.setText(String.valueOf(totalPrice));
            totalDes.setText(String.valueOf(totalDesc));
            this.total.setText(String.valueOf(all));
                    
        }
         
     }
     
     private void searchSales(){
         int stock=combStock.getSelectedIndex();
         int status=combStatus.getSelectedIndex();
          DefaultTableModel dm = (DefaultTableModel)jTable1.getModel();
     dm.getDataVector().removeAllElements();
       dm.fireTableDataChanged();
          ArrayList<Sale> saleList=(ArrayList<Sale>) saleDao.searchSales(stock, status);
        String date,item,qty,price,discount,total;
        double totalValue=0, totalPrice=0,totalDesc=0,all=0;
        int totalqty=0;
        boolean isvalid;
        String validity;
        if(saleList.size()>0){
            for(int i=0;i < saleList.size();i++){
               
                date=String.valueOf(saleList.get(i).getDate());
                item=saleList.get(i).getItem().getName();
                qty=String.valueOf(saleList.get(i).getQty());
               price=String.valueOf(saleList.get(i).getPrice());
               discount=String.valueOf(saleList.get(i).getDiscount());
               totalValue=saleList.get(i).getPrice()-saleList.get(i).getDiscount();
               total=String.valueOf(totalValue);
               totalPrice=totalPrice+saleList.get(i).getPrice();
               all=all+totalPrice;
               totalqty=totalqty+saleList.get(i).getQty();
               totalDesc=totalDesc+saleList.get(i).getDiscount();
               isvalid=saleList.get(i).isStatus();
               
               if(isvalid==true){
                   validity="Checked";
                   
               }else{
                   validity="Not Checked";
               }
               
                
                String toData[]={date,item,validity,qty,price,discount,total};
                DefaultTableModel tbMdel=(DefaultTableModel) jTable1.getModel();
                
                tbMdel.addRow(toData);
                
               
            }
            
            totalQty.setText(String.valueOf(totalqty));
            this.totalPrice.setText(String.valueOf(totalPrice));
            totalDes.setText(String.valueOf(totalDesc));
            this.total.setText(String.valueOf(all));
             int selectedIndex=combStatus.getSelectedIndex();
        
        if(selectedIndex==0){
           jButton2.setEnabled(true);
        }else{
            jButton2.setEnabled(false);
        }
     }
     }
     
    
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.intvaria.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        combStatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combStock = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        totalQty = new javax.swing.JLabel();
        totalPrice = new javax.swing.JLabel();
        totalDes = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1148, 1850));
        setRequestFocusEnabled(false);

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setPreferredSize(new java.awt.Dimension(1148, 1850));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Sale Summery");

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date ", "Item", "Status", "Quantity", "Price", "Discount", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jTable1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable1InputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(150);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(2).setMinWidth(120);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(3).setMinWidth(70);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(4).setMinWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(5).setMinWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(6).setMinWidth(100);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        combStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Cheked", "Checked", "All" }));
        combStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combStatusActionPerformed(evt);
            }
        });
        combStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combStatusKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Stock");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Status ");

        combStock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        combStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combStockActionPerformed(evt);
            }
        });
        combStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combStockKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Totals");

        totalQty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalQty.setText("qty");

        totalPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalPrice.setText("price");

        totalDes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalDes.setText("toalDes");

        total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total.setText("total");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalQty, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalDes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(totalQty)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(totalPrice)))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(totalDes)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator2))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(total)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Mark As Checked");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combStock, 0, 391, Short.MAX_VALUE))
                                .addGap(100, 100, 100)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(combStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67))))))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(435, 435, 435)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combStock, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // search
       searchSales();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
     
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1InputMethodTextChanged

    }//GEN-LAST:event_jTable1InputMethodTextChanged

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
      
    }//GEN-LAST:event_jTable1PropertyChange

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // update qty

      

    }//GEN-LAST:event_jTable1KeyPressed

    private void combStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combStatusActionPerformed
       
    }//GEN-LAST:event_combStatusActionPerformed

    private void combStatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combStatusKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            searchSales();
        }
    }//GEN-LAST:event_combStatusKeyPressed

    private void combStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combStockActionPerformed

    private void combStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combStockKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            searchSales();
        }
    }//GEN-LAST:event_combStockKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // update sale
        
        boolean isSuccess=false;
    int x=    JOptionPane.showConfirmDialog(null, "Do you want to mark as checked ?");
    if(x==JOptionPane.YES_OPTION){
        isSuccess=saleDao.updateStatus();
    }
    
    if(isSuccess==true){
        JOptionPane.showMessageDialog(null, "Successfully marked");
        getNotCheckedSales();
        combStatus.setSelectedIndex(0);
        combStock.setSelectedIndex(0);
         jButton2.setEnabled(true);
         
    }else{
         JOptionPane.showMessageDialog(null, "Marke failed . Try agin!");
    }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combStatus;
    private javax.swing.JComboBox<String> combStock;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private com.intvaria.swing.RoundPanel roundPanel1;
    private javax.swing.JLabel total;
    private javax.swing.JLabel totalDes;
    private javax.swing.JLabel totalPrice;
    private javax.swing.JLabel totalQty;
    // End of variables declaration//GEN-END:variables
}
