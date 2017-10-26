package com.internousdev.template.util;

import java.util.ArrayList;

import com.internousdev.template.dto.ReservationDTO;

/**
 * ページネーションが必要なリストのために、1ページごとの情報を保持するためのクラス
 */
public class ReservationViewPageObject {

	/**
	 * ページを識別するID
	 */
	private int pageId;

	/**
	 * 当該1ページに掲載される予約のリスト
	 */
	private ArrayList<ReservationDTO> pageReservationList = new ArrayList<ReservationDTO>();




	/**
	 * ページネートされた予約リストを取得するメソッド
	 * @return  pageReservationList　ページネーション予約リスト
	 */
	public ArrayList<ReservationDTO> getPaginatedList() {
			return pageReservationList;
			}

	/**
	 * ページネートされた商品リストを格納するメソッド
	 * @param list ページネーションが完了した1ページごとのリスト
	 */
	public void setPaginatedList(ArrayList<ItemDTO> list) {
			paginatedItemList = list;
	}

	/**
	 * AllPagesクラスのpaginate()において使われる
	 * これによってDTOのインスタンスが当該ページにひとつずつ格納されていく
	 * @param list これからページネーション処理を行うリスト
	 * @param j 繰り返し用変数
	 */
	public void addPaginatedList(ArrayList<ItemDTO> list, int j) {
			paginatedItemList.add((ItemDTO)list.get(j));
			}



	/**
     * ページネーション商品リストを取得するメソッド
     * @return paginatedItemList　ページネーション商品リスト
     */
    public ArrayList<ItemDTO> getPaginatedItemList() {
        return paginatedItemList;
    }

    /**
     *  ページネーション商品リストを格納するメソッド
     * @param paginatedItemList　 ページネーション商品リスト
     */
    public void setPaginatedItemList(ArrayList<ItemDTO> paginatedItemList) {
        this.paginatedItemList = paginatedItemList;
    }

    /**
     * ページネーション商品リスト取得するメソッド
     * @return paginatedRecipeList　ページネーション商品リスト
     */
    public ArrayList<RecipeDTO> getPaginatedRecipeList() {
        return paginatedRecipeList;
    }

    /**
     *  ページネーションレシピリストを格納するメソッド
     * @param paginatedRecipeList　ページネーションレシピリスト
     */
    public void setPaginatedRecipeList(ArrayList<RecipeDTO> paginatedRecipeList) {
        this.paginatedRecipeList = paginatedRecipeList;
    }

    /**
     * AllPagesクラスのpaginate()において使われる
     * これによってDTOのインスタンスが当該ページにひとつずつ格納されていく
     * @param list これからページネーション処理を行うリスト
     * @param j 繰り返し用変数
     */
    public void addPaginatedRecipeList(ArrayList<RecipeDTO> list, int j) {
            paginatedRecipeList.add((RecipeDTO)list.get(j));
            }

    /**
	 * ページID取得メソッド
	 * @return pageId　ページID
	 */
	public int getPageId() {
		return pageId;
	}

	/**
	 * ページID格納メソッド
	 * @param pageId ページID
	 */
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
}