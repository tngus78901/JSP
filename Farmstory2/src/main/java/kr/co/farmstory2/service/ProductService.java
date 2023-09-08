package kr.co.farmstory2.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.farmstory2.dao.ProductDAO;
import kr.co.farmstory2.dto.ProductDTO;

public enum ProductService {
	INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ProductDAO dao = new ProductDAO();
	
	public void insertProduct(ProductDTO dto) {
			dao.insertProduct(dto);
	}
	
	public ProductDTO selectProduct(String pNo) {
			return dao.selectProduct(pNo);
	}
	
	public List<ProductDTO> selectProducts(int start) {
			return dao.selectProducts(start);
	}
	
	public List<ProductDTO> selectProducts(String type, int start) {
			return dao.selectProducts(type, start);
	}
	
	public void updateProduct(ProductDTO dto) {
			dao.updateProduct(dto);
	}
	
	public void deleteProduct(int pNo) {
			dao.deleteProduct(pNo);	
	}
	
	// 추가
	public int selectCountProductsTotal() {
			return dao.selectCountProductsTotal();
	}
	
	public int selectCountProductsTotal(String type) {
		 return dao.selectCountProductsTotal(type);
	}
	/* 썸네일 업로드*/

	
	// 업로드 경로 구하기
	public String getFilePath(HttpServletRequest req) {
		// 파일 업로드 경로 구하기
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/thumb");
		return path;
	}
	
	// 파일명 수정
	public String renameToFile(HttpServletRequest req,String path, String oName) {
				
		
		int i = oName.lastIndexOf(".");
		String ext = oName.substring(i);
		
		String uuid = UUID.randomUUID().toString();
		String sName = uuid + ext;
		
		File f1 = new File(path+"/"+oName);
		File f2 = new File(path+"/"+sName);
		
		f1.renameTo(f2);
		
		return sName;
		
	}
	
	// 파일 업로드
	public MultipartRequest uploadFile(HttpServletRequest req, String path) {
		
		// 최대 업로드 파일 크기
		int maxSize = 1024 * 1024 * 10;
		
		// 파일 업로드 및 Multipart 객체 생성
		MultipartRequest mr = null;
		
		try {
				mr = new MultipartRequest(req,
												path,
												maxSize,
												"UTF-8",
											new DefaultFileRenamePolicy());
		} catch (IOException e) {
			logger.error("uploadFile : " + e.getMessage());
		}
		return mr;				
	}
	


}
