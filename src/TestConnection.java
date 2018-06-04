
import java.sql.*;

public class TestConnection {

    private final String dbUser = "root"; //nome utente 
    private final String dbPwd = "21187"; //password utente
    private final String dbDriver = "com.mysql.cj.jdbc.Driver";  //il driver per collegarsi al DB
    private final String dbUrl = "jdbc:mysql://localhost:3306/saldatabase?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"; //url del database e schema
    private Connection conn = null; //si crea una nuova connessione, per adesso nulla
    private boolean openConn = false; //variabile per verificare se la connessione col DB è aperta o meno
    private Statement stmt = null; //creazione di uno Statement, per adesso nullo
    private ResultSet rs = null; //variabile che contiene il risultato dello Statement
   

    public void startConn() { //metodo per inizializzare la connessione
        try {

            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            openConn = true;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean checkConn() {
        return this.openConn;
    }

    public void closeConn() { //metodo per chiudere la connessione
        try {
            conn.close();
            openConn = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getTable() {
        if (!openConn) {
            startConn();

        } else {
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM Invitati");
                System.out.println(String.format("%-25s %-20s %-20s %-4s", "CODICE FISCALE", "NOME", "COGNOME", "ETA'"));
                while (rs.next()) {

                    System.out.println(String.format("%-25s %-20s %-20s %-4d",
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4)));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    public void insertEntry(String cf, String nome, String cognome, int eta){//inserire nuovi valori nella TABLE
        
        if (!openConn) {
            startConn();
        
        } else {
            try {
                              
                String queryEntry = "INSERT INTO Invitati (`CF`, `Nome`, `Cognome`, `Eta`) VALUES ('"+ cf +"','"+ nome +"','"+ cognome +"','"+ eta +"');";
                stmt.executeUpdate(queryEntry);
                                       

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    
    }
    
    public void deleteEntry(String cf){//cancellare dati nella tabella, bisogna passargli come parametro la chiave primaria di essa
        if (!openConn) {
            startConn();
        
        } else {
            try {
                
               
                String queryEntry = "DELETE FROM Invitati WHERE `CF`='"+cf+"'";
                stmt.executeUpdate(queryEntry);
                                       

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    
    
    }
}
