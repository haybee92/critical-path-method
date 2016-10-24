/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.criticalpah.utils;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Abiola.Adebanjo
 */
public class NodesTableModel extends AbstractTableModel {

    private final List<Node> nodesList;

    private final String[] columnNames = new String[]{
        "Tast", "ET", "LT", "CT"
    };
    private final Class[] columnClass = new Class[]{
        String.class, Integer.class, Integer.class, String.class
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
            case 3:
                return row.getCT();

            default:
                break;
        }
        return null;
    }
}
