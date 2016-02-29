/*
 * タイトル：ユーザーから指定された区間のデータを取得する為の処理
 * 説明    ：ユーザーの方から始まりの年月と終わりの年月を指定してもらい、それを元に検索をする。
 *
 * 著作権  ：Copyright(c) 2016 InterNous, Inc.
 * 会社名  ：インターノウス株式会社
 *
 * 変更履歴：
 *
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.AdminCapacitySearchDTO;
import util.D3DBConnector;

/**
 * ユーザーから指定された区間のデータを取得する為のクラス
 * @author S.Iiduka
 * @since 1.0
 * @version 1.0
 */
public class AdminCapacitySearchDAO {

	/**
	 * 取得した売上情報を格納する為のリスト
	 */
	private ArrayList<AdminCapacitySearchDTO> searchList = new ArrayList<>();

	/**
	 *ユーザーから指定された区間のデータを取得し、リストに格納する為のメソッド
	 * @param year 検索開始年
	 * @param month 検索開始月
	 * @param lastYear 検索終了年
	 * @param lastMonth 検索終了月
	 * @return データの取得が成功したらリストに格納してtrue、失敗したらfalseを返す
	 */
	public boolean capacitySearch(String year, String month, String lastYear, String lastMonth){

		boolean result = false;
		Connection conn = D3DBConnector.getConnection("kinnosawa");
		String topDate = year + month;
		String lastDate = lastYear + lastMonth;
		String sql = "select goods.name,sum(order_history.number) "
				+ "from goods inner join order_history on goods.id = order_history.goods_id "
				+ "WHERE DATE_FORMAT(order_history.created_at,'%Y%m') >=? && DATE_FORMAT(order_history.created_at,'%Y%m') <=?"
				+ "group by name ";

		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, topDate);
			ps.setString(2, lastDate);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				AdminCapacitySearchDTO dto = new AdminCapacitySearchDTO();
				dto.setGoodsName(rs.getString("goods.name"));
				dto.setTotal(rs.getInt("sum(order_history.number)"));
				searchList.add(dto);
				result = true;
			}
		}catch(SQLException e){
		e.printStackTrace();
		}finally {
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 売上のリストを取得する為のメソッド
	 * @return searchList 売上のリスト
	 */
	public ArrayList<AdminCapacitySearchDTO> getSearchList() {
		return searchList;
	}

	/**
	 * 売上のリストを格納する為のメソッド
	 * @param searchList 売上のリスト
	 */
	public void setSearchList(ArrayList<AdminCapacitySearchDTO> searchList) {
		this.searchList = searchList;
	}
}
