package dto;

/**
 * グラフに表示する情報を取得、格納するクラス
 * @author 河野 隆伸
 * @version 1.1
 * @since 1.0
 */
public class ShowGraphDTO {


    /**
     * 商品名 itemName
     */
	private String itemName;

	/**
	 * 売上数 salesAmount
	 */
	private int salesAmount;



	/**
	 * 商品名を取得するメソッド
	 * @return itemName 商品名
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 商品名を格納するメソッド
	 * @param itemName 商品名
	 */
	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	/**
	 * 売上数を取得するメソッド
	 * @return salesAmount 売上数
	 */
	public int getSalesAmount() {
		return salesAmount;
	}

	/**
	 * 売上数を格納するメソッド
	 * @return salesAmount 売上数
	 */
	public String getItemName() {
		return itemName;
	}
}
