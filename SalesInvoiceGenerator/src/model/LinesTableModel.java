package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ali
 */

    public class LinesTableModel extends AbstractTableModel {

        private ArrayList<Lines> lines;
        private String[] columns = {"No.", "Item Name", "Item Price", "Count", "Item Total"};
        
        

        public LinesTableModel(ArrayList<Lines> lines) {
            this.lines = lines;
        }

        
        
        public ArrayList<Lines> getLines() {
            return lines;
        }

                

        @Override
        public int getRowCount() {
            return lines.size();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        
        
        @Override
        public String getColumnName(int column) {
            return columns[column];
        }

        
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Lines lLine = lines.get(rowIndex);

            switch(columnIndex) {
                case 0: return lLine.getInvoice().getNumber();
                case 1: return lLine.getItem();
                case 2: return lLine.getPrice();
                case 3: return lLine.getCount();
                case 4: return lLine.getLineTotal();
                default : return " ";
            }
        }

    }
