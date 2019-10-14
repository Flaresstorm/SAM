package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas extends Conexion {

    public boolean registrar(Usuario pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO producto (Cedula, Nombre, Cargo, Descripcion) VALUES(?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCedula());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getCargo());
            ps.setString(4, pro.getDescripcion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar(Usuario pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE producto SET Cedula=?, Nombre=?, Cargo=?, Descripcion=? WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCedula());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getCargo());
            ps.setString(4, pro.getDescripcion());
            ps.setInt(5, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Usuario pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM producto WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean buscar(Usuario pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM producto WHERE Cedula=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCedula());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
               pro.setId( Integer.parseInt(rs.getString("id")));
               pro.setCedula(rs.getString("Cedula"));
               pro.setNombre(rs.getString("Nombre"));
               pro.setCargo(rs.getString("Cargo"));
               pro.setDescripcion(rs.getString("Descripcion"));
               return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
