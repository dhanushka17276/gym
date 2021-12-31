package com.intvaria.component;

import com.intvaria.DAO.UserDAO;
import com.intvaria.entity.User;
import com.intvaria.event.EventMenu;
import com.intvaria.swing.ButtonMenu;
import com.intvaria.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

    private EventMenu event;
    UserDAO userDao=new UserDAO();

    public Menu() {
        initComponents();
        setOpaque(false);
        ScrollBarCustom sb = new ScrollBarCustom();
        sb.setForeground(new Color(130, 130, 130, 100));
        jScrollPane1.setVerticalScrollBar(sb);
        panelMenu.setLayout(new MigLayout("wrap, fillx, inset 3", "[fill]", "[]0[]"));
        setLoggedUserDetails();
    }

    public void initMenu(EventMenu event) {
        this.event = event;
        addMenu(new ImageIcon(getClass().getResource("/com/intvaria/icon/1.png")), "Dashboard", 0);
        addMenu(new ImageIcon(getClass().getResource("/com/intvaria/icon/2.png")), "New Member", 1);
        addMenu(new ImageIcon(getClass().getResource("/com/intvaria/icon/3.png")), "New User", 2);
        addMenu(new ImageIcon(getClass().getResource("/com/intvaria/icon/a.png")), "All Members", 3);
        addMenu(new ImageIcon(getClass().getResource("/com/intvaria/icon/b.png")), "All Users", 4);
        addMenu(new ImageIcon(getClass().getResource("/com/intvaria/icon/c.png")), "Package Details", 5);
        addMenu(new ImageIcon(getClass().getResource("/com/intvaria/icon/d.png")), "Item Stock", 6);
        addMenu(new ImageIcon(getClass().getResource("/com/intvaria/icon/e.png")), "Sales", 7);
        addMenu(new ImageIcon(getClass().getResource("/com/intvaria/icon/f.png")), "Attendance", 9);
        addMenu(new ImageIcon(getClass().getResource("/com/intvaria/icon/4.png")), "Cards", 10);

        addEmpty();
        addMenu(new ImageIcon(getClass().getResource("/com/intvaria/icon/logout.png")), "Logout", 8);
    }

    private void setLoggedUserDetails(){
        User user=userDao.getLoggedUserDetails();
        txtUserName.setText(user.getFirstName() + " "+user.getLastName());
        txtUserType.setText(user.getUserType());
    }
    
    private void addEmpty() {
        panelMenu.add(new JLabel(), "push");
    }

    private void addMenu(Icon icon, String text, int index) {
        ButtonMenu menu = new ButtonMenu();
        menu.setIcon(icon);
        menu.setText("  " + text);
        panelMenu.add(menu);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.selected(index);
                setSelected(menu);
            }
        });
    }

    private void setSelected(ButtonMenu menu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof ButtonMenu) {
                ButtonMenu b = (ButtonMenu) com;
                b.setSelected(false);
            }
        }
        menu.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.intvaria.swing.RoundPanel();
        imageAvatar1 = new com.intvaria.swing.ImageAvatar();
        txtUserName = new javax.swing.JLabel();
        txtUserType = new javax.swing.JLabel();
        roundPanel2 = new com.intvaria.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        imageAvatar1.setForeground(new java.awt.Color(231, 231, 231));
        imageAvatar1.setBorderSize(2);
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/intvaria/image/profile.png"))); // NOI18N

        txtUserName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(224, 224, 224));
        txtUserName.setText("User Name");

        txtUserType.setForeground(new java.awt.Color(203, 203, 203));
        txtUserType.setText("type");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName)
                    .addComponent(txtUserType))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtUserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserType))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelMenu.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelMenu);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.intvaria.swing.ImageAvatar imageAvatar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMenu;
    private com.intvaria.swing.RoundPanel roundPanel1;
    private com.intvaria.swing.RoundPanel roundPanel2;
    private javax.swing.JLabel txtUserName;
    private javax.swing.JLabel txtUserType;
    // End of variables declaration//GEN-END:variables
}
