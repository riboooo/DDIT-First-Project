package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.BoardDao;
import dao.OrderDao;
import util.ScanUtil;
import util.View;

public class OrderService {

	
	
	//싱글톤 패턴 
	private static OrderService instance;
	private OrderService(){}
	
	public static OrderService  getInstance() {
		if(instance == null){
			instance = new OrderService();
		}
		return instance;
		
	}

	private OrderDao orderDao = OrderDao.getInstance();

public int orderMainView(){
	
	System.out.println("==============주문 페이지=============");
	System.out.println("==============주문 페이지=============");
	System.out.println("1. 검색\t2.품목 추가");
	System.out.print("입력 > ");
	int input = ScanUtil.nextInt();
	switch (input) {
	case 1:
		System.out.print("카테고리 입력 (식료품 = 1, 부가기재 = 2, 전체 = 0) > ");
		int cate = ScanUtil.nextInt();
		System.out.print("검색어 입력(전체검색 = 0) > ");
		String search = ScanUtil.nextLine();
		return orderSearch(cate, search);

	case 2:
		
		
		return View.ORDER_MAIN_VIEW;
	case 3: return View.HOME;
	case 0:
		Controller.loginUser = null;
		return View.HOME;
		
	}
	
	
	
	
	
	return View.BOARD_LIST;
	
}

private int orderSearch(int cate, String search) {
	
	
	
	
	
	
	
	List<Map<String, Object>> items = orderDao.orderSearchItem(cate, search);
	System.out.println("==========검색결과===============");
	System.out.println("품목번호\t품목명\t설명\t가격\t재고\t카테고리");
	for(Map<String, Object> prod : items){
		System.out.println(prod.get("PROD_NUM") + "\t"
				+ prod.get("PROD_NAME") + "\t"
				+ prod.get("PROD_TEXT") + "\t"
				+ prod.get("PROD_PRICE") + "\t"
				+ prod.get("COUNT") + "\t"
				+ prod.get("PROD_CTEGORY")
				);
	}
	
	
	
	return View.ORDER_MAIN_VIEW;
}



}