/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelos.OpAux;
import java.awt.MouseInfo;
import java.awt.Point;
import IUModel.tablaProducto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author victo
 */
public final class factura extends javax.swing.JFrame {
    int x, y;
    int Registro;
    tablaProducto tf;
    String Tabla;

    public factura(int registro, String tabla) {
        Registro = registro;
        Tabla = tabla;
        initComponents();
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                setVisible(false);
            }
        });
        getdatos();
        getpro();
        tf.setalmacen((ArrayList<OpAux>) getpro().clone());
        Producto.setModel(tf);
        this.Producto.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.Producto.getColumnModel().getColumn(1).setPreferredWidth(1500);
        this.Producto.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.Producto.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                setVisible(false);
            }
        });
    }



    public void getdatos() {
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                PreparedStatement s = conexion.prepareStatement("select  sql_cache `registro`.id,`registro`.descripcion,`registro`.fecha,"
                        + "`" + Tabla + "`.factura,`" + Tabla + "`.rif from `registro` "
                        + "inner join `" + Tabla
                        + "` on `" + Tabla + "`.registro = `registro`.id "
                        + "where `" + Tabla + "`.estatus = 'a' and "
                        + "`registro`.id = " + Registro
                        + "ORDER BY `registro`.fecha desc");
                ResultSet rs = s.executeQuery();
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                rs.next();
                String t;
                if ("ventas" == Tabla) {
                    t = "Proveedor: ";
                } else {
                    t = "Cliente: ";
                }
                Rif.setText(t + rs.getString("rif"));
                factura.setText("Factura N:" + rs.getInt("factura"));
                Fecha.setText("Fecha: " + rs.getDate("fecha").toString());
                Descripcion.setText(rs.getString("descripcion"));
                registro.setText("Numero de registro" + rs.getString("id"));
                // Se cierra la conexión con la base de datos.
                conexion.close();
            }
        } catch (SQLException e) {
        }
    }

    public ArrayList<OpAux> getpro() {
        ArrayList<OpAux> al;
        al = new ArrayList();
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                PreparedStatement s = conexion.prepareStatement("SELECT `auxop`.`codalmacen`,`almacen`.`descripcion`,`auxop`.`monto`,`auxop`.`cantidad`"
                        + "FROM `jhondee`.`auxop` inner join `almacen` on  `auxop`.`codalmacen`=`almacen`.`codigo`"
                        + "where `auxop`.`nregistro`=" + Registro);
                ResultSet rs = s.executeQuery();
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                while (rs.next()) {
                    al.add(new OpAux(rs.getInt("codalmacen"), 
                                     rs.getString("descripcion"), 
                                     rs.getFloat("monto"), 
                                     rs.getFloat("cantidad")));
                }
                // Se cierra la conexión con la base de datos.
                conexion.close();
            }
        } catch (SQLException e) {
        }
        float p = 0;
        ArrayList<OpAux> t;
        t = (ArrayList<OpAux>) al.clone();
        for (OpAux i :al) {
            p = (i.getCant() * i.getMonto());
        }
        Total.setText("Total: "+p);
        return t;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Producto = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JLabel();
        factura = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        registro = new javax.swing.JLabel();
        Rif = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Producto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Producto);

        Descripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(Descripcion);

        factura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Fecha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        registro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Rif.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Rif, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(169, 169, 169))
                                    .addComponent(registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(factura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(factura, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(Rif, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descripcion;
    private javax.swing.JLabel Fecha;
    private javax.swing.JTable Producto;
    private javax.swing.JLabel Rif;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel factura;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel registro;
    // End of variables declaration//GEN-END:variables
}
