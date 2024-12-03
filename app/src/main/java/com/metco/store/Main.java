
package com.metco.store;

import java.sql.Connection;
public class Main {
    public static void main(String[] args) {

        Connection conn = connectDB.connect();

        if (conn != null){
            System.out.println("Connected to Database!");
            connectDB.disconnect(conn);
        }

        //new GUIMangement();
        new InventoryManagement();
    }
}

