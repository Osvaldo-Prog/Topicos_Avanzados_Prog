import java.util.List;
import java.sql.*;
import java.util.*;

public class Estudiante {
    private int id;
    private String nombre;
    private String correo;

    // Constructores
    public Estudiante() {}
    public Estudiante(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Getters y Setters
    public int getId() { 
        return id; }

    public void setId(int id) { 
        this.id = id; }

    public String getNombre() { 
        return nombre; }

    public void setNombre(String nombre) { 
        this.nombre = nombre; }

    public String getCorreo() {
         return correo; }

    public void setCorreo(String correo) { 
        this.correo = correo; }
}

//INTERFACE
interface EstudianteDAO {
    void insertar(Estudiante e);
    Estudiante obtenerPorId(int id);
    List<Estudiante> listar();
    void actualizar(Estudiante e);
    void eliminar(int id);
}




class EstudianteDAOImpl implements EstudianteDAO {
    private Connection conn;

    public EstudianteDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Estudiante e) {
        String sql = "INSERT INTO estudiantes (id, nombre, correo) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, e.getId());
            stmt.setString(2, e.getNombre());
            stmt.setString(3, e.getCorreo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Estudiante obtenerPorId(int id) {
        String sql = "SELECT * FROM estudiantes WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estudiante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Estudiante> listar() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Estudiante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(lista);
        return lista;
    }

    @Override
    public void actualizar(Estudiante e) {
        String sql = "UPDATE estudiantes SET nombre=?, correo=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getCorreo());
            stmt.setInt(3, e.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM estudiantes WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}