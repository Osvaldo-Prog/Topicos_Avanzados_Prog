import java.sql.Connection;
class Main {
    public static void main(String[] args) {
        /*
        String url = "jdbc:mysql://localhost:3306/estudiantes";
        String user = "root";
        String pass = "OsvaldoMySQL2408";
        */
        Connection conexion = ConexionDB.getInstancia().getConexion();
        EstudianteDAO dao = new EstudianteDAOImpl(conexion);

        /*
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            EstudianteDAO dao = new EstudianteDAOImpl(conn);
        */

            // Insertar
            dao.insertar(new Estudiante(0, "Osvaldo2", "osva@gmail.com"));
            //Eliminar
            //dao.eliminar(0);
            //Modidicar
            //dao.actualizar(null);

            // Listar
            for (Estudiante e : dao.listar()) {
                System.out.println(e.getId() + " - " + e.getNombre());
            }
        }
    }

