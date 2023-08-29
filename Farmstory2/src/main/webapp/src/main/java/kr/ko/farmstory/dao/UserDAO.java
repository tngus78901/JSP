package kr.ko.farmstory.dao;

import kr.ko.farmstory.db.DBHelper;
import kr.ko.farmstroy.dto.UserDTO;

public class UserDAO extends DBHelper {
	
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
			return instance;
		
	}
	private UserDAO() {}
	
	
	// 기본 CRUD
	public void insertUesr(UserDTO dto) {
		
		try {
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
