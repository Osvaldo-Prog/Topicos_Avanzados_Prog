import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionDB {
    //Declaracion de la instancia
    private static ConexionDB instancia;
    private Connection conexion;
    private final String url = "jdbc:mysql://localhost:3306/estudiantes";
    private final String user = "root";
    private final String pass = "OsvaldoMySQL2408";

    // Constructor privado para evitar instancia externa
    private ConexionDB() {
        try {
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Metodo para obtener la unica instancia
    public static ConexionDB getInstancia(){
        if(instancia == null){
            instancia = new ConexionDB();
        }
        return instancia;
    }

    public Connection getConexion(){
        return conexion;
    }
}
