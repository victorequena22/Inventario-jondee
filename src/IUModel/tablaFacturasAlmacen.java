/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUModel;

import Modelos.CV;
import Modelos.Contactos;
import Modelos.Operacion;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author victo
 */
public class tablaFacturasAlmacen extends AbstractTableModel implements TableModel {

    private final Class[] tipoColumnas;
    private final String[] titleColumnas;
    private List<CV> almacen;
    
    public tablaFacturasAlmacen(String titulo) {
        this.titleColumnas = new String[]{"N/Registro", "N/Factura", titulo, "Descripcion", "cantidad", "Precio/U", "Fecha"};
        this.tipoColumnas = new Class[]{Integer.class, Integer.class, String.class, String.class, Float.class, Float.class, String.class};
        almacen = new ArrayList();
    }

    
    /**
     *
     * @param al
     */
    public void setalmacen(List<CV> al) {
        this.almacen = al;
    }

    public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
        /**
         * Observen que todo lo que hacemos en éste método es retornar el objeto
         * que se va a dibujar en la celda. Esto significa que se dibujará en la
         * celda el objeto que devuelva el TableModel. También significa que
         * este renderer nos permitiría dibujar cualquier objeto gráfico en la
         * grilla, pues retorna el objeto tal y como lo recibe.
         */
        return (Component) objeto;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
        // observen que estamos retornando la clase que definimos de antemano.
        return this.tipoColumnas[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
        return true;
    }

    @Override
    public String getColumnName(int column) {
        return titleColumnas[column];
    }

    @Override
    public int getRowCount() {
        return almacen.size();
    }

    @Override
    public int getColumnCount() {
        return titleColumnas.length;
    }

    @Override
    @SuppressWarnings("empty-statement")
    public Object getValueAt(int rowIndex, int columnIndex) {
        //Rellenamos la celda
        switch (columnIndex) {
            case 0:
                return almacen.get(rowIndex).getRegistro();
            case 1:
                return almacen.get(rowIndex).getCod();
            case 2:
                return almacen.get(rowIndex).getNombre();
            case 3:
                return almacen.get(rowIndex).getDes();
            case 4:
                return almacen.get(rowIndex).getCant();
            case 5:
                return almacen.get(rowIndex).getMonto();
            case 6:
                Date today;
                String result;
                SimpleDateFormat formatter;
                formatter = new SimpleDateFormat("dd-MM-yyyy");
                today =  almacen.get(rowIndex).getFecha();
                result = formatter.format(today);
                return result;
            default:
                return null;
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //Recuperamos de la celda
        switch (columnIndex) {
            case 0:
                almacen.get(rowIndex).setRegistro((short) aValue);
            case 1:
                almacen.get(rowIndex).setCod((int) aValue);
            case 2:
                almacen.get(rowIndex).setNombre(aValue.toString());
            case 3:
                almacen.get(rowIndex).setDes(aValue.toString());
            case 4:
                almacen.get(rowIndex).setCant((float) aValue);
            case 5:
                almacen.get(rowIndex).setMonto((float) aValue);
            case 6:
                almacen.get(rowIndex).setFecha(aValue.toString());
            default:
                ;
        }
        this.fireTableCellUpdated(rowIndex, columnIndex);
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
}
