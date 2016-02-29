/**
 *
 */
package action;


import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ShowGraphDAO;
import dto.ShowGraphDTO;

/**
 * グラフを表示するACTONクラス
 * @author 河野 隆伸
 * @version 1.1
 * @since 1.0
 */
public class ShowGraphAction  extends ActionSupport {


	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 5257835176876231857L;
	/**
	 * 商品の名前と売り上げリスト
	 */
	public List<ShowGraphDTO> ShowGraphList = new ArrayList<ShowGraphDTO>();


	/**
	 * D3表示メソッド
	 * @return SUCCESS グラフの表示
	 */
	public String execute() {

		ShowGraphDAO dao = new ShowGraphDAO();
		if(!dao.select()){
			return ERROR;
		}
		ShowGraphList = dao.getShowGraphList();

		String result = SUCCESS;
		return result;
	}


	/**
	 * 商品の名前と売り上げリストの取得
	 * @return itemSales 商品の名前と売り上げリスト
	 */
	public List<ShowGraphDTO> getShowGraphList() {
		return ShowGraphList;
	}

	/**
	 * 商品の名前と売り上げリストの格納
	 * @param itemSales 商品の名前と売り上げリスト
	 */
	public void setShowGraphList(List<ShowGraphDTO> showGraphList) {
		ShowGraphList = showGraphList;
	}
}