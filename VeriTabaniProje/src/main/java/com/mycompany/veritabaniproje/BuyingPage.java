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
public class BuyingPage extends javax.swing.JFrame {

    /**
     * Creates new form BuyingPage
     */
    DefaultTableModel myModel;
    public BuyingPage() {
        initComponents();
        init();
    }
    
    public void init(){
        myModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            } 
        };
        String tc = VeriTabaniProje.customer.getTcno();
        String sqlquery = "select * from arsalar where arsalar.satılık=1 except select * from arsalar where arsalar.tapuno in " +
                          "(select tapuno from sahiplik where tcno='"+tc+"' )";
        
       
        
        
        Object[] columns = {"Tapu No","İl","İlçe","Mahalle","Fiyat"};
        Object[] rows = new Object[5];
        
        myModel.setColumnCount(0);
        myModel.setRowCount(0);
        myModel.setColumnIdentifiers(columns);
        
        ResultSet rs = DBConnection.list(sqlquery);
        try {
            while(rs.next()){
                rows[0]=rs.getString("tapuno");
                rows[1]=rs.getString("il");
                rows[2]=rs.getString("ilçe");
                rows[3]=rs.getString("mahalle");
                rows[4]=rs.getString("fiyat");
                myModel.addRow(rows);
                        
                        
            }
             jTable1.setModel(myModel);
        } catch (SQLException e) {
            Logger.getLogger(BuyingPage.class.getName()).log(Level.SEVERE, null, e);

        }
        
        
        
    }
    
    
    public void refreshTable(){
         String tc = VeriTabaniProje.customer.getTcno();
        String sqlquery = "select * from arsalar where arsalar.satılık=1 except select * from arsalar where arsalar.tapuno in " +
                          "(select tapuno from sahiplik where tcno='"+tc+"' )";
        
       
        
        
        Object[] columns = {"Tapu No","İl","İlçe","Mahalle","Fiyat"};
        Object[] rows = new Object[5];
        
        myModel.setColumnCount(0);
        myModel.setRowCount(0);
        myModel.setColumnIdentifiers(columns);
        
        ResultSet rs = DBConnection.list(sqlquery);
        
        
        try {
            while(rs.next()){
                rows[0]=rs.getString("tapuno");
                rows[1]=rs.getString("il");
                rows[2]=rs.getString("ilçe");
                rows[3]=rs.getString("mahalle");
                rows[4]=rs.getString("fiyat");
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
        jButtonSatinAl = new javax.swing.JButton();
        jButtonGeri = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonFiltrele = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonFiltreKaldır = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonSatinAl.setText("Satın Al");
        jButtonSatinAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSatinAlActionPerformed(evt);
            }
        });

        jButtonGeri.setText("Geri");
        jButtonGeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGeriActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "il", "ilçe" }));

        jLabel1.setText("Filtre Seçimi");

        jButtonFiltrele.setText("Filtrele");
        jButtonFiltrele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltreleActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtre Giriniz :");

        jButtonFiltreKaldır.setText("Filtreleri Kaldır");
        jButtonFiltreKaldır.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltreKaldırActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGeri)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonSatinAl, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonFiltrele)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField1)
                                            .addComponent(jComboBox1, 0, 87, Short.MAX_VALUE))))
                                .addGap(35, 35, 35))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonFiltreKaldır)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFiltreKaldır)
                            .addComponent(jButtonFiltrele))
                        .addGap(211, 211, 211)
                        .addComponent(jButtonSatinAl, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGeri)
                        .addGap(16, 16, 16))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGeriActionPerformed
        // TODO add your handling code here
        MainPage mainPage = new MainPage();
        mainPage.setVisible(true);
        mainPage.pack();
        mainPage.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButtonGeriActionPerformed

    private void jButtonSatinAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSatinAlActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null,"<html>1500 TL Döner Sermaye Ücretini ve İşlem Ücretini Ödemeyi Onaylıyor musunuz?</html>","Onay",JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION){
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();
        Object tapuNo = model.getValueAt(selectedRow, 0);
        tapuNo = (String) tapuNo;
        Object fiyat = model.getValueAt(selectedRow, 4);
        Integer ekstra = Integer.parseInt(fiyat.toString());
        ekstra = ekstra *5 /100;
        Integer toplam = Integer.parseInt(fiyat.toString())+ekstra+1500;
        String tc = VeriTabaniProje.customer.getTcno();
        String sqlquery = "select tcno from sahiplik where tapuno= '"+tapuNo+"'";
        String TC = "";
        String query = "update sahiplik set tcno = '"+tc+"' where tapuno = '"+tapuNo+"'";
        String sql = "update arsalar set satılık = -1 where tapuno = '"+tapuNo+"'";
        try {
            
            PreparedStatement preparedStatement1 = DBConnection.connection.prepareStatement(sqlquery);
            ResultSet rs = preparedStatement1.executeQuery();
            if(rs.next()){
                TC = rs.getString(1);  
            }
            DBConnection.insertIslem(tapuNo.toString(), tc, TC, fiyat.toString(), ekstra, toplam.toString());
             PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement2 = DBConnection.connection.prepareStatement(sql);
            preparedStatement2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Arsa Satın Alındı");
        } catch (SQLException e) {
            Logger.getLogger(BuyingPage.class.getName()).log(Level.SEVERE,null,e);
        }
        
        refreshTable();
        }
        
        
        
    }//GEN-LAST:event_jButtonSatinAlActionPerformed

    private void jButtonFiltreleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltreleActionPerformed
        // TODO add your handling code here:
        
        String input = jTextField1.getText();
        
        
       
        if (jComboBox1.getSelectedItem().toString().equals("il")) {
            String sqlquery = "CREATE OR REPLACE FUNCTION search_il (sehir VARCHAR) " +
        "    RETURNS TABLE (" +
        "        tapuno VARCHAR," +
        "        il VARCHAR," +
        "		ilçe VARCHAR," +
        "		mahalle VARCHAR," +
        "		fiyat VARCHAR," +
        "		Satılık INT" +
        ") \n" +
        "AS $$\n" +
        "BEGIN\n" +
        "Return query select *\n" +
        "     from arsalar where arsalar.il = sehir and arsalar.satılık = 1;\n" +
        "END; $$ \n" +
        "\n" +
        "LANGUAGE 'plpgsql';";
            
             String query = "select* from search_il('"+input+"');";
            
                try {
            
            PreparedStatement ps = DBConnection.connection.prepareStatement(sqlquery);
            ps.execute();
            PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            Object[] columns = {"Tapu No","İl","İlçe","Mahalle","Fiyat"};
            Object[] rows = new Object[5];
        
            myModel.setColumnCount(0);
            myModel.setRowCount(0);
            myModel.setColumnIdentifiers(columns);

            while (rs.next()){
                rows[0]=rs.getString("tapuno");
                rows[1]=rs.getString("il");
                rows[2]=rs.getString("ilçe");
                rows[3]=rs.getString("mahalle");
                rows[4]=rs.getString("fiyat");
                myModel.addRow(rows);
                
            }
            jTable1.setModel(myModel);
        } catch (SQLException e) {
            Logger.getLogger(BuyingPage.class.getName()).log(Level.SEVERE, null, e);
        }
            }else if(jComboBox1.getSelectedItem().toString().equals("ilçe")){
                String sqlquery = "CREATE OR REPLACE FUNCTION search_ilce (sehir VARCHAR) " +
        "    RETURNS TABLE (" +
        "        tapuno VARCHAR," +
        "        il VARCHAR," +
        "		ilçe VARCHAR," +
        "		mahalle VARCHAR," +
        "		fiyat VARCHAR," +
        "		Satılık INT" +
        ") " +
        "AS $$" +
        "BEGIN " +
        "Return query select * " +
        "     from arsalar where arsalar.ilçe = sehir and arsalar.satılık = 1;\n" +
        "END; $$ " +
        "LANGUAGE 'plpgsql';";
            
             String query = "select* from search_ilce('"+input+"');";
             
             try {
            
            PreparedStatement ps = DBConnection.connection.prepareStatement(sqlquery);
            ps.execute();
            PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            Object[] columns = {"Tapu No","İl","İlçe","Mahalle","Fiyat"};
            Object[] rows = new Object[5];
        
            myModel.setColumnCount(0);
            myModel.setRowCount(0);
            myModel.setColumnIdentifiers(columns);

            while (rs.next()){
                rows[0]=rs.getString("tapuno");
                rows[1]=rs.getString("il");
                rows[2]=rs.getString("ilçe");
                rows[3]=rs.getString("mahalle");
                rows[4]=rs.getString("fiyat");
                myModel.addRow(rows);
                
            }
            jTable1.setModel(myModel);
        } catch (SQLException e) {
            Logger.getLogger(BuyingPage.class.getName()).log(Level.SEVERE, null, e);
        }
                
            }
        
        
    }//GEN-LAST:event_jButtonFiltreleActionPerformed

    private void jButtonFiltreKaldırActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltreKaldırActionPerformed
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_jButtonFiltreKaldırActionPerformed

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
            java.util.logging.Logger.getLogger(BuyingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuyingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuyingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuyingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuyingPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFiltreKaldır;
    private javax.swing.JButton jButtonFiltrele;
    private javax.swing.JButton jButtonGeri;
    private javax.swing.JButton jButtonSatinAl;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}