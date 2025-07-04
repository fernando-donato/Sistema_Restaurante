/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package restauranteapp;

import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author fernando
 */
public class TelaRegistroPedido extends javax.swing.JFrame {
    private final Map<String, Integer> funcionariosMap = new HashMap<>();
    private final Map<String, Integer> clientesMap = new HashMap<>();
    private final Map<String, Integer> pratosMap = new HashMap<>();
   
    /**
     * Creates new form TelaRegistroPedido
     */
    public TelaRegistroPedido() {
        initComponents();
        setLocationRelativeTo(null);
        preencherDataHora();
        carregarDados();
        calcularTotal();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        Funcionário = new javax.swing.JLabel();
        Clientes = new javax.swing.JLabel();
        lblDataHora = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItens = new javax.swing.JTable();
        lblTotalConta = new javax.swing.JLabel();
        txtTotalConta = new javax.swing.JTextField();
        txtDataHora = new javax.swing.JTextField();
        cmbFuncionario = new javax.swing.JComboBox<>();
        cmbClientes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogo.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblLogo.setText("Restaurante Sabor e Arte");

        lblTitulo.setText("\tRegistro de Pedidos");

        Funcionário.setText("Funcionário");

        Clientes.setText("Cliente");

        lblDataHora.setText("Data/Hora");

        btnRegistrar.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnRegistrar.setText("RegistrarPedido");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tabelaItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item", "Qtd", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaItens);

        lblTotalConta.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        lblTotalConta.setText("Total: R$");

        txtTotalConta.setEditable(false);

        cmbFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Clientes)
                        .addComponent(Funcionário)
                        .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDataHora))
                    .addComponent(lblDataHora)
                    .addComponent(cmbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(btnCancelar))
                            .addComponent(lblTitulo))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotalConta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotalConta, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(82, 82, 82))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogo)
                    .addComponent(lblTitulo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(Funcionário)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Clientes)
                        .addGap(18, 18, 18)
                        .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDataHora)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalConta)
                    .addComponent(txtTotalConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void preencherDataHora() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        txtDataHora.setText(LocalDateTime.now().format(formatter));
        txtDataHora.setEditable(false);
    }

            private void carregarDados() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Load employees
            String sqlFunc = "SELECT id_funcionarios, nome FROM funcionarios";
            try (PreparedStatement stmtFunc = conn.prepareStatement(sqlFunc);
                 ResultSet rsFunc = stmtFunc.executeQuery()) {
                
                cmbFuncionario.removeAllItems();
                funcionariosMap.clear();
                while (rsFunc.next()) {
                    int id = rsFunc.getInt("id_funcionarios");
                    String nome = rsFunc.getString("nome");
                    funcionariosMap.put(nome, id);
                    cmbFuncionario.addItem(nome);
                }
            }
            
            // Load clients
            String sqlCli = "SELECT id_cliente, nome FROM clientes";
            try (PreparedStatement stmtCli = conn.prepareStatement(sqlCli);
                 ResultSet rsCli = stmtCli.executeQuery()) {
                
                cmbClientes.removeAllItems();
                clientesMap.clear();
                while (rsCli.next()) {
                    int id = rsCli.getInt("id_cliente");
                    String nome = rsCli.getString("nome");
                    clientesMap.put(nome, id);
                    cmbClientes.addItem(nome);
                }
            }
            
            // Load menu items
            String sqlPratos = "SELECT id_pratos, nome, preco FROM pratos";
            try (PreparedStatement stmtPratos = conn.prepareStatement(sqlPratos);
                 ResultSet rsPratos = stmtPratos.executeQuery()) {
                
                DefaultTableModel model = (DefaultTableModel) tabelaItens.getModel();
                model.setRowCount(0); // Clear existing items
                pratosMap.clear();
                
                while (rsPratos.next()) {
                    int id = rsPratos.getInt("id_pratos");
                    String nome = rsPratos.getString("nome");
                    double preco = rsPratos.getDouble("preco");
                    pratosMap.put(nome, id);
                    model.addRow(new Object[]{nome, 1, preco});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao carregar dados: " + e.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularTotal() {
        double total = 0.0;
        DefaultTableModel model = (DefaultTableModel) tabelaItens.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                int qtd = Integer.parseInt(model.getValueAt(i, 1).toString());
                double preco = Double.parseDouble(model.getValueAt(i, 2).toString());
                total += qtd * preco;
            } catch (Exception e) {
                // Ignore invalid rows
            }
        }
        txtTotalConta.setText(String.format("R$ %.2f", total));
    }
    
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose(); 
        TelaMenuPrincipal menuPrincipal = new TelaMenuPrincipal();
        menuPrincipal.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    try {
        String funcionarioNome = (String) cmbFuncionario.getSelectedItem();
        String clienteNome = (String) cmbClientes.getSelectedItem();

        if (funcionarioNome == null || clienteNome == null) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, selecione funcionário e cliente!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tabelaItens.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, adicione itens ao pedido!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            int funcionarioId = funcionariosMap.get(funcionarioNome);
            int clientesId = clientesMap.get(clienteNome);

            String sqlPedido = "INSERT INTO pedidos (id_cliente, data_hora, status, id_funcionario) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmtPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
                // Conversão da data para formato SQL
                String dataHoraStr = txtDataHora.getText();
                DateTimeFormatter formatoAtual = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, formatoAtual);
                DateTimeFormatter formatoSql = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String dataHoraSql = dataHora.format(formatoSql);

                stmtPedido.setInt(1, clientesId);
                stmtPedido.setString(2, dataHoraSql);
                stmtPedido.setString(3, "Aberto");
                stmtPedido.setInt(4, funcionarioId);

                stmtPedido.executeUpdate();

                ResultSet rsPedido = stmtPedido.getGeneratedKeys();
                int pedidoId = -1;
                if (rsPedido.next()) {
                    pedidoId = rsPedido.getInt(1);
                } else {
                    throw new SQLException("Erro ao obter ID do pedido");
                }

                String sqlItem = "INSERT INTO itens_pedidos (id_pedidos, id_pratos, quantidade) VALUES (?, ?, ?)";
                try (PreparedStatement stmtItem = conn.prepareStatement(sqlItem)) {
                for (int i = 0; i < model.getRowCount(); i++) {
                String pratoNome = (String) model.getValueAt(i, 0);
                int pratoId = pratosMap.get(pratoNome);
                int qtd = (Integer) model.getValueAt(i, 1);

                stmtItem.setInt(1, pedidoId); // id_pedidos
                stmtItem.setInt(2, pratoId);  // id_pratos
                stmtItem.setInt(3, qtd);       // quantidade
                stmtItem.executeUpdate();
    }
}


                conn.commit();

                JOptionPane.showMessageDialog(this,
                        "Pedido registrado com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                this.dispose();

                TelaMenuPrincipal menuPrincipal = new TelaMenuPrincipal();
                menuPrincipal.setVisible(true);
            } catch (SQLException e) {
                conn.rollback();
                throw e; // vai cair no catch abaixo
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Erro ao registrar pedido: " + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Erro inesperado: " + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnRegistrarActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaRegistroPedido().setVisible(true));
    }

    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clientes;
    private javax.swing.JLabel Funcionário;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbFuncionario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDataHora;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotalConta;
    private javax.swing.JTable tabelaItens;
    private javax.swing.JTextField txtDataHora;
    private javax.swing.JTextField txtTotalConta;
    // End of variables declaration//GEN-END:variables
}
