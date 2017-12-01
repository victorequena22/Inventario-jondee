/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacen;

import Modelos.CV;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import IUModel.tablaFacturasAlmacen;

/**
 *
 * @author victo
 */
public class ListaFacturas extends javax.swing.JFrame {

    int c;
    String tabla, ente;
    tablaFacturasAlmacen ta;
    ArrayList<CV> li;

    public ListaFacturas(int c, String tabla, String e) {
        initComponents();
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                setVisible(false);
            }
        });
        li = new ArrayList();
        this.c = c;
        this.tabla = tabla;
        ente = e;
        setModeloTabla();

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Facturas = new javax.swing.JButton();
        Pdf = new javax.swing.JButton();
        Excel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAlmacen = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Filtro = new javax.swing.JButton();
        Hasta = new datechooser.beans.DateChooserCombo();
        Desde = new datechooser.beans.DateChooserCombo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Facturas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Facturas.setText("Facturas");
        Facturas.setPreferredSize(new java.awt.Dimension(45, 45));
        Facturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacturasActionPerformed(evt);
            }
        });

        Pdf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Pdf.setText("PDF");
        Pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PdfActionPerformed(evt);
            }
        });

        Excel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Excel.setText("EXCEL");
        Excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcelActionPerformed(evt);
            }
        });

        TAlmacen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TAlmacen.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TAlmacen);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Desde");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Hasta");

        Filtro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Filtro.setText("Filtrar");
        Filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroActionPerformed(evt);
            }
        });

        Hasta.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 20));

        Desde.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Excel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Facturas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Desde, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Desde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
                    .addComponent(Filtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Hasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Excel)
                    .addComponent(Pdf)
                    .addComponent(Facturas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public ArrayList<CV> Filtro() {
        Calendar c1 = Desde.getSelectedDate();
        java.sql.Date d1 = new java.sql.Date(c1.getTime().getTime());
        Calendar c2 = Hasta.getSelectedDate();
        java.sql.Date d2 = new java.sql.Date(c2.getTime().getTime());
        ArrayList<CV> al;
        al = new ArrayList<>();
        try {DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                PreparedStatement s = conexion.prepareStatement(
                        "select sql_cache registro.id ," + tabla + ".facturas," + ente + ".nombre, \n"
                        + "registro.descripcion, auxop.monto, auxop.cantidad ,registro.fecha \n"
                        + "from auxop INNER JOIN registro on registro.id = auxop.nregistro \n"
                        + "INNER JOIN " + tabla + " on registro.id = " + tabla + ".registro \n"
                        + "INNER JOIN " + ente + " on " + ente + ".rif = " + tabla + ".rif \n"
                        + "where registro.fecha BETWEEN '" + d1.toString() + "' and  '" + d2.toString() + "' \n"
                        + "and auxop.codalmacen =" + c
                        + " order by `fecha` desc");
                ResultSet rs = s.executeQuery();
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                while (rs.next()) {
                    al.add(new CV(
                            rs.getInt("id"),
                            rs.getInt("facturas"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getFloat("monto"),
                            rs.getFloat("cantidad"),
                            rs.getDate("fecha")));
                }
                // Se cierra la conexión con la base de datos.
                conexion.close();
            }
        } catch (SQLException e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
        }
        return al;
    }

    private void setModeloTabla() {
        tablaFacturasAlmacen k;
        String v;
        li = (ArrayList<CV>) Filtro().clone();
        if (tabla.equals("compras")) {
            v="Proveedor";
        } else {
            v="Cliente";
        }
        k = new tablaFacturasAlmacen(v);
        /*if (tabla.equals("compras")) {
            ta = new tablaFacturasAlmacen("Proveedor");
        } else {
            ta = new tablaFacturasAlmacen("Cliente");
        }*/
        k.setalmacen((List<CV>) li.clone());
        this.TAlmacen.setModel(k);
        this.TAlmacen.setRowHeight(15);
        this.TAlmacen.getColumnModel().getColumn(0).setPreferredWidth(1000);
        this.TAlmacen.getColumnModel().getColumn(1).setPreferredWidth(2000);
        this.TAlmacen.getColumnModel().getColumn(2).setPreferredWidth(5000);
        this.TAlmacen.getColumnModel().getColumn(3).setPreferredWidth(1000);
        this.TAlmacen.getColumnModel().getColumn(4).setPreferredWidth(1000); 


    }


    private void FacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacturasActionPerformed
        int fila = this.TAlmacen.getSelectedRow();
        if (0 > fila) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar una Fila", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int t = li.get(fila).getRegistro();
            new Datos.factura(t, "ventas").setVisible(true);
        }
    }//GEN-LAST:event_FacturasActionPerformed

    private void PdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PdfActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de PDF", "pdf");
        File fichero;
        JFileChooser fileChooserGuardar = new JFileChooser();
        fileChooserGuardar.setFileFilter(filtro);
        fileChooserGuardar.setDialogTitle("Guardar PDF");
        int seleccion = fileChooserGuardar.showSaveDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            fichero = fileChooserGuardar.getSelectedFile();
            fileChooserGuardar.setFileSelectionMode(JFileChooser.FILES_ONLY);
            try {
                Document documento = new Document();

                // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
                FileOutputStream ficheroPdf = new FileOutputStream(fichero + ".pdf");

                // Se asocia el documento al OutputStream y se indica que el espaciado entre
                // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
                PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);

                // Se abre el documento.
                documento.open();
                PdfPTable table = new PdfPTable(7);
                table.setWidths(new float[]{150, 250, 1000, 1500, 200, 200, 200});
                for (int i = 0; i < TAlmacen.getColumnCount(); i++) {
                    table.addCell(TAlmacen.getColumnName(i));
                }
                for (int rows = 0; rows < TAlmacen.getRowCount(); rows++) {
                    for (int cols = 0; cols < TAlmacen.getColumnCount(); cols++) {
                        table.addCell(TAlmacen.getModel().getValueAt(rows, cols).toString());
                    }
                }
                documento.add(table);
                documento.close();
            } catch (DocumentException | FileNotFoundException ex) {
                Logger.getLogger(ListaFacturas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_PdfActionPerformed

    private void ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcelActionPerformed
        JFileChooser seleccionar = new JFileChooser();
        File archivo;
        if (seleccionar.showDialog(null, "Exportar Excel") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            int cantFila = TAlmacen.getRowCount();
            int cantColumna = TAlmacen.getColumnCount();
            Workbook wb;
            wb = new XSSFWorkbook();
            Sheet hoja = wb.createSheet("  ");
            hoja.setColumnWidth(0, 1500);
            hoja.setColumnWidth(1, 2000);
            hoja.setColumnWidth(2, 4000);
            hoja.setColumnWidth(3, 10000);
            hoja.setColumnWidth(4, 2000);
            hoja.setColumnWidth(5, 2000);
            hoja.setColumnWidth(6, 2000);
            try {
                for (int i = -1; i < cantFila; i++) {
                    Row fila = hoja.createRow(i + 1);

                    for (int j = 0; j < cantColumna; j++) {
                        Cell celda = fila.createCell(j);
                        if (i == -1) {
                            celda.setCellValue(String.valueOf(TAlmacen.getColumnName(j)));
                        } else {
                            celda.setCellValue(String.valueOf(TAlmacen.getValueAt(i, j)));
                        }
                        wb.write(new FileOutputStream(archivo + ".xlsx"));
                    }
                }
                JOptionPane.showMessageDialog(null, "Exportacion exitosa");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Vuelve a intentarlo");
            }

        }
    }//GEN-LAST:event_ExcelActionPerformed

    private void FiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroActionPerformed
        setModeloTabla();
    }//GEN-LAST:event_FiltroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo Desde;
    private javax.swing.JButton Excel;
    private javax.swing.JButton Facturas;
    private javax.swing.JButton Filtro;
    private datechooser.beans.DateChooserCombo Hasta;
    private javax.swing.JButton Pdf;
    private javax.swing.JTable TAlmacen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
