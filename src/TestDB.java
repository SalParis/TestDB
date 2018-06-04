/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salvi
 */
public class TestDB {
    
    public static void main(String args[]) {
        TestConnection connetto= new TestConnection();
        System.out.println("Stato della connessione prima del tentativo di connessione: " + connetto.checkConn());
        connetto.startConn();
        System.out.println("Stato della connessione dopo il tentativo di connessione: " + connetto.checkConn());
        connetto.getTable();
        connetto.closeConn();
        System.out.println("Stato della connessione dopo il tentativo di chiusura di essa: " + connetto.checkConn());
    }
    
}
