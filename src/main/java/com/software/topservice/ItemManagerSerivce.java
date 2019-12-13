//package com.software.topservice;
//
//import java.util.List;
//
//import com.software.domain.Item;
//
//public interface ItemManagerSerivce 
//{
//	/**
//	 * 需要itemtableName,itemID
//	 * @param record
//	 */
//	public void deleteByPrimaryKey(Item record);
//
//	/**
//	 * 需要 itemtableName， 页面给啥你填啥
//	 * @param record
//	 */
//    public void insertSelective(Item record);
//    
//    /**
//     * 需要tablename， 页面给啥你填啥
//     * @param record
//     * @return
//     */
//    public List<Item> select(Item record);
//    
//    /**
//     * 需要tablename， itemID+页面给啥你填啥
//     * @param record
//     * @return
//     */
//    public void updateByPrimaryKeySelective(Item record);    
//    
//    /**
//     * 需要tablename
//     */
//    public List<String> typeMenu(Item record);
//    
//}
