/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.criticalpah.utils;

import java.util.Comparator;

/**
 *
 * @author Abiola.Adebanjo
 */
public class Node {

    private int id;
    private int ET;
    private int LT;
    private int CT;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getET() {
        return ET;
    }

    public void setET(int ET) {
        this.ET = ET;
    }

    public int getLT() {
        return LT;
    }

    public void setLT(int LT) {
        this.LT = LT;
    }

    public void setCT(int CT) {
        this.CT = CT;
    }

    public int getCT() {
        return CT;
    }

    public static Comparator<Node> desComp = new Comparator<Node>() {

        public int compare(Node n1, Node n2) {
            /*For descending order*/
            return n2.getId() - n1.getId();
        }
    };
    public static Comparator<Node> ascComp = new Comparator<Node>() {

        public int compare(Node n1, Node n2) {
            /*For ascending order*/
            return n1.getId() - n2.getId();
        }
    };

}
