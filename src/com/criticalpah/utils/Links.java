/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.criticalpah.utils;

/**
 *
 * @author Abiola.Adebanjo
 */
public class Links {

    private int id;
    private int fromNode;
    private int toNode;
    private String symbol;
    private int time;
    private String CRT;

    public Links(int id, int fromNode, int toNode, String symbol, int time, String CRT) {
        this.id = id;
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.symbol = symbol;
        this.time = time;
        this.CRT = CRT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromNode() {
        return fromNode;
    }

    public void setFromNode(int fromNode) {
        this.fromNode = fromNode;
    }

    public int getToNode() {
        return toNode;
    }

    public void setToNode(int toNode) {
        this.toNode = toNode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getCRT() {
        return CRT;
    }

    public void setCRT(String CRT) {
        this.CRT = CRT;
    }
}
