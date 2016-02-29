/*
 * タイトル：売上情報を取得する為の処理
 * 説明    ：DAOから受け取ったデータをリストに格納をして、admin_capacity.jspに送る。
 *
 * 著作権  ：Copyright(c) 2016 InterNous, Inc.
 * 会社名  ：インターノウス株式会社
 *
 * 変更履歴：
 *        
 */
package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminCapacitySearchDAO;
import dto.AdminCapacitySearchDTO;

/**
 * 売上情報を取得する為のクラス
 * @author S.Iiduka
 * @since 1.0
 * @version 1.0
 */
public class AdminCapacitySearchAction extends ActionSupport{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -1687299963308729673L;

	/**
	 * 売上情報を格納するリスト
	 */
	private ArrayList<AdminCapacitySearchDTO> searchList = new ArrayList<>();

	/**
	 * 検索開始年
	 */
	private String year;

	/**
	 * 検索開始月
	 */
	private String month;

	/**
	 * 検索終了年
	 */
	private String lastYear;

	/**
	 * 検索終了月
	 */
	private String lastMonth;

	/**
	 * 売上情報を取得する為のメソッド
	 * @return result データを取得できたら、リストに格納をしてSUCCESS、できなかったらERRORを返します。
	 */
	public String execute(){

		String result = SUCCESS;
		AdminCapacitySearchDAO dao = new AdminCapacitySearchDAO();

		if(dao.capacitySearch(year, month, lastYear, lastMonth)){
			searchList = dao.getSearchList();
		}else{
			result = ERROR;
		}
		return result;

	}

	/**
	 * 売上数量を取得する為のメソッド
	 * @return searchList 売上数量のリスト
	 */
	public ArrayList<AdminCapacitySearchDTO> getSearchList() {
		return searchList;
	}

	/**
	 * 売上数量を格納する為のメソッド
	 * @param searchList 売上数量のリスト
	 */
	public void setSearchList(ArrayList<AdminCapacitySearchDTO> searchList) {
		this.searchList = searchList;
	}

	/**
	 * 検索開始年を取得する為のメソッド
	 * @return year 検索開始年
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 検索開始年を格納する為のメソッド
	 * @param year 検索開始年
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 検索開始月を取得する為のメソッド
	 * @return month 検索開始月
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 検索開始月を格納する為のメソッド
	 * @param month 検索開始月
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 検索終了年を取得する為のメソッド
	 * @return lastYear 検索終了年
	 */
	public String getLastYear() {
		return lastYear;
	}

	/**
	 * 検索終了年を格納する為のメソッド
	 * @param lastYear 検索終了年
	 */
	public void setLastYear(String lastYear) {
		this.lastYear = lastYear;
	}

	/**
	 * 検索終了月を取得する為のメソッド
	 * @return lastMonth 検索終了月
	 */
	public String getLastMonth() {
		return lastMonth;
	}

	/**
	 * 検索終了月を格納する為のメソッド
	 * @param lastMonth 検索終了月
	 */
	public void setLastMonth(String lastMonth) {
		this.lastMonth = lastMonth;
	}
}