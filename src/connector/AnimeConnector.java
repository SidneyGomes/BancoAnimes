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
import util.ConnectionFactory;

/**
 *
 * @author sidne
 */
public class AnimeConnector {

    public void save(Anime anime) throws SQLException {
        String sql = "INSERT INTO ANIMES(ID, NAME, QTDEPISODIOS, LINK, IMAGE) VALUES (?, ?, ?, ?, ?) ";

        Connection conn = null;
        PreparedStatement std = null;

        try {
            conn = ConnectionFactory.getConnection();
            std = conn.prepareStatement(sql);

            std.setInt(1, anime.getId());
            std.setString(2, anime.getName());
            std.setInt(3, anime.getQtdEpisodios());
            std.setString(4, anime.getLink());
            std.setString(5, anime.getImage());

            std.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao salvar");
        } finally {
            ConnectionFactory.closeConnection(conn, std);
        }
    }

    public void delete(Anime anime) throws SQLException {
        String sql = "DELETE FROM ANIMES WHERE ID = ?";

        Connection conn = null;
        PreparedStatement std = null;

        try {
            conn = ConnectionFactory.getConnection();
            std = conn.prepareStatement(sql);
            std.setInt(1, anime.getId());
            std.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar");
        } finally {
            ConnectionFactory.closeConnection(conn, std);
        }
    }

    public void update() {

        //not now
    }

    public ArrayList<Anime> getAll() throws SQLException {
        String sql = "SELECT * FROM ANIMES";
        ArrayList<Anime> listaAnimes = new ArrayList<Anime>();

        Connection conn = null;
        PreparedStatement std = null;
        ResultSet result = null;

        try {
            conn = ConnectionFactory.getConnection();
            std = conn.prepareStatement(sql);
            result = std.executeQuery();
            while (result.next()) {
                Anime animes = new Anime();

                animes.setId(result.getInt("ID"));
                animes.setName(result.getString("NAME"));
                animes.setQtdEpisodios(result.getInt("QTDEPISODIOS"));
                animes.setLink(result.getString("LINK"));
                animes.setImage(result.getString("IMAGE"));

                listaAnimes.add(animes);
            }

        } catch (SQLException e) {
            throw new SQLException("Erro ao MOSTRA TUDO");
        } finally {
            ConnectionFactory.closeConnection(conn, std, result);
        }

        return listaAnimes;

    }
}
