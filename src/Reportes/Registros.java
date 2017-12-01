/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Modelos.MRegistros;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import IUModel.tablaRegistro;
import java.util.Calendar;

/**
 *
 * @author victo
 */
public class Registros extends javax.swing.JFrame {

    String tabla;
    tablaRegistro ta;
    List<MRegistros> li;

    /**
     * Creates new form MRegistros
     */
    public Registros(String tabla) {
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                setVisible(false);
            }
        });
        initComponents();
        this.tabla = tabla;
    }

    public ArrayList<Registros> Filtro() {
        ArrayList<Registros> al;
        al = new ArrayList();
        String t;
        Calendar c1 = Desde.getSelectedDate();
        java.sql.Date d1 = new java.sql.Date(c1.getTime().getTime());
        Calendar c2 = Hasta.getSelectedDate();
        java.sql.Date d2 = new java.sql.Date(c2.getTime().getTime());

        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                PreparedStatement s = conexion.prepareStatement(
                        "select sql_cache registro.id,registro.descripcion, sum(auxop.monto) as monto ,registro.fecha\n"
                        + "from `jhondee`.registro \n"
                        + "INNER JOIN `jhondee`.auxop on registro.id = auxop.nregistro \n"
                        + "INNER JOIN `jhondee`.`" + tabla + "` on registro.id = `" + tabla + "`.registro  \n"
                        + "where `" + tabla + "`.estatus = 'a' \n"
                        + "and  registro.fecha BETWEEN '" + d1.toString() + "' and  '" + d2.toString() + "' \n"
                        + "order by `fecha` desc");
                ResultSet rs = s.executeQuery();
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                while (rs.next()) { 
                    al.add(
                            new MRegistros(rs.getInt("id"), 
                            rs.getString("descripcion"),
                            rs.getFloat("monto"), 
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
        li = (List<MRegistros>) Filtro().clone();
        ta = new tablaRegistro();
        ta.setalmacen((List<MRegistros>) Filtro().clone());
        this.TAlmacen.setModel(ta);
        this.TAlmacen.getColumnModel().getColumn(0).setPreferredWidth(2000);
        this.TAlmacen.getColumnModel().getColumn(1).setPreferredWidth(15000);
        this.TAlmacen.getColumnModel().getColumn(2).setPreferredWidth(2000);
        this.TAlmacen.getColumnModel().getColumn(3).setPreferredWidth(2000);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pdf = new javax.swing.JButton();
        Facturas = new javax.swing.JButton();
        Filtro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Desde = new datechooser.beans.DateChooserCombo();
        Hasta = new datechooser.beans.DateChooserCombo();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAlmacen = new javax.swing.JTable();
        Excel1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Pdf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Pdf.setText("PDF");
        Pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PdfActionPerformed(evt);
            }
        });

        Facturas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Facturas.setText("Facturas");
        Facturas.setPreferredSize(new java.awt.Dimension(45, 45));
        Facturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacturasActionPerformed(evt);
            }
        });

        Filtro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Filtro.setText("Filtrar");
        Filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Hasta");

        Salir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Salir.setText("Salir");
        Salir.setPreferredSize(new java.awt.Dimension(45, 45));
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Desde");

        Desde.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));

        Hasta.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));

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

        Excel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Excel1.setText("EXCEL");
        Excel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Excel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Excel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Facturas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Desde, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(Filtro))
                    .addComponent(Hasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Desde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Excel1)
                    .addComponent(Pdf)
                    .addComponent(Facturas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                PdfPTable table = new PdfPTable(6);
                table.setWidths(new float[]{200, 1500, 200, 200});
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
                Logger.getLogger(Facturas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_PdfActionPerformed

    private void FacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacturasActionPerformed
        int fila = this.TAlmacen.getSelectedRow();
        int t = li.get(fila).getRegistro();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar una Fila", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            new Datos.factura(t, tabla).setVisible(true);
        }
    }//GEN-LAST:event_FacturasActionPerformed

    private void FiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroActionPerformed
        setModeloTabla();
    }//GEN-LAST:event_FiltroActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_SalirActionPerformed

    private void Excel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Excel1ActionPerformed
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
            hoja.setColumnWidth(1, 10000);
            hoja.setColumnWidth(2, 2000);
            hoja.setColumnWidth(3, 2000);
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
    }//GEN-LAST:event_Excel1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo Desde;
    private javax.swing.JButton Excel;
    private javax.swing.JButton Excel1;
    private javax.swing.JButton Facturas;
    private javax.swing.JButton Filtro;
    private datechooser.beans.DateChooserCombo Hasta;
    private javax.swing.JButton Pdf;
    private javax.swing.JButton Salir;
    private javax.swing.JTable TAlmacen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
