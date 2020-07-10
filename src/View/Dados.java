/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.Comandos;
import Control.Conexao;
import Model.Cliente;
import Model.Nicho;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author User
 */
public class Dados extends javax.swing.JFrame {

    /**
     * Creates new form Dados
     */
    Connection conexao;
    
    boolean Status;
    int Posicao = 0;
    int Index = 0;
    
    Cliente cliente = new Cliente();
    Nicho nicho = new Nicho();
    Comandos comandos = new Comandos();
    
    public Dados() {
        initComponents();
        
        pn_nicho.setVisible(false);
        
        this.conexao = new Conexao().getConnection();
        
        Load_Tabela(Index);
        get_Nicho();
        
    }
    
    private void Limpar() {
        
        txt_id.setText("");
        cb_nicho.setSelectedIndex(-1);
        ck_status.setSelected(false);
        txt_nome.setText("");
        txt_email.setText("");
        
    }
    
    private int get_ID_Nicho () {
        
        String sql = "select ID from dados.nichos where Nicho = ?";
        
        try {
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cb_nicho.getSelectedItem().toString());
            ResultSet rs = stmt.executeQuery();
            rs.next();
            
            return rs.getInt("ID");
            
        }

        catch (SQLException u) {

            JOptionPane.showMessageDialog(null, "Não foi possivel Detectar ID Nicho.");
            
            return 0;

        }
        
    }
    
    private void get_Nicho() {
        
        String sql = "select Nicho from dados.nichos";
        
        try {
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            cb_nicho.removeAllItems();
            
            while (rs.next()) {
                
                cb_nicho.addItem(rs.getString("Nicho"));
                
            }
            
            cb_nicho.setSelectedIndex(-1);
            
            stmt.close();
            rs.close();
            
        }
        
        catch (SQLException u) {
            
            JOptionPane.showMessageDialog(null, u);
            
        }
        
    }
    
    private void Load_Tabela(int Index) {
        
        String[] Colunas = {"ID", "Nicho", "Status", "Nome", "Email"};
        String[][] Dados = new String [8][5];
            
        try {
            
            String sql = "SELECT clientes.ID, nichos.Nicho, clientes.Status, clientes.Nome, clientes.Email FROM dados.clientes, dados.nichos WHERE clientes.Nicho = nichos.ID LIMIT 8 OFFSET ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, Index);
            ResultSet rs = stmt.executeQuery();
            
            for (int i = 0; i < Index; i++) {
                
                Dados[i][0] = rs.getString("ID");
                Dados[i][1] = rs.getString("Nicho");
                Dados[i][2] = rs.getString("Status");
                Dados[i][3] = rs.getString("Nome");
                Dados[i][4] = rs.getString("Email");
                
            }
            
        }

        catch (SQLException u) {

            JOptionPane.showMessageDialog(null, "Falha ao carregar dados.");

        }
        
        jTabela = new JTable(Dados, Colunas);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("dados?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txt_id = new javax.swing.JTextField();
        cb_nicho = new javax.swing.JComboBox<>();
        txt_nome = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bt_nicho = new javax.swing.JButton();
        ck_status = new javax.swing.JCheckBox();
        pn_nicho = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_nicho = new javax.swing.JTextField();
        bt_addNicho = new javax.swing.JButton();
        bt_addCliente = new javax.swing.JButton();
        bt_altCliente = new javax.swing.JButton();
        bt_delCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dados");
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        jTabela.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jScrollPane1.setViewportView(jTabela);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        txt_id.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_id.setToolTipText("");

        cb_nicho.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cb_nicho.setToolTipText("");

        txt_nome.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_nome.setToolTipText("");

        txt_email.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_email.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nicho");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");

        bt_nicho.setBackground(new java.awt.Color(255, 255, 255));
        bt_nicho.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt_nicho.setText("+");
        bt_nicho.setToolTipText("Novo Nicho");
        bt_nicho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_nichoActionPerformed(evt);
            }
        });

        ck_status.setBackground(new java.awt.Color(51, 51, 51));
        ck_status.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        ck_status.setForeground(new java.awt.Color(255, 255, 255));
        ck_status.setText("Ativo");
        ck_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_statusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_nicho, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_nicho)
                        .addGap(18, 18, 18)
                        .addComponent(ck_status)
                        .addGap(139, 139, 139))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_nicho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(bt_nicho)
                    .addComponent(ck_status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_nicho.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nicho");

        txt_nicho.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_nicho.setToolTipText("");

        bt_addNicho.setBackground(new java.awt.Color(255, 255, 255));
        bt_addNicho.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt_addNicho.setText("Adicionar Nicho");
        bt_addNicho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addNichoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_nichoLayout = new javax.swing.GroupLayout(pn_nicho);
        pn_nicho.setLayout(pn_nichoLayout);
        pn_nichoLayout.setHorizontalGroup(
            pn_nichoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_nichoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nicho, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_nichoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_addNicho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_nichoLayout.setVerticalGroup(
            pn_nichoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_nichoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_nichoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_nicho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_addNicho)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_addCliente.setBackground(new java.awt.Color(255, 255, 255));
        bt_addCliente.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt_addCliente.setText("Adicionar Cliente");
        bt_addCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addClienteActionPerformed(evt);
            }
        });

        bt_altCliente.setBackground(new java.awt.Color(255, 255, 255));
        bt_altCliente.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt_altCliente.setText("Alterar Cliente");
        bt_altCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_altClienteActionPerformed(evt);
            }
        });

        bt_delCliente.setBackground(new java.awt.Color(255, 255, 255));
        bt_delCliente.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt_delCliente.setText("Deletar Cliente");
        bt_delCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_delClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_addCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_altCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_delCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_nicho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_nicho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(bt_addCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_altCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_delCliente)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_nichoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nichoActionPerformed
        // TODO add your handling code here:
        
        if (pn_nicho.isVisible()) {
            
            pn_nicho.setVisible(false);
            
        }
        
        else {
            
            pn_nicho.setVisible(true);
            
        }
        
    }//GEN-LAST:event_bt_nichoActionPerformed

    private void bt_addNichoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addNichoActionPerformed
        // TODO add your handling code here:
        
        if (!txt_nicho.getText().equals("")) {
            
            String Nicho = txt_nicho.getText();

            nicho.setNicho(Nicho);

            comandos.Inserir_Nicho(nicho);

            txt_nicho.setText("");

            get_Nicho();
            
            txt_nicho.setBackground(Color.WHITE);
            txt_nicho.setForeground(Color.BLACK);
            
        }
        
        else {
            
            txt_nicho.setBackground(Color.RED);
            txt_nicho.setForeground(Color.WHITE);
            
            JOptionPane.showMessageDialog(null, "Nicho necessário.");
            
        }
        
    }//GEN-LAST:event_bt_addNichoActionPerformed

    private void bt_addClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addClienteActionPerformed
        // TODO add your handling code here:
        
        if (cb_nicho.getSelectedIndex() != -1 && !txt_nome.getText().equals("") && !txt_email.getText().equals("")) {
            
            String Nome = txt_nome.getText();
            String Email = txt_email.getText();
            
            int Nicho = get_ID_Nicho();

            cliente.setNicho(Nicho);
            cliente.setStatus(Status);
            cliente.setNome(Nome);
            cliente.setEmail(Email);

            comandos.Inserir_Cliente(cliente);

            cb_nicho.setBackground(Color.WHITE);
            cb_nicho.setForeground(Color.BLACK);
            txt_nome.setBackground(Color.WHITE);
            txt_nome.setForeground(Color.BLACK);
            txt_email.setBackground(Color.WHITE);
            txt_email.setForeground(Color.BLACK);

            Limpar();
            
        }
        
        else {
            
            if (cb_nicho.getSelectedIndex() == -1) {
                
                cb_nicho.setBackground(Color.RED);
                cb_nicho.setForeground(Color.WHITE);
                
            }
            
            else {
                
                cb_nicho.setBackground(Color.WHITE);
                cb_nicho.setForeground(Color.BLACK);
                
            }
            
            if (txt_nome.getText().equals("")) {
                
                txt_nome.setBackground(Color.RED);
                txt_nome.setForeground(Color.WHITE);
                
            }
            
            else {
                
                txt_nome.setBackground(Color.WHITE);
                txt_nome.setForeground(Color.BLACK);
                
            }
            
            if (txt_email.getText().equals("")) {
                
                txt_email.setBackground(Color.RED);
                txt_email.setForeground(Color.WHITE);
                
            }
            
            else {
                
                txt_email.setBackground(Color.WHITE);
                txt_email.setForeground(Color.BLACK);
                
            }
            
            JOptionPane.showMessageDialog(null, "sem dados");
            
        }
        
    }//GEN-LAST:event_bt_addClienteActionPerformed

    private void bt_altClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_altClienteActionPerformed
        // TODO add your handling code here:
        // Codar ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        if (!txt_id.getText().equals("")) {
            
            int ID = Integer.parseInt(txt_id.getText());
            int Nicho = get_ID_Nicho();
            String Nome = txt_nome.getText();
            String Email = txt_email.getText();
            
            txt_id.setBackground(Color.WHITE);
            txt_id.setForeground(Color.BLACK);
            
        }
        
        else {
            
            txt_id.setBackground(Color.RED);
            txt_id.setForeground(Color.WHITE);
            JOptionPane.showMessageDialog(null, "ID necessário.");
            
        }
        
    }//GEN-LAST:event_bt_altClienteActionPerformed

    private void bt_delClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_delClienteActionPerformed
        // TODO add your handling code here:
        
        if (!txt_id.getText().equals("")) {
            
            int ID = Integer.parseInt(txt_id.getText());
            
            comandos.Deletar(ID);
            
            Limpar();
            
            txt_id.setBackground(Color.WHITE);
            txt_id.setForeground(Color.BLACK);
            
        }
        
        else {
            
            JOptionPane.showMessageDialog(null, "ID necessário.");
            
            txt_id.setBackground(Color.RED);
            txt_id.setForeground(Color.WHITE);
            
        }
        
    }//GEN-LAST:event_bt_delClienteActionPerformed

    private void ck_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_statusActionPerformed
        // TODO add your handling code here:
        
        if (ck_status.isSelected()) {
            
            Status = true;
            
        }
        
        else {
            
            Status = false;
            
        }
        
    }//GEN-LAST:event_ck_statusActionPerformed

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
            java.util.logging.Logger.getLogger(Dados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addCliente;
    private javax.swing.JButton bt_addNicho;
    private javax.swing.JButton bt_altCliente;
    private javax.swing.JButton bt_delCliente;
    private javax.swing.JButton bt_nicho;
    private javax.swing.JComboBox<String> cb_nicho;
    private javax.swing.JCheckBox ck_status;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabela;
    private javax.swing.JPanel pn_nicho;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nicho;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables
}
