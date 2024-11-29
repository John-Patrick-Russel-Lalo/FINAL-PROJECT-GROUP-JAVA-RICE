
package com.metco.store;

import java.sql.Connection;
public class GUIMain {
    public static void main(String[] args) {

        Connection conn = Inventory.connect();

        if (conn != null){
            System.out.println("Connected to Database!");
            Inventory.disconnect(conn);
        }

        //new GUIMangement();
        new InventoryManagement();
    }
}

