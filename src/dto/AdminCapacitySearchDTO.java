/*
 * タイトル：取得した売上情報のデータを格納する為の処理
 * 説明    ：取得した売上情報のデータを格納する。
 *
 * 著作権  ：Copyright(c) 2016 InterNous, Inc.
 * 会社名  ：インターノウス株式会社
 *
 * 変更履歴：
 *
 */
package dto;

/**
 * 取得した売上情報のデータを格納する為のクラス
 * @author S.Iiduka
 * @since 1.0
 * @version 1.0
 */
public class AdminCapacitySearchDTO {

	/**
	 * 商品名
	 */
	private String goodsName;

	/**
	 * 値段の合計
	 */
	private int total;

	/**
	 * 商品名を取得する為のメソッド
	 * @return goodsName 商品名
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * 値段の合計を格納する為のメソッド
	 * @param goodsName 値段の合計
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * 値段の合計を取得する為のメソッド
	 * @return total 値段の合計
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * 値段の合計を格納する為のメソッド
	 * @param total 値段の合計
	 */
	public void setTotal(int total) {
		this.total = total;
	}
}