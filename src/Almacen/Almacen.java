/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacen;

import Modelos.Categorias;
import Datos.Buscar;
import Modelos.MAlmacen;
import IUModel.tablaAlmacen;
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
import java.awt.Color;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author victo
 */
public class Almacen extends javax.swing.JFrame {

    int x, y;
    tablaAlmacen ta;
    ArrayList<MAlmacen> li;
    String e;
    ArrayList<Categorias> d;

    /**
     * Creates new form Almacen
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Codigo = new javax.swing.JTextField();
        BCodigo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Descripcion = new javax.swing.JTextField();
        BDes = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Filtros = new javax.swing.JComboBox<>();
        Filtrar = new javax.swing.JButton();
        Minimo = new javax.swing.JButton();
        Mini = new javax.swing.JTextField();
        categoria = new javax.swing.JButton();
        producto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Excel = new javax.swing.JButton();
        Pdf = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Entradas = new javax.swing.JButton();
        Salidas = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ListaCompras = new javax.swing.JButton();
        Salidas1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        entradas = new javax.swing.JButton();
        salidas = new javax.swing.JButton();
        Ventas = new javax.swing.JButton();
        Compras = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        Entradas1 = new javax.swing.JButton();
        Salidas2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        ListaCompras1 = new javax.swing.JButton();
        Salidas3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Almacen = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(120, 240, 240));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Codigo");

        Codigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Codigo.setPreferredSize(new java.awt.Dimension(100, 20));

        BCodigo.setText("Codigo");
        BCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCodigoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Busquedas");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Descripcion");

        Descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Descripcion.setPreferredSize(new java.awt.Dimension(100, 30));

        BDes.setText("Descripcion");
        BDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BDes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCodigo)
                    .addComponent(BDes))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Oreganizar");

        Filtros.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Filtrar.setText("Filtrar");
        Filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarActionPerformed(evt);
            }
        });

        Minimo.setText("Asignar minimo");
        Minimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinimoActionPerformed(evt);
            }
        });

        Mini.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Mini.setPreferredSize(new java.awt.Dimension(100, 30));

        categoria.setText("Crear categoria");
        categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaActionPerformed(evt);
            }
        });

        producto.setText("Nuevo Producto");
        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(producto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Filtros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Filtrar))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Minimo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Mini, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Filtrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Mini, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Minimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(producto)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Exportar");

        Excel.setText("EXCEL");
        Excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcelActionPerformed(evt);
            }
        });

        Pdf.setText("PDF");
        Pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Excel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pdf, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Excel)
                    .addComponent(Pdf))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Entradas.setText("Entadas");
        Entradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradasActionPerformed(evt);
            }
        });

        Salidas.setText("Salidas");
        Salidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalidasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Reporte de Producto");

        ListaCompras.setText("Compras");
        ListaCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaComprasActionPerformed(evt);
            }
        });

        Salidas1.setText("Ventas");
        Salidas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salidas1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Entradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Salidas, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ListaCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Salidas1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Entradas)
                    .addComponent(Salidas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ListaCompras)
                    .addComponent(Salidas1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Registrar");

        entradas.setText("Entrada");
        entradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradasActionPerformed(evt);
            }
        });

        salidas.setText("Salida");
        salidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salidasActionPerformed(evt);
            }
        });

        Ventas.setText("Venta");
        Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentasActionPerformed(evt);
            }
        });

        Compras.setText("Compra");
        Compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Ventas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(entradas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Compras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entradas)
                    .addComponent(salidas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ventas)
                    .addComponent(Compras))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Entidades");

        jButton8.setText("clientes");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setText("proveedores");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Usuarios");

        jButton1.setText("Usuarios");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Entradas1.setText("Entadas");
        Entradas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Entradas1ActionPerformed(evt);
            }
        });

        Salidas2.setText("Salidas");
        Salidas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salidas2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Reporte Generales");

        ListaCompras1.setText("Compras");
        ListaCompras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaCompras1ActionPerformed(evt);
            }
        });

        Salidas3.setText("Ventas");
        Salidas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salidas3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(Entradas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Salidas2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(ListaCompras1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Salidas3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Entradas1)
                    .addComponent(Salidas2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ListaCompras1)
                    .addComponent(Salidas3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Almacen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Almacen.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Almacen);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDesActionPerformed
        String t;
        t = Descripcion.getText();
        if (!"".equals(t)) {
            new Buscar(t).setVisible(true);
        }
    }//GEN-LAST:event_BDesActionPerformed

    private void ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcelActionPerformed
        JFileChooser seleccionar = new JFileChooser();
        File archivo;
        if (seleccionar.showDialog(null, "Exportar Excel") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            int cantFila = Almacen.getRowCount();
            int cantColumna = Almacen.getColumnCount();
            Workbook wb;
            wb = new XSSFWorkbook();
            Sheet hoja = wb.createSheet("  ");
            hoja.setColumnWidth(0, 2000);
            hoja.setColumnWidth(1, 15000);
            hoja.setColumnWidth(2, 2000);
            try {
                for (int i = -1; i < cantFila; i++) {
                    Row fila = hoja.createRow(i + 1);

                    for (int j = 0; j < cantColumna; j++) {
                        Cell celda = fila.createCell(j);
                        if (i == -1) {
                            celda.setCellValue(String.valueOf(Almacen.getColumnName(j)));
                        } else {
                            celda.setCellValue(String.valueOf(Almacen.getValueAt(i, j)));
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
                FileOutputStream ficheroPdf = new FileOutputStream(fichero + ".pdf");
                PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
                PdfPTable table = new PdfPTable(3);
                documento.open();
                table.setWidths(new float[]{250, 1500, 250});
                for (int i = 0; i < Almacen.getColumnCount(); i++) {
                    table.addCell(Almacen.getColumnName(i));
                }
                for (int rows = 0; rows < Almacen.getRowCount(); rows++) {
                    for (int cols = 0; cols < Almacen.getColumnCount(); cols++) {
                        table.addCell(Almacen.getModel().getValueAt(rows, cols).toString());
                    }
                }
                documento.add(table);
                documento.close();
            } catch (DocumentException | FileNotFoundException ex) {
                Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_PdfActionPerformed

    private void EntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradasActionPerformed
        int fila = this.Almacen.getSelectedRow();
        int cod;
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar una Fila", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            cod = li.get(fila).getCod();
            new ListaFacturas(cod, "compras", "proveedores").setVisible(true);
        }
    }//GEN-LAST:event_EntradasActionPerformed

    private void FiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarActionPerformed
        ta = new tablaAlmacen();
        String t = (String) Filtros.getSelectedItem();
        switch (t) {
            case "-Telas":
                li = (ArrayList<MAlmacen>) getFiltro(100000, 200000).clone();
                break;
            case "-Accesorios":
                li = (ArrayList<MAlmacen>) getFiltro(200000, 300000).clone();
                break;
            case "-Consumibles":
                li = (ArrayList<MAlmacen>) getFiltro(300000, 400000).clone();
                break;
            case "-Mercancia":
                li = (ArrayList<MAlmacen>) getFiltro(400000, 500000).clone();
                break;
            case "Todos":
                li = (ArrayList<MAlmacen>) getTodos().clone();
                break;
            default:
                long k;
                long w;
                for (Categorias i : d) {
                    String f = (String) Filtros.getSelectedItem();
                    if (f == null ? i.getCat() == null : f.equals(i.getCat())) {
                        k = i.getCod();
                        w = k + 1000;
                        li = (ArrayList<MAlmacen>) getFiltro(k, w).clone();
                        break;
                    }
                }
        }
        ta.setalmacen((List<MAlmacen>) li.clone());
        this.Almacen.setModel(ta);
        this.Almacen.setRowHeight(15);
        this.Almacen.getColumnModel().getColumn(0).setPreferredWidth(250);
        this.Almacen.getColumnModel().getColumn(1).setPreferredWidth(1500);
        this.Almacen.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.Almacen.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.Almacen.getColumnModel().getColumn(4).setPreferredWidth(250);
        row();
    }//GEN-LAST:event_FiltrarActionPerformed

    private void BCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCodigoActionPerformed
        String t;
        t = Codigo.getText();
        int i;
        if (t != "") {
            int p = Integer.parseInt(t);
            for (i = 0; i < li.size(); i++) {
                if (p == li.get(i).getCod()) {
                    Almacen.getSelectionModel().setSelectionInterval(i, i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_BCodigoActionPerformed

    private void SalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalidasActionPerformed
        int fila = this.Almacen.getSelectedRow();
        int cod;
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar una Fila", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            cod = li.get(fila).getCod();
            //new ListaRegistro(cod, "salidas").setVisible(true);
            new ListaFacturas(cod, "ventas", "clientes").setVisible(true);
        }
    }//GEN-LAST:event_SalidasActionPerformed

    private void MinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinimoActionPerformed
        int fila = this.Almacen.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar una Fila", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            minimo();
        }

    }//GEN-LAST:event_MinimoActionPerformed

    private void ListaComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaComprasActionPerformed
        int fila = this.Almacen.getSelectedRow();
        int cod;
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar una Fila", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            cod = li.get(fila).getCod();
            new ListaRegistro(cod, "entradas").setVisible(true);
        }
    }//GEN-LAST:event_ListaComprasActionPerformed

    private void Salidas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salidas1ActionPerformed
        int fila = this.Almacen.getSelectedRow();
        int cod;
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar una Fila", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            cod = li.get(fila).getCod();
            new ListaRegistro(cod, "salidas").setVisible(true);
        }
    }//GEN-LAST:event_Salidas1ActionPerformed

    private void categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaActionPerformed
        new Ajustes.Nuevo_Categoria().setVisible(true);
    }//GEN-LAST:event_categoriaActionPerformed

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed
        new Ajustes.Nuevo_Producto().setVisible(true);
    }//GEN-LAST:event_productoActionPerformed

    private void entradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradasActionPerformed
        new Ajustes.Entradas().setVisible(true);
    }//GEN-LAST:event_entradasActionPerformed

    private void salidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salidasActionPerformed
        new Ajustes.Salidas().setVisible(true);
    }//GEN-LAST:event_salidasActionPerformed

    private void VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentasActionPerformed
        new Operaciones.Venta().setVisible(true);
    }//GEN-LAST:event_VentasActionPerformed

    private void ComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprasActionPerformed
        new Operaciones.Compra().setVisible(true);
    }//GEN-LAST:event_ComprasActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new Entidades.Proveedores("clientes").setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new Entidades.Proveedores("proveedores").setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void Entradas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Entradas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Entradas1ActionPerformed

    private void Salidas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salidas2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Salidas2ActionPerformed

    private void ListaCompras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaCompras1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListaCompras1ActionPerformed

    private void Salidas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salidas3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Salidas3ActionPerformed

    public Almacen() {
        initComponents();
        setExtendedState(this.MAXIMIZED_BOTH);
        setModeloTabla();
        d = (ArrayList<Categorias>) Categotias().clone();
    }

    public ArrayList<MAlmacen> getTodos() {
        ArrayList<MAlmacen> al;
        al = new ArrayList();
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (
                    com.mysql.jdbc.Connection conexion = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                com.mysql.jdbc.PreparedStatement s = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement("select * from almacen where cantidad > 0 ORDER BY descripcion ASC");
                ResultSet rs = s.executeQuery();
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                while (rs.next()) {
                    al.add(new MAlmacen(rs.getInt("codigo"), rs.getString("descripcion"), rs.getFloat("cantidad"), rs.getFloat("monto"), rs.getFloat("minimo")));
                }
                // Se cierra la conexión con la base de datos.
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
        return al;
    }

    private void setModeloTabla() {
        ta = new tablaAlmacen();
        ta.setalmacen((List<MAlmacen>) getTodos().clone());
        li = (ArrayList<MAlmacen>) getTodos().clone();
        this.Almacen.setModel(ta);
        this.Almacen.setRowHeight(15);
        this.Almacen.getColumnModel().getColumn(0).setPreferredWidth(250);
        this.Almacen.getColumnModel().getColumn(1).setPreferredWidth(1500);
        this.Almacen.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.Almacen.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.Almacen.getColumnModel().getColumn(4).setPreferredWidth(250);
        row();

    }

    private void minimo() {
        {
            try {
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost/jhondee";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
                // the mysql insert statement
                String query = "UPDATE `jhondee`.`almacen`SET"
                        + " `minimo` = " + Mini.getText()
                        + " WHERE `codigo` = " + li.get(Almacen.getSelectedRow()).getCod();
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.execute();
                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }
    }

    private ArrayList<Categorias> Categotias() {
        ArrayList<Categorias> al;
        al = new ArrayList();
        String t;
        int p = 0;
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                PreparedStatement s = conexion.prepareStatement("SELECT `categorias`.`cod`,`categorias`.`nombre`FROM `jhondee`.`categorias` order by `cod` asc");
                ResultSet rs = s.executeQuery();
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                while (rs.next()) {
                    al.add(new Categorias(rs.getString("nombre"), rs.getInt("cod")));
                    t = al.get(p).getCat();
                    Filtros.addItem(t);
                    p++;
                }
                // Se cierra la conexión con la base de datos.
            }
        } catch (SQLException e) {
        }
        return al;
    }

    public ArrayList<MAlmacen> getFiltro(long f1, long f2) {
        ArrayList<MAlmacen> al;
        al = new ArrayList();
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                PreparedStatement s = conexion.prepareStatement("select * from almacen where codigo > " + f1 + " and codigo < " + f2 + " ORDER BY descripcion ASC");
                ResultSet rs = s.executeQuery();
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                while (rs.next()) {
                    al.add(new MAlmacen(rs.getInt("codigo"), rs.getString("descripcion"), rs.getFloat("cantidad"), rs.getFloat("monto"), rs.getFloat("minimo")));
                }
                // Se cierra la conexión con la base de datos.
            }
        } catch (SQLException e) {
        }
        return al;
    }

    boolean salidas(int c) {
        boolean t = false;
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                PreparedStatement s = conexion.prepareStatement("SELECT count(*) as c from jhondee.auxop inner join `salidas` on `salidas`.registro = `auxop`.nregistro where `auxop`.codalmacen=" + c);
                ResultSet rs = s.executeQuery();
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                rs.next();
                if (rs.getInt("c") > 0) {
                    t = true;
                }
                // Se cierra la conexión con la base de datos.
            }
        } catch (SQLException e) {
        }
        return t;
    }

    boolean compras(int c) {
        boolean t = false;
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                PreparedStatement s = conexion.prepareStatement("SELECT count(*) as c FROM jhondee.auxop inner join `compras` on `compras`.registro = `auxop`.nregistro where `auxop`.codalmacen =" + c);
                ResultSet rs = s.executeQuery();
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                rs.next();
                if (rs.getInt("c") > 0) {
                    t = true;
                }
                // Se cierra la conexión con la base de datos.
            }
        } catch (SQLException e) {
        }
        return t;
    }

    boolean entradas(int c) {
        boolean t = false;
        int p = 0;
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                PreparedStatement s = conexion.prepareStatement("SELECT count(*) as c FROM jhondee.auxop inner join `entradas` on `entradas`.registro = `auxop`.nregistro where `auxop`.codalmacen=" + c);
                ResultSet rs = s.executeQuery();
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                rs.next();
                if (rs.getInt("c") > 0) {
                    t = true;
                }
                // Se cierra la conexión con la base de datos.
            }
        } catch (SQLException e) {
        }
        return t;
    }

    boolean ventas(int c) {
        boolean t = false;
        int p = 0;
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            try (
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jhondee", "root", "1234")) {
                PreparedStatement s = conexion.prepareStatement("SELECT count(*) as c FROM jhondee.auxop inner join `ventas` on `ventas`.registro = `auxop`.nregistro where `auxop`.codalmacen=" + c);
                ResultSet rs = s.executeQuery();
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                rs.next();
                rs.next();
                if (rs.getInt("c") > 0) {
                    t = true;
                };
                // Se cierra la conexión con la base de datos.
            }
        } catch (SQLException e) {
        }
        if (p > 0) {
            t = true;
        }
        return t;
    }

    void row() {
        Almacen.setRowHeight(15);
        Almacen.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());
        Almacen.getColumnModel().getColumn(1).setCellRenderer(new CustomRenderer());
        Almacen.getColumnModel().getColumn(2).setCellRenderer(new CustomRenderer());
        Almacen.getColumnModel().getColumn(3).setCellRenderer(new CustomRenderer());
        Almacen.getColumnModel().getColumn(4).setCellRenderer(new CustomRenderer());

    }

    class CustomRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 6703872492730589499L;

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            float a, b;
            a = li.get(row).getCant();
            b = li.get(row).getMinimo();
            if (a < b) {
                cellComponent.setBackground(Color.RED);
                cellComponent.setForeground(Color.GREEN);
            } else {
                cellComponent.setBackground(Color.WHITE);
                cellComponent.setForeground(Color.BLACK);
            }
            int fila = Almacen.getSelectedRow();
            if (row == fila) {
                cellComponent.setBackground(Color.BLUE);
                cellComponent.setForeground(Color.WHITE);
            }
            return cellComponent;

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Almacen;
    private javax.swing.JButton BCodigo;
    private javax.swing.JButton BDes;
    private javax.swing.JTextField Codigo;
    private javax.swing.JButton Compras;
    private javax.swing.JTextField Descripcion;
    private javax.swing.JButton Entradas;
    private javax.swing.JButton Entradas1;
    private javax.swing.JButton Excel;
    private javax.swing.JButton Filtrar;
    private javax.swing.JComboBox<String> Filtros;
    private javax.swing.JButton ListaCompras;
    private javax.swing.JButton ListaCompras1;
    private javax.swing.JTextField Mini;
    private javax.swing.JButton Minimo;
    private javax.swing.JButton Pdf;
    private javax.swing.JButton Salidas;
    private javax.swing.JButton Salidas1;
    private javax.swing.JButton Salidas2;
    private javax.swing.JButton Salidas3;
    private javax.swing.JButton Ventas;
    private javax.swing.JButton categoria;
    private javax.swing.JButton entradas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton producto;
    private javax.swing.JButton salidas;
    // End of variables declaration//GEN-END:variables
}
