/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.criticalpah.utils;

import java.awt.Color;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Abiola.Adebanjo
 */
public class NodesTableModel extends AbstractTableModel {

    List<Color> rowColours = Arrays.asList(
            Color.RED,
            Color.GREEN
    );

    public void setRowColour(int row, Color c) {
        rowColours.set(row, c);
        fireTableRowsUpdated(row, row);
    }

    public Color getRowColour(int row) {
        return rowColours.get(row);
    }

    private final List<Node> nodesList;

    private final String[] columnNames = new String[]{
        "Node", "ET", "LT"
    };
    private final Class[] columnClass = new Class[]{
        String.class, Integer.class, Integer.class
    };

    public NodesTableModel(List<Node> nodesList) {
        this.nodesList = nodesList;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return nodesList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Node row = nodesList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return row.getId();
            case 1:
                return row.getET();
            case 2:
                return row.getLT();

            default:
                break;
        }
        return null;
    }
}

class BoardTableCellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int col) {

        Component c = super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, col);
        
        
        Object valueAt = table.getModel().getValueAt(row, col);
        String s = "";
        if (valueAt != null) {
            s = valueAt.toString();
        }

        if (s.equalsIgnoreCase("yellow")) {
            c.setForeground(Color.YELLOW);
            c.setBackground(Color.gray);
        } else {
            c.setForeground(Color.black);
            c.setBackground(Color.WHITE);
        }

        return c;
    }
}
