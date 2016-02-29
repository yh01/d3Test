/**
 *
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ShowGraphDTO;
import util.D3DBConnector;

/**
 * グラフを表示するためのDAO
 * @author 河野 隆伸
 * @version 1.1
 * @since 1.0
 */
public class ShowGraphDAO {


	/***
	 * 取得した商品名・売上数量リスト
	 */
	public List<ShowGraphDTO> ShowGraphList = new ArrayList<ShowGraphDTO>();

	/**
	 * ShowGraphDTOのインスタンス化
	 */
	ShowGraphDTO dto = new ShowGraphDTO();


	/**
	 * DBから商品名と売り上げを入手するメソッド
	 * @param ItemName 商品名
	 * @param SalesAmount 売上数
	 */
	public boolean select(){


		boolean result = true;
		D3DBConnector dbConnection = new D3DBConnector();
		Connection con = dbConnection.getConnection("d3SelectListTest");


		try{
			String sql = "SELECT itemName,salesAmount from d3select ORDER BY id ";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ShowGraphDTO dto = new ShowGraphDTO();
				dto.setItemName(rs.getString(1));
				dto.setSalesAmount(rs.getInt(2));
				ShowGraphList.add(dto);
			}
		}catch(SQLException e){
			result = false;
			return result;
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				result = false;
				return result;
			}
		}
		return result;
	}


	/**
	 * 取得した商品名・売上数量を取得する為のリスト
	 * @return showGraphList
	 */
	public List<ShowGraphDTO> getShowGraphList() {
		return ShowGraphList;
	}

	/**
	 * 取得した商品名・売上数量を格納する為のリスト
	 * @return showGraphList
	 */
	public void setShowGraphList(List<ShowGraphDTO> showGraphList) {
		ShowGraphList = showGraphList;
	}

	/**
	 * ShowGraphDTOを取得するメソッド
	 * @return dto ShowGraphDTO
	 */
	public ShowGraphDTO getDto() {
		return dto;
	}

	/**
	 * ShowGraphDTOを格納するメソッド
	 * @param dto ShowGraphDTO
	 */
	public void setDto(ShowGraphDTO dto) {
		this.dto = dto;
	}

}