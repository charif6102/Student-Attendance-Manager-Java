package com.prjrmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.prjrmi.dao.StudentManagerImpl;



/**
 * Hello world!
 *
 */
public class App 
{public static void main(String[] args) {
        try {
           

            String dbUrl = "jdbc:sqlite:D:/rmiroot/sqllite/charif.db";
           /*String user = "carmdm001";
            String password = "carmdm001";
            Class.forName("org.postgresql.Driver");   */

            StudentManagerImpl obj = new StudentManagerImpl(dbUrl);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("StudentManager", obj);

            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            System.err.println("Erreur serveur: " + e.toString());
            e.printStackTrace();
        }
    }
}
