/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.pbo;

/**
 *
 * @author this.naff
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MenuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form MenuAdmin
     */
    
    public Statement st;
    public ResultSet rs;
    
    public DefaultTableModel tabModel;
    Connection cn = Koneksi.Koneksi();
    
    public void admin() {
    Object[] admin = {
      "Id", "User", "Password", "Nama Lengkap", "Status"
    };
    tabModel = new DefaultTableModel(null, admin);
    tblDataAdmin.setModel(tabModel);
    }
    
    public void tampilData(String where) {
    try {
      st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      tabModel.getDataVector().removeAllElements();
      tabModel.fireTableDataChanged();
      rs = st.executeQuery("SELECT * FROM admin " + where);

      while (rs.next()) {
        Object[] data = {
          rs.getString("idAdmin"),
          rs.getString("user"),
          rs.getString("pass"),
          rs.getString("namaLengkap"),
          rs.getString("status"),
        };

          tabModel.addRow(data);
      }
    } catch(Exception e) {
        JOptionPane.showMessageDialog(this, "ERROR: \n" + e.toString(),
                  "Kesalahan", JOptionPane.WARNING_MESSAGE);
    }   
    }
    
    public void Ai(){
      try {
          Koneksi.Koneksi();
          rs = st.executeQuery("SELECT MAX(right(idAdmin,3)) FROM admin");
          while(rs.next()){
              if(rs.first()== false){
                  txtIdAdmin.setText("AP-001");
              }else{
                  rs.last();
                  int autoId = rs.getInt(1) + 1;
                  String idAdmin = String.valueOf(autoId);
                  int noLong = idAdmin.length();
                  for (int i = 0; i < 3-noLong; i++) {
                      idAdmin = "0" + idAdmin;
                  }
                  txtIdAdmin.setText("AP-" + idAdmin);
              }  
          }
      } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR: \n" + e.toString(),
                  "Kesalahan", JOptionPane.WARNING_MESSAGE);
      }      
  }
    
    public void reset(){
      txtUser.setText("");
      txtPass.setText("");
      txtNama.setText("");
      txtComboStatus.setSelectedItem("ADMIN");
      txtUser.requestFocus();
      
      
      btnSave.setEnabled(true);
      btnCancel.setEnabled(true);
      btnDelete.setEnabled(true);
      btnUpdate.setEnabled(true);
      Ai();
  }
 
    public void transparan(){
        btnSave.setFocusPainted(false);
        btnSave.setBorderPainted(false);
        btnSave.setContentAreaFilled(false);
        btnSave.setOpaque(false);
        
        btnUpdate.setFocusPainted(false);
        btnUpdate.setBorderPainted(false);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setOpaque(false);
        
        btnDelete.setFocusPainted(false);
        btnDelete.setBorderPainted(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setOpaque(false);
        
        btnCancel.setFocusPainted(false);
        btnCancel.setBorderPainted(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setOpaque(false);
        
        txtUser.setOpaque(false);
        txtNama.setOpaque(false);
        txtPass.setOpaque(false);
        txtComboStatus.setOpaque(false);
        
    }   

    public MenuAdmin() {
        initComponents();
        admin();
        tampilData("");
        transparan();
        Ai();
        
        this.setTitle("Menu Petugas");
        
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
        tblDataAdmin = new javax.swing.JTable();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtComboStatus = new javax.swing.JComboBox<>();
        txtIdAdmin = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDataAdmin.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDataAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDataAdmin);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 720, 110));

        txtUser.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtUser.setBorder(null);
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 630, 30));

        txtPass.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtPass.setBorder(null);
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 630, 20));

        txtNama.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNama.setBorder(null);
        getContentPane().add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 630, 30));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/pbo/assets/btn_save.png"))); // NOI18N
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 100, 60));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/pbo/assets/btn_update.png"))); // NOI18N
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 100, 60));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/pbo/assets/btn_delete.png"))); // NOI18N
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 100, 60));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/pbo/assets/btn_cancel.png"))); // NOI18N
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, 100, 60));

        txtComboStatus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtComboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "PETUGAS" }));
        txtComboStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtComboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComboStatusActionPerformed(evt);
            }
        });
        getContentPane().add(txtComboStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 90, -1));

        txtIdAdmin.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtIdAdmin.setText("Kode Otomatis");
        getContentPane().add(txtIdAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/pbo/assets/Data Admin.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1AtxtComboStatusrmed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(txtUser.getText().equals("") || txtNama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Data Masih Kosong!");
        }else{
            try {
                st = cn.createStatement();
                st.executeUpdate("UPDATE admin set " 
                    + "idAdmin='"       + txtIdAdmin.getText() + "', "
                    + "user='"       + txtUser.getText() + "', "
                    + "pass='"      + txtPass.getText() + "', "
                    + "namaLengkap='"   + txtNama.getText()+ "', "
                    + "status='"    + txtComboStatus.getSelectedItem() + "' WHERE "
                    + "idAdmin='"      + txtIdAdmin.getText() + "'");
                tampilData("");
                JOptionPane.showMessageDialog(null, "Update Berhasil");
                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "ERROR: \n" + e.toString(),
                  "Kesalahan", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(txtUser.getText().equals("") || txtNama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Data Masih Kosong!");
        }else{
            try {
                st = cn.createStatement();
                st.executeUpdate("INSERT INTO admin VALUES('" + txtIdAdmin.getText() + "','" + txtUser.getText() + "','"
                    + txtPass.getText() + "','"
                    + txtNama.getText()+ "','"
                    + txtComboStatus.getSelectedItem()+ "')");
                tampilData("");
                JOptionPane.showMessageDialog(null, "Simpan Berhasil");
                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "ERROR: \n" + e.toString(),
                  "Kesalahan", JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblDataAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataAdminMouseClicked
        // TODO add your handling code here:
        txtIdAdmin.setText(tblDataAdmin.getValueAt(tblDataAdmin.getSelectedRow(), 0).toString());
        txtUser.setText(tblDataAdmin.getValueAt(tblDataAdmin.getSelectedRow(), 1).toString());
        txtPass.setText(tblDataAdmin.getValueAt(tblDataAdmin.getSelectedRow(), 2).toString());
        txtNama.setText(tblDataAdmin.getValueAt(tblDataAdmin.getSelectedRow(), 3).toString());
        txtComboStatus.setSelectedItem(tblDataAdmin.getValueAt(tblDataAdmin.getSelectedRow(), 4).toString());
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tblDataAdminMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
        int jawab;

        if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
          st = cn.createStatement();
          st.executeUpdate("DELETE FROM admin WHERE idAdmin='"
              + tabModel.getValueAt(tblDataAdmin.getSelectedRow(), 0) + "'");
          tampilData("");
          reset();
        }
      } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR: \n" + e.toString(),
                  "Kesalahan", JOptionPane.WARNING_MESSAGE);
      }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtComboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComboStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComboStatusActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MenuAdmin().setVisible(true);
//            }
//        });
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDataAdmin;
    private javax.swing.JComboBox<String> txtComboStatus;
    private javax.swing.JLabel txtIdAdmin;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}