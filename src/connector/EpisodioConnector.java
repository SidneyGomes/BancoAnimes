/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Anime;
import model.Episodio;
import util.ConnectionFactory;

/**
 *
 * @author sidne
 */
public class EpisodioConnector {
    
    public void save(Episodio episodio) throws SQLException {
        String sql = "INSERT INTO EPISODIOS(IDANIME, NAME, ASSISTIDO) VALUES (?, ?, ?) ";

        Connection conn = null;
        PreparedStatement std = null;

        try {
            conn = ConnectionFactory.getConnection();
            std = conn.prepareStatement(sql);
            
            
            std.setInt(1, episodio.getIdAnime());
            std.setString(2, episodio.getName());
            std.setBoolean(3, episodio.isComplete());

            std.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao salvar");
        } finally {
            ConnectionFactory.closeConnection(conn, std);
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM EPISODIOS WHERE ID = ?";

        Connection conn = null;
        PreparedStatement std = null;

        try {
            conn = ConnectionFactory.getConnection();
            std = conn.prepareStatement(sql);
            std.setInt(1, id);
            std.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar");
        } finally {
            ConnectionFactory.closeConnection(conn, std);
        }
    }

    public void update(Episodio episodio) throws SQLException {

        String sql = "UPDATE EPISODIOS SET IDANIME = ?, NAME = ?, ASSISTIDO = ? WHERE ID = ?";

        Connection conn = null;
        PreparedStatement std = null;

        try {
            conn = ConnectionFactory.getConnection();
            std = conn.prepareStatement(sql);
            
            std.setInt(1, episodio.getIdAnime());
            std.setString(2, episodio.getName());
            std.setBoolean(3, episodio.isComplete());
            std.setInt(4, episodio.getId());
         
            std.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao salvar");
        } finally {
            ConnectionFactory.closeConnection(conn, std);
        }
    }

    public ArrayList<Episodio> getAll(int id) throws SQLException {
        String sql = "SELECT * FROM EPISODIOS WHERE IDANIME = ?";
        ArrayList<Episodio> listaEpisodio = new ArrayList<Episodio>();

        Connection conn = null;
        PreparedStatement std = null;
        ResultSet result = null;

        try {
            conn = ConnectionFactory.getConnection();
            std = conn.prepareStatement(sql);
            std.setInt(1, id);
            
            result = std.executeQuery();
            
            
            while(result.next()){
                Episodio episodio = new Episodio();
                
                episodio.setIdAnime(result.getInt("IDANIME"));
                episodio.setId(result.getInt("ID"));
                episodio.setName(result.getString("NAME"));
                episodio.setComplete(result.getBoolean("ASSISTIDO"));
                
                listaEpisodio.add(episodio);
            }
             
        } catch (SQLException e) {
            throw new SQLException("Erro ao pegar tudo");
        } finally {
            ConnectionFactory.closeConnection(conn, std, result);
        }
        
        return listaEpisodio;
        
    }
}
