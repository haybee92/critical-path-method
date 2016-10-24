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
public class LinksTableModel extends AbstractTableModel {

    private final List<Links> listOfLinks;

    private final String[] columnNames = new String[]{
        "Id", "From Node", "To Node", "Symbol", "Time", "CRT"
    };
    private final Class[] columnClass = new Class[]{
        Integer.class, Integer.class, Integer.class, String.class, Integer.class, String.class
    };

    public LinksTableModel(List<Links> listOfLinks) {
        this.listOfLinks = listOfLinks;
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
        return listOfLinks.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Links row = listOfLinks.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return row.getId();
            case 1:
                return row.getFromNode();
            case 2:
                return row.getToNode();
            case 3:
                return row.getSymbol();
            case 4:
                return row.getTime();
            case 5:
                return row.getCRT();
            default:
                break;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return !(columnIndex == 0 || columnIndex == 3);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Links row = listOfLinks.get(rowIndex);
        switch (columnIndex) {
            case 0:
                row.setId((Integer) aValue);
                break;
            case 1:
                row.setFromNode((Integer) aValue);
                break;
            case 2:
                row.setToNode((Integer) aValue);
                break;
            case 3:
                row.setSymbol((String) aValue);
                break;
            case 4:
                row.setTime((Integer) aValue);
                break;
            case 5:
                row.setCRT((String) aValue);
                break;
            default:
                break;
        }
    }

    public void insertRow(Links links) {
        listOfLinks.add(links);
        fireTableRowsInserted(0, listOfLinks.size());
    }
}
