/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Temis
 */
public class SequenceManager {
     public int getValue(String sequenceName) throws SQLException, Exception {
        String sql = "SELECT nextval(?) AS value";
        ConectorBD connector = new ConectorBD();
        try (Connection con = connector.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, sequenceName);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("value");
                }
            }
        }
        throw new SQLException("Unable to retrieve sequence value.");
    }
}
