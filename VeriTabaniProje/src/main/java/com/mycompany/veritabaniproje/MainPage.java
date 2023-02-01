/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.veritabaniproje;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author erkan
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    DefaultTableModel myModel;
    public MainPage() {
        initComponents();
        init();
    }
    
    public void refreshTable(){
         String tc = VeriTabaniProje.customer.getTcno();
         String sqlquery = "select* from emlaklar where emlaklar.tapuno in (select tapuno from sahiplik where tcno='"+tc+"')";
        ResultSet rs = DBConnection.list(sqlquery);
        Object[] columns = {"Tapu No","İl","İlçe","Mahalle","Fiyat","Satılık"};
        Object[] rows = new Object[6];
        
        myModel.setColumnCount(0);
        myModel.setRowCount(0);
        myModel.setColumnIdentifiers(columns);
        
        try {
            while(rs.next()){
                rows[0]=rs.getString("tapuno");
                rows[1]=rs.getString("il");
                rows[2]=rs.getString("ilçe");
                rows[3]=rs.getString("mahalle");
                rows[4]=rs.getString("fiyat");
                rows[5]=rs.getString("satılık");
                myModel.addRow(rows);
                        
                        
            }
             jTable1.setModel(myModel);
        } catch (SQLException e) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, e);

        }
    }
    
    public void init(){
        myModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            } 
        };
        String tc = VeriTabaniProje.customer.getTcno();
       // String sqlquery = "select* from arsalar where arsalar.tapuno in (select tapuno from sahiplik where tcno='"+tc+"')";
        String sqlquery = "create or replace view emlaklar as "
                + "select * "
                + "from arsalar "
                + "where arsalar.tapuno in "
                + "(select tapuno "
                + "from sahiplik "
                + "where tcno='"+tc+"')";
         String selectquery = "select * from emlaklar";
        
         try {
            PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(sqlquery);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
             Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, e);
        }
         
        
       
        
        
        Object[] columns = {"Tapu No","İl","İlçe","Mahalle","Fiyat","Satılık"};
        Object[] rows = new Object[6];
        
        myModel.setColumnCount(0);
        myModel.setRowCount(0);
        myModel.setColumnIdentifiers(columns);
        
        ResultSet rs = DBConnection.list(selectquery);
        
        try {
            while(rs.next()){
                rows[0]=rs.getString("tapuno");
                rows[1]=rs.getString("il");
                rows[2]=rs.getString("ilçe");
                rows[3]=rs.getString("mahalle");
                rows[4]=rs.getString("fiyat");
                rows[5]=rs.getString("satılık");
                myModel.addRow(rows);
                        
                        
            }
             jTable1.setModel(myModel);
        } catch (SQLException e) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, e);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonArsaBagisla = new javax.swing.JButton();
        jButtonFiyatDuzenle = new javax.swing.JButton();
        jButtonArsaSatinAl = new javax.swing.JButton();
        jButtonCikis = new javax.swing.JButton();
        jButtonArsaEkle = new javax.swing.JButton();
        jButtonSatis = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("ARSALARIM");

        jButtonArsaBagisla.setText("Arsa Bağışla");
        jButtonArsaBagisla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArsaBagislaActionPerformed(evt);
            }
        });

        jButtonFiyatDuzenle.setText("<html>Arsa Fiyatını Düzenle</html>");
        jButtonFiyatDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiyatDuzenleActionPerformed(evt);
            }
        });

        jButtonArsaSatinAl.setText("Arsa Satın Al");
        jButtonArsaSatinAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArsaSatinAlActionPerformed(evt);
            }
        });

        jButtonCikis.setText("Çıkış");
        jButtonCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCikisActionPerformed(evt);
            }
        });

        jButtonArsaEkle.setText("Arsa Ekle");
        jButtonArsaEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArsaEkleActionPerformed(evt);
            }
        });

        jButtonSatis.setText("<html>Satışa Çıkar / Satıştan Kaldır</html>");
        jButtonSatis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSatisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSatis, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButtonFiyatDuzenle, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jButtonArsaBagisla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonArsaSatinAl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonArsaEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCikis)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButtonArsaEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonArsaSatinAl, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonArsaBagisla, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButtonFiyatDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jButtonSatis, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCikis)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonArsaSatinAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArsaSatinAlActionPerformed
        // TODO add your handling code here:
        BuyingPage buyingPage = new BuyingPage();
        buyingPage.setVisible(true);
        buyingPage.pack();
        buyingPage.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButtonArsaSatinAlActionPerformed

    private void jButtonArsaBagislaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArsaBagislaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(null, "Lütfen bir arsa seçiniz");

        }else{
            String TC = JOptionPane.showInputDialog(null, "Bağış yapmak istediğiniz kişinin TC Kimlik Numarası:");
            if(TC != null){
                if(DBConnection.checkUserWithTc(TC)){
                Object tapuNo = model.getValueAt(selectedRow, 0);
                tapuNo = (String) tapuNo;
                
                String sql = "update arsalar set satılık = -1 where tapuno = '"+tapuNo+"'";
                String query = "update sahiplik set tcno = '"+TC+"' where tapuno = '"+tapuNo+"'";
                try {
                    
                    DBConnection.insertIslem(tapuNo.toString(), TC, VeriTabaniProje.customer.getTcno(), "bağış", 0, "bağış");
            
                    PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(query);
                    preparedStatement.executeUpdate();
                    
                    
                    PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
                    preparedStatement.executeUpdate();
                
                } catch (SQLException e) {
                    Logger.getLogger(BuyingPage.class.getName()).log(Level.SEVERE,null,e);
                    JOptionPane.showMessageDialog(null, e);

                }
                refreshTable();
            }else{
                JOptionPane.showMessageDialog(null, "Kayıtlı kullanıcı bulunmamaktadır!");
            }
                
            }
            
            
            
        }
    }//GEN-LAST:event_jButtonArsaBagislaActionPerformed

    private void jButtonFiyatDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiyatDuzenleActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Lütfen bir arsa seçiniz");
        } else {
            Object tapuno = model.getValueAt(selectedRow, 0);
            tapuno = (String) tapuno;
            String fiyat = JOptionPane.showInputDialog(null, "Yeni Fiyat: ");
            String query = "update arsalar set fiyat = '"+fiyat+"' where tapuno='"+tapuno+"' ";
            if(fiyat != null){
                try {
                    PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(query);
                    preparedStatement.executeUpdate();
                
                
                } catch (Exception e) {
                    Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,e);
                    JOptionPane.showMessageDialog(null, e);

                }
                refreshTable();
            }
             
        }
    }//GEN-LAST:event_jButtonFiyatDuzenleActionPerformed

    private void jButtonCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCikisActionPerformed
        // TODO add your handling code here:
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        loginPage.pack();
        loginPage.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButtonCikisActionPerformed

    private void jButtonArsaEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArsaEkleActionPerformed
        // TODO add your handling code here:
        ArsaEklePage arsaEklePage = new ArsaEklePage();
        arsaEklePage.setVisible(true);
        arsaEklePage.pack();
        arsaEklePage.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButtonArsaEkleActionPerformed

    private void jButtonSatisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSatisActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Lütfen bir arsa seçiniz");
        } else {
            Object tapuno = model.getValueAt(selectedRow, 0);
            tapuno = (String) tapuno;
            String satılık = model.getValueAt(selectedRow, 5).toString();
            
            Integer satılık2 = Integer.parseInt(satılık);
            if(satılık2 == 1){
                int result = JOptionPane.showConfirmDialog(null,"<html>Satıştan Kaldırılacaktır Onaylıyor Musunuz?</html>","Onay",JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    String sql = "update arsalar set satılık = -1 where tapuno = '"+tapuno+"'";
                    try {
                        PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(sql);
                        preparedStatement.execute();
                        JOptionPane.showMessageDialog(null, "Arsa Satıştan Kaldırılmıştır!");
                    } catch (SQLException e) {
                        Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,e);
                    }
                }
                
            }else if (satılık2 == -1) {
                int result = JOptionPane.showConfirmDialog(null,"<html>Satışa Çıkarılacaktır Onaylıyor Musunuz?</html>","Onay",JOptionPane.YES_NO_OPTION);
                   if (result == JOptionPane.YES_OPTION) {
                       String sql = "update arsalar set satılık = 1 where tapuno = '"+tapuno+"'";
                       try {
                        PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(sql);
                        preparedStatement.execute();
                        JOptionPane.showMessageDialog(null, "Arsa Satışa Çıkarılmıştır!");
                    } catch (SQLException e) {
                        Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,e);
                    }
                    
                }
                   
                
                
            }
            refreshTable();
        }
    }//GEN-LAST:event_jButtonSatisActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonArsaBagisla;
    private javax.swing.JButton jButtonArsaEkle;
    private javax.swing.JButton jButtonArsaSatinAl;
    private javax.swing.JButton jButtonCikis;
    private javax.swing.JButton jButtonFiyatDuzenle;
    private javax.swing.JButton jButtonSatis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
