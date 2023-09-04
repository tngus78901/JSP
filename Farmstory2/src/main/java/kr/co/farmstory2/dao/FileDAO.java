package kr.co.farmstory2.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dto.FileDTO;
import kr.farmstory2.db.DBHelper;
import kr.farmstory2.db.SQL;

public class FileDAO extends DBHelper {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertFile(FileDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_FILE);
			psmt.setInt(1, dto.getAno());
			psmt.setString(2, dto.getOfile());
			psmt.setString(3, dto.getSfile());
			close();
		} catch (Exception e) {
			logger.error("insertFile() : " + e.getMessage());
		}
		
	}
	
	public FileDTO selectFile(String fno) {
		FileDTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_FILE);
			psmt.setString(1, fno);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new FileDTO();
				dto.setFno(rs.getInt(1));
				dto.setAno(rs.getInt(2));
				dto.setOfile(rs.getString(3));
				dto.setSfile(rs.getString(4));
				dto.setDownload(rs.getInt(5));
				dto.setRdate(rs.getString(6));
				
			}
			close();
		} catch (Exception e) {
			logger.error("selectFile() :" + e.getMessage());
		}
	}
	public List<FileDTO> selectFiles() {
		return null;
	}
	public void updateFile(FileDTO dto) {
		
	}
	public void deleteFile(String ano) {
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_FILE);
			psmt.setString(1, ano);
			result = psmt.executeUpdate();
			close();			
		} catch (Exception e) {
			logger.error("deleteFile - " +e.getMessage());
		}
		
		return result;
	}

	
}
