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
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class Login extends javax.swing.JFrame {

    // deklarasi
    public Statement st;
    public ResultSet rs;

    Connection con = Koneksi.Koneksi();
    
    
    
    MenuUtama mnUtama = new MenuUtama();
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();

        //pemanggilan fungsi koneksi database yang sudah kita buat pada class koneksi.java
        reset();
        transparan();
        
        this.setTitle("Login");
    }
    
    public void transparan(){
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setOpaque(false);
        
        btnCancel.setFocusPainted(false);
        btnCancel.setBorderPainted(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setOpaque(false);
        
        
        txtUser.setOpaque(false);
        txtPass.setOpaque(false);
    }   
 

    public void reset(){
        txtUser.setText("");
        txtPass.setText("");
        txtUser.requestFocus();
        
    }
 
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUser = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        imgBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUser.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtUser.setBorder(null);
        txtUser.setOpaque(false);
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 230, 30));

        btnLogin.setBackground(java.awt.SystemColor.activeCaption);
        btnLogin.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/pbo/assets/btn_login.png"))); // NOI18N
        btnLogin.setAlignmentY(0.0F);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 140, 60));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/pbo/assets/btn_cancel_login.png"))); // NOI18N
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 140, 60));

        txtPass.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPass.setBorder(null);
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 230, 20));

        imgBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/pbo/assets/Login.png"))); // NOI18N
        getContentPane().add(imgBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        
        String status = "";
        String nama = "";
        
        if (txtUser.getText().equals("") || txtPass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Masukan Username dan Password!");
            reset();
        }else{
            
            try {
                st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                rs = st.executeQuery("SELECT idAdmin, user, pass, namaLengkap, status FROM admin WHERE user = '"+txtUser.getText()+"' AND pass='"+txtPass.getText()+"'");

                while(rs.next()){
                    status = rs.getString(5);
                    nama = rs.getString(4);
                }
                if(status.equals("")){
                    JOptionPane.showMessageDialog(null, "Username atau Password Salah!");
                    reset();
                }else{
                    if(status.equals("ADMIN")){

                        mnUtama.admin();
                        Session ss = new Session();
                        ss.setUsername(txtUser.getText());

                        JOptionPane.showMessageDialog(null, "Selamat Datang "  + nama);
                        mnUtama.admin();
                        mnUtama.setVisible(true);

                        this.dispose();
                    
                    } else if(status.equals("PETUGAS")){

                        mnUtama.petugas();
                        Session ss = new Session();
                        ss.setUsername(txtUser.getText());
                        
                        JOptionPane.showMessageDialog(null, "Selamat Datang "  + nama);
                        mnUtama.setVisible(true);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Login Gagal...!!!!");
                        reset(); 
                    }
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnLoginMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel imgBackground;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
