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
import model.Calendario;
import util.ConnectionFactory;
import enumclass.EnumDiaDaSemana;

/**
 *
 * @author sidne
 */
public class CalendarioConnector {

    public void save(Anime anime) throws SQLException {

        String sql = "";
        boolean aux = true;
        switch (anime.getExibicao()) {
            case EnumDiaDaSemana.SEGUNDA:
                sql = "INSERT INTO CALENDARIOSEMANAL(SEGUNDA) VALUES (?)";
                break;
            case EnumDiaDaSemana.TERCA:
                sql = "INSERT INTO CALENDARIOSEMANAL(TERCA) VALUES (?)";
                break;
            case EnumDiaDaSemana.QUARTA:
                sql = "INSERT INTO CALENDARIOSEMANAL(QUARTA) VALUES (?)";
                break;
            case EnumDiaDaSemana.QUINTA:
                sql = "INSERT INTO CALENDARIOSEMANAL(QUINTA) VALUES (?)";
                break;
            case EnumDiaDaSemana.SEXTA:
                sql = "INSERT INTO CALENDARIOSEMANAL(SEXTA) VALUES (?)";
                break;
            case EnumDiaDaSemana.SABADO:
                sql = "INSERT INTO CALENDARIOSEMANAL(SABADO) VALUES (?)";
                break;
            case EnumDiaDaSemana.DOMINGO:
                sql = "INSERT INTO CALENDARIOSEMANAL(DOMINGO) VALUES (?)";
                break;
            case EnumDiaDaSemana.NENHUM:
                aux = false;
                break;
            default:
                throw new AssertionError();
        }

        Connection conn = null;
        PreparedStatement std = null;

        try {
            if (aux) {
                conn = ConnectionFactory.getConnection();
                std = conn.prepareStatement(sql);
                std.setString(1, anime.getName());
                std.execute();
            }
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ConnectionFactory.closeConnection(conn, std);
        }
    }

    public ArrayList<Calendario> getAll() throws SQLException {
        String sql = "SELECT * FROM CALENDARIOSEMANAL";
        ArrayList<Calendario> listCalendario = new ArrayList<Calendario>();

        Connection conn = null;
        PreparedStatement std = null;
        ResultSet result = null;

        try {
            conn = ConnectionFactory.getConnection();
            std = conn.prepareStatement(sql);

            result = std.executeQuery();

            while (result.next()) {
                Calendario calendario = new Calendario();

                calendario.setSegunda(result.getString("segunda"));
                calendario.setTerca(result.getString("terca"));
                calendario.setQuarta(result.getString("quarta"));
                calendario.setQuinta(result.getString("quinta"));
                calendario.setSexta(result.getString("sexta"));
                calendario.setSabado(result.getString("sabado"));
                calendario.setDomingo(result.getString("domingo"));

                listCalendario.add(calendario);

            }

        } catch (SQLException e) {
            throw new SQLException("Erro ao pegar tudo" + e);
        } finally {
            ConnectionFactory.closeConnection(conn, std, result);
        }

        return listCalendario;

    }
}
