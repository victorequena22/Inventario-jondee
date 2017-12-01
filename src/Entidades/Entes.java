/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.awt.MouseInfo;
import java.awt.Point;
import Modelos.Entidades;
import Modelos.Contactos;
import Modelos.MAlmacen;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import IUModel.tablaContactos;

/**
 *
 * @author victo
 */
public class Entes extends javax.swing.JFrame {

    int x, y;
    ArrayList<Contactos> li;
    String tabla;
    Entidades w;

    /**
     * Creates new form Datos
     */
    public Entes(Entidades e, String t) {
        li = new ArrayList();
        initComponents();
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                setVisible(false);
            }
        });
        Nombre.setText(e.getNombre());
        Direccion.setText(e.getDireccion());
        Rif.setText(e.getRif());
        w = e;
        getTodos();
        tablaContactos w = new tablaContactos();
        w.setalmacen((List<Contactos>) li.clone());
        Contactos.setModel(w);
        this.Contactos.getColumnModel().getColumn(0).setPreferredWidth(750);
        this.Contactos.getColumnModel().getColumn(1).setPreferredWidth(1500);
        tabla = t;
    }

    public void getTodos() {
        li = new ArrayList();
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                PreparedStatement s = conexion.prepareStatement("SELECT tipo,contacto FROM jhondee.contactos where rif = " + w.getRif());
                ResultSet rs = s.executeQuery();
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                while (rs.next()) {
                    li.add(new Contactos(rs.getString("tipo"), rs.getString("contacto")));
                }
                // Se cierra la conexión con la base de datos.
            }
        } catch (SQLException e) {
        }
    }

    private void contactos(Contactos c) {
        {
            try {
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost/jhondee";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
                // the mysql insert statement
                String query = "INSERT IGNORE INTO contactos (rif,tipo,contacto)"
                        + " values (?, ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, Rif.getText());
                preparedStmt.setString(2, c.getTipo());
                preparedStmt.setString(3, c.getContacto());
                preparedStmt.execute();
                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }
    }

    private void actualizar() {
        {
            try {
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost/jhondee";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
                // the mysql insert statement
                String query = "UPDATE `jhondee`." + tabla
                        + " SET "
                        + "`nombre` =  \"" + Nombre.getText() + "\""
                        + ",`Direccion` = \"" + Direccion.getText() + "\""
                        + " WHERE `rif` = \"" + Rif.getText() + "\"";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.execute();
                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }
    }

    private void Borrar() {
        {
            try {
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost/jhondee";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
                // the mysql insert statement
                String query = "DELETE FROM `jhondee`.`contactos` WHERE rif = " + Rif.getText();
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.execute();
                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Direccion = new javax.swing.JTextArea();
        Agregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Rif = new javax.swing.JTextField();
        Contacto = new javax.swing.JTextField();
        Nombre = new javax.swing.JTextField();
        Tipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Contactos = new javax.swing.JTable();
        Quitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setText("Facturas");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        Direccion.setColumns(20);
        Direccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Direccion.setRows(5);
        jScrollPane2.setViewportView(Direccion);

        Agregar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Direccion");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("RIF/Cedula");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Nombre/Empresa");

        Rif.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Contacto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Tipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Celular", "Fijo", "correo" }));

        Contactos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Contactos);

        Quitar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Quitar.setText("Quitar");
        Quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Contacto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Quitar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Rif)
                            .addComponent(Nombre)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 232, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Contacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar)
                    .addComponent(Quitar))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        if ("".equals(Contacto.getText())) {
            JOptionPane.showMessageDialog(this, "Debe Colocar un Contacto", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            tablaContactos tc;
            tc = new tablaContactos();
            String t = (String) Tipo.getSelectedItem();
            li.add(new Contactos(t, Contacto.getText()));
            tc.setalmacen((List<Contactos>) li.clone());
            this.Contactos.setModel(tc);
            this.Contactos.getColumnModel().getColumn(0).setPreferredWidth(750);
            this.Contactos.getColumnModel().getColumn(1).setPreferredWidth(1500);
            Contacto.setText("");
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void QuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitarActionPerformed
        int fila = this.Contactos.getSelectedRow();
        int cod;
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar una Fila", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            tablaContactos tc;
            tc = new tablaContactos();
            li.remove(fila);
            tc.setalmacen((List<Contactos>) li.clone());
            this.Contactos.setModel(tc);
            this.Contactos.getColumnModel().getColumn(0).setPreferredWidth(750);
            this.Contactos.getColumnModel().getColumn(1).setPreferredWidth(1500);
        }
    }//GEN-LAST:event_QuitarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Desea continuar con la operacion", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            actualizar();
            Borrar();
            ArrayList<Contactos> l = (ArrayList<Contactos>) li.clone();
            for (Contactos op : l) {
                contactos(op);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if ("clientes".equals(tabla)) {
            new Facturas(w, "ventas", tabla).setVisible(true);
        } else {
            new Facturas(w, "compras", tabla).setVisible(true);
        }

    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JTextField Contacto;
    private javax.swing.JTable Contactos;
    private javax.swing.JTextArea Direccion;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton Quitar;
    private javax.swing.JTextField Rif;
    private javax.swing.JComboBox<String> Tipo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
