package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Episodio;

/**
 *
 * @author Marcio Michelluzzi
 */
public class EpisodioTableModel extends AbstractTableModel {

    private String[] columns = {"Nome", "Assistido", "Excluir"};
    private List<Episodio> epi = new ArrayList<>();

    @Override
    public int getRowCount() {
        return epi.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
    
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (epi.isEmpty()) {
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();
    }
    

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return columnIndex == 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return epi.get(rowIndex).getName();
            case 1:
                return epi.get(rowIndex).isComplete();
            case 2:
                return "";
            default:
                return "Dado não encontrado";
        }
    }

    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        epi.get(rowIndex).setComplete((boolean) aValue);
    }

    
    public void addRow(Episodio task) {
        this.epi.add(task);
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public List<Episodio> getEpisodios() {
        return epi;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.epi = episodios;
    }
}
