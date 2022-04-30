/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Anime;
import model.Calendario;

/**
 * 
 * @author sidne
 */
public class CalendarioTableModel extends AbstractTableModel {

    private String[] columns = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo"};
    private ArrayList<Calendario> calendario = new ArrayList<Calendario>();

    public int getRowCount() {
        return calendario.size();
    }

    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
    
    
    /*
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (calendario.isEmpty()) {
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();
    }
    */
    /*
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return columnIndex == 1;
    }
     */
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return calendario.get(rowIndex).getSegunda();
            case 1:
                return calendario.get(rowIndex).getTerca();
            case 2:
                return calendario.get(rowIndex).getQuarta();
            case 3:
                return calendario.get(rowIndex).getQuinta();
            case 4:
                return calendario.get(rowIndex).getSexta();
            case 5:
                return calendario.get(rowIndex).getSabado();
            case 6:
                return calendario.get(rowIndex).getDomingo();
            default:
                return "Dado não encontrado";
        }
    }

    /*
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        anime.get(rowIndex).setComplete((boolean) aValue);
    }
     */
    public void addRow(Calendario calendario) {
        this.calendario.add(calendario);
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public ArrayList<Calendario> getEpisodios() {
        return calendario;
    }

    public void setCalendarios(ArrayList<Calendario> calendario) {
        this.calendario = calendario;
    }
}
