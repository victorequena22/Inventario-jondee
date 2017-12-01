/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ajustes;

import javax.swing.JOptionPane;
import java.awt.MouseInfo;
import Modelos.OpAux;
import java.awt.Point;
import IUModel.tablaProducto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author victo
 */
public class Entradas extends javax.swing.JFrame {
    int x, y;
    ArrayList<OpAux> li;
    int r;
    public Entradas() {
        initComponents();
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                setVisible(false);
            }
        });
        r=0;
        setModeloTabla();
        li = new ArrayList<OpAux>();
        NRegistro();
        re.setText(""+r);
    }

    private void setModeloTabla() {
        tablaProducto tf;
        //Instanciamos la clase
        tf = new tablaProducto();
        //Pasamos las propiedades pesonalizadas a la grid
        this.ProductoC.setModel(tf);
        //Productos Compra
        this.ProductoC.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.ProductoC.getColumnModel().getColumn(1).setPreferredWidth(1500);
        this.ProductoC.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.ProductoC.getColumnModel().getColumn(3).setPreferredWidth(200);
    }

    private void producto(OpAux op) {
        {
            try {
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost/jhondee";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
                // the mysql insert statement
                String query = "INSERT INTO auxop (nregistro,codalmacen,monto,cantidad)"
                        + " values (?, ?, ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, r);
                preparedStmt.setInt(2, op.getCod());
                preparedStmt.setFloat(3, op.getMonto());
                preparedStmt.setFloat(4, op.getCant());
                preparedStmt.execute();
                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }
    }

    private void sumar(OpAux op) {
        {
            try {
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost/jhondee";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
                // the mysql insert statement
                String query = "update almacen set cantidad = cantidad + " + op.getCant() + ", monto =" + nuevoMonto(op) + "  where codigo = " + op.getCod();
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.execute();
                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }
    }

    private void Registro() {
        {
            try {
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost/jhondee";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
                Calendar calendar = Fecha.getSelectedDate();
                java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
                // the mysql insert statement
                String query = "INSERT INTO registro (id, descripcion , fecha)"
                        + " values (?, ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, r);
                preparedStmt.setString(2, Descripcion.getText());
                preparedStmt.setDate(3, startDate);
                preparedStmt.execute();
                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }
    }

    private void entadas() {
        {
            try {
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost/jhondee";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
                // the mysql insert statement
                String query = "INSERT INTO entradas (registro, estatus)"
                                + " values (?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, r);
                preparedStmt.setString(2, "a");
                preparedStmt.execute();
                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }
    }

    void NRegistro() {
        String query = "select MAX(id) from registro ";        
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                PreparedStatement s = conexion.prepareStatement(query);
                ResultSet rs = s.executeQuery();
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                rs.next();
                r = rs.getInt(1)+1;
                
                // Se cierra la conexión con la base de datos.
            }//1000;
        } catch (SQLException e) {
        }
    }

    float cantidad(OpAux op) {
        float t = op.getCant();
        {
            try {
                DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
                try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                    PreparedStatement s = conexion.prepareStatement("SELECT `cantidad`  FROM jhondee.almacen where codigo =" + op.getCod());
                    ResultSet rs = s.executeQuery();
                    rs.next();
                    t += rs.getFloat("cantidad");
                }
            } catch (SQLException e) {
            }
        }
        return t;
    }

    float getma(OpAux op) {
        float t = 0;
        {
            try {
                DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
                try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                    PreparedStatement s = conexion.prepareStatement("SELECT `cantidad` * `monto` as mul FROM jhondee.almacen where codigo =" + op.getCod());
                    ResultSet rs = s.executeQuery();
                    rs.next();
                    t = rs.getFloat("mul");
                }
            } catch (SQLException e) {
            }
        }
        return t;
    }

    float getme(OpAux op) {
        return op.getMonto() * op.getCant();
    }

    float nuevoMonto(OpAux op) {
        return ((getma(op)+getme(op))/cantidad(op));
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
        Descripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        Rellenar = new javax.swing.JButton();
        Cantidad = new javax.swing.JTextField();
        re = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();
        Monto = new javax.swing.JTextField();
        Registrar = new javax.swing.JButton();
        Codigo = new javax.swing.JTextField();
        Agregar = new javax.swing.JButton();
        Quitar = new javax.swing.JButton();
        Almacen = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        ProductoC = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Fecha = new datechooser.beans.DateChooserCombo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Descripcion.setColumns(20);
        Descripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Descripcion.setRows(5);
        Descripcion.setToolTipText("Descripcion");
        jScrollPane1.setViewportView(Descripcion);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Total:");

        Rellenar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Rellenar.setText("Rellenar");
        Rellenar.setToolTipText("Completa los campos con la informacion de almacen");
        Rellenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RellenarActionPerformed(evt);
            }
        });

        Cantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Cantidad.setToolTipText("Cantidad del producto");
        Cantidad.setPreferredSize(new java.awt.Dimension(200, 30));

        re.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Total.setToolTipText("");
        Total.setPreferredSize(new java.awt.Dimension(200, 30));

        Monto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Monto.setToolTipText("Precio unitario");
        Monto.setPreferredSize(new java.awt.Dimension(200, 30));

        Registrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Registrar.setText("Registar");
        Registrar.setToolTipText("Guardar la factura y ejecuta el cambio en la base de datos ");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        Codigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Codigo.setToolTipText("Codigo del producto");
        Codigo.setPreferredSize(new java.awt.Dimension(200, 30));

        Agregar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Agregar.setText("Agregar");
        Agregar.setToolTipText("Agrega un elemento el producto marcado en las casillas");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Quitar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Quitar.setText("Quitar");
        Quitar.setToolTipText("Quita un elemento de la lista");
        Quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitarActionPerformed(evt);
            }
        });

        Almacen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Almacen.setToolTipText("Descripcion del producto");
        Almacen.setPreferredSize(new java.awt.Dimension(200, 30));

        jScrollPane14.setEnabled(false);
        jScrollPane14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ProductoC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ProductoC.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(ProductoC);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Numero de Registro: ");

        Fecha.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(re, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane14)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Almacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Monto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Rellenar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Registrar)
                        .addGap(255, 255, 255)
                        .addComponent(Agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Quitar)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Total, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(re, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Almacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rellenar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Registrar)
                        .addComponent(Agregar)
                        .addComponent(Quitar))
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RellenarActionPerformed

        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                PreparedStatement s = conexion.prepareStatement("select descripcion , cantidad from almacen where codigo =" + Codigo.getText());
                ResultSet rs = s.executeQuery();
                rs.next();
                Almacen.setText(rs.getString("descripcion"));
                Cantidad.setText("" + rs.getFloat("cantidad"));
            }
        } catch (SQLException e) {
        }

    }//GEN-LAST:event_RellenarActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Desea continuar con la operacion", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            NRegistro();
            Registro();
            entadas();
            ArrayList<OpAux> l = (ArrayList<OpAux>) li.clone();
            for (OpAux op : l) {
                producto(op);
                sumar(op);
            }
        }

    }//GEN-LAST:event_RegistrarActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        String c, d, ca, m;
        c = Codigo.getText();
        d = Almacen.getText();
        ca = Cantidad.getText();
        m = Monto.getName();
        boolean w = (((!"".equals(c)) && (!"".equals(d))) && ((!"".equals(m)) && (!"".equals(ca))));
        if (w) {
            tablaProducto tf;
            li.add(new OpAux(Integer.parseInt(Codigo.getText()), Almacen.getText(), Float.parseFloat(Monto.getText()), Float.parseFloat(Cantidad.getText())));
            tf = new tablaProducto();
            tf.setalmacen((List<OpAux>) li.clone());
            this.ProductoC.setModel(tf);
            this.ProductoC.getColumnModel().getColumn(0).setPreferredWidth(200);
            this.ProductoC.getColumnModel().getColumn(1).setPreferredWidth(1500);
            this.ProductoC.getColumnModel().getColumn(2).setPreferredWidth(200);
            this.ProductoC.getColumnModel().getColumn(3).setPreferredWidth(200);
            float i = 0;
            ArrayList<OpAux> l = (ArrayList<OpAux>) li.clone();
            i = l.stream().map((t) -> t.getCant() * t.getMonto()).reduce(i, (accumulator, _item) -> accumulator + _item);
            Codigo.setText("");
            Almacen.setText("");
            Monto.setText("");
            Cantidad.setText("");
            Total.setText("" + i);
        } else {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void QuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitarActionPerformed
        tablaProducto tf;
        tf = new tablaProducto();
        int fila = ProductoC.getSelectedRow();
        int cod;
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar una Fila", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            li.remove(fila);
            tf.setalmacen((List<OpAux>) li.clone());
            this.ProductoC.setModel(tf);
            this.ProductoC.getColumnModel().getColumn(0).setPreferredWidth(200);
            this.ProductoC.getColumnModel().getColumn(1).setPreferredWidth(1500);
            this.ProductoC.getColumnModel().getColumn(2).setPreferredWidth(200);
            this.ProductoC.getColumnModel().getColumn(3).setPreferredWidth(200);
            float i = 0;
            ArrayList<OpAux> l = (ArrayList<OpAux>) li.clone();
            i = l.stream().map((t) -> t.getCant() * t.getMonto()).reduce(i, (accumulator, _item) -> accumulator + _item);
            Codigo.setText("");
            Almacen.setText("");
            Monto.setText("");
            Cantidad.setText("");
            Total.setText("" + i);
        }
    }//GEN-LAST:event_QuitarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JTextField Almacen;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JTextField Codigo;
    private javax.swing.JTextArea Descripcion;
    private datechooser.beans.DateChooserCombo Fecha;
    private javax.swing.JTextField Monto;
    private javax.swing.JTable ProductoC;
    private javax.swing.JButton Quitar;
    private javax.swing.JButton Registrar;
    private javax.swing.JButton Rellenar;
    private javax.swing.JTextField Total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JLabel re;
    // End of variables declaration//GEN-END:variables
}
