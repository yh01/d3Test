package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.D3DTO;
import util.D3DBConnector;

public class D3DAO {
	public void selectToD3(int id,D3DTO dto) {

		Connection con = D3DBConnector.getConnection("d3Test");

		String sql = "SELECT * FROM d3 WHERE id = ? ";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				dto.setTest1(resultSet.getInt("test1"));
				dto.setTest2(resultSet.getInt("test2"));
				dto.setTest3(resultSet.getInt("test3"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
