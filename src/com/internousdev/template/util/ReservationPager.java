/**
 *
 */
package com.internousdev.template.util;

/**
 * @author internousdev
 * ページングの為の情報
 * 　使っていないです。
 * 
 */
public class ReservationPager {
    private int num;
    private int pagenum;

    private int maxpage;
    private int resvpage;

    /**
     * コンストラクター
     * @param pagenum  1ページあたりの表示数
     */
    public ReservationPager(int pagenum){
    	this.pagenum = pagenum;
    }
    /**
     * 現在のpageの設定
     * @param page
     */
    public void setPage(int page){
    	this.resvpage = page;
    }
    /**
     * 全数の設定
     * @param num
     */
    public void setNum(int num){
    	this.num = num;
    	this.maxpage = ((num-1) / pagenum)+1;
    	this.resvpage = Math.min(Math.max(resvpage, 1),this.maxpage);
    }
    /**
     * ページの最初の項目番号
     */
    public int getFirst(){
    	return (resvpage-1)*pagenum;
    }
    /**
     * ページの表示数
     */
    public int getCount(){
    	return pagenum;
    }
    /**
     * ページの最後の項目番号
     */
    public int getLast(){
    	return Math.min(resvpage*pagenum, num);
    }
    /**
     * 総数
     */
    public int getNum(){
    	return num;
    }
    /**
     * ページの表示数
     */
    public int getPageNum() {
    	return pagenum;
    }
    /**
     * 前ページあるか？
     *
     */
    public boolean getHasPrevPage(){
    	return resvpage > 1;
    }
    /**
     * 前のページの番号
     */
    public int getPrevPage(){
    	return Math.max(resvpage -1 , 1);
    }
    /**
     * 次のページがあるか？
     */
    public boolean getHasNextPage(){
    	return resvpage < maxpage;
    }
    /**
     * 次のページ番号
     */
    public int getNextPage(){
    	return Math.min(resvpage + 1, maxpage);
    }
}
 