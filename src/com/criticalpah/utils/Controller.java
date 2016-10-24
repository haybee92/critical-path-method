/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.criticalpah.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Abiola.Adebanjo
 */
public class Controller {

    public static List<Node> computeET(List<Node> nodesList, List<Links> listOfLinks) {
        for (Node node : nodesList) {
            if (node.getId() == 1) {
                node.setET(0);
            } else {
                node.setET(getET(node.getId(), nodesList, listOfLinks));
            }
        }

        System.out.println("ET>>> " + nodesList);
        return nodesList;
    }

    public static int getET(int nodeId, List<Node> nodesList, List<Links> listOfLinks) {
        List<Integer> ET = new ArrayList();
        List<Links> connectedLinks = getConnectedETLinks(nodeId, listOfLinks);
        for (Links links : connectedLinks) {
            Node node = getNode(links.getFromNode(), nodesList);
            int tempET = node.getET() + links.getTime();
            ET.add(tempET);
        }

        return Collections.max(ET);
    }

    public static List<Links> getConnectedETLinks(int nodeId, List<Links> listOfLinks) {
        List<Links> tempList = new ArrayList<>();
        for (Links links : listOfLinks) {
            if (links.getToNode() == nodeId) {
                tempList.add(links);
            }
        }
        return tempList;
    }

    public static List<Node> computeLT(List<Node> nodesList, List<Links> listOfLinks) {
        Collections.sort(nodesList, Node.desComp);
        for (Node node : nodesList) {
            if (node.getId() == nodesList.size()) {
                node.setLT(node.getET());
            } else {
                node.setLT(getLT(node.getId(), nodesList, listOfLinks));
            }
        }

        Collections.sort(nodesList, Node.ascComp);
        System.out.println("LT>>> " + nodesList);
        return nodesList;
    }

    public static int getLT(int nodeId, List<Node> nodesList, List<Links> listOfLinks) {
        List<Integer> LT = new ArrayList();
        List<Links> connectedLinks = getConnectedLTLinks(nodeId, listOfLinks);
        for (Links links : connectedLinks) {
            Node node = getNode(links.getToNode(), nodesList);
            int tempLT = node.getLT() - links.getTime();
            LT.add(tempLT);
        }

        return Collections.min(LT);
    }

    public static List<Links> getConnectedLTLinks(int nodeId, List<Links> listOfLinks) {
        List<Links> tempList = new ArrayList<>();
        for (Links links : listOfLinks) {
            if (links.getFromNode() == nodeId) {
                tempList.add(links);
            }
        }
        return tempList;
    }

    public static Node getNode(int id, List<Node> nodesList) {
        for (Node node : nodesList) {
            if (node.getId() == id) {
                return node;
            }
        }

        return null;
    }

    public static List<Node> assignCRT(List<Node> nodesList, List<Links> listOfLinks) {
        for (Links links : listOfLinks) {
            if (!links.getCRT().equalsIgnoreCase("-")) {
                Node node = getNode(links.getToNode(), nodesList);
                node.setCT(links.getCRT());
            }
        }

        System.out.println("CRT>>>" + nodesList);
        return nodesList;
    }
}
