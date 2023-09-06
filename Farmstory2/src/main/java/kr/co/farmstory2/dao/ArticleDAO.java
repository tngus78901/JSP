package kr.co.farmstory2.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.db.DBHelper;
import kr.co.farmstory2.db.SQL;
import kr.co.farmstory2.dto.ArticleDTO;
import kr.co.farmstory2.dto.FileDTO;

public class ArticleDAO extends DBHelper{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 기본 CRUD
	public int insertArticle(ArticleDTO dto) {
		
		int no = 0;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false); //Transaction 시작

			stmt = conn.createStatement();
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, dto.getCate());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setInt(4, dto.getFile());
			psmt.setString(5, dto.getWriter());
			psmt.setString(6, dto.getRegip());
			psmt.executeUpdate();
			rs = stmt.executeQuery(SQL.SELECT_MAX_NO);
			conn.commit();  // 작업확정
			
			if(rs.next()) {
					no = rs.getInt(1);
			}		
			close();
		}catch (Exception e) {
				e.printStackTrace();
		}
		
		return no;
		
		}
	
	public ArticleDTO selectArticle(String no) {
		
		ArticleDTO article = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
					article = new ArticleDTO();
					article.setNo(rs.getInt(1));
					article.setParent(rs.getInt(2));
					article.setComment(rs.getInt(3));
					article.setCate(rs.getString(4));
					article.setTitle(rs.getString(5));
					article.setContent(rs.getString(6));
					article.setFile(rs.getInt(7));
					article.setHit(rs.getInt(8));
					article.setWriter(rs.getString(9));
					article.setRegip(rs.getString(10));
					article.setRdate(rs.getString(11));
					logger.debug("파일 여부 : " + article.getFile());
					logger.debug("파일 여부 : " + rs.getString(12));
					// 파일 정보
					FileDTO fileDto = new FileDTO();
					fileDto.setFno(rs.getInt(12));
					fileDto.setAno(rs.getInt(13));
					fileDto.setOfile(rs.getString(14));
					fileDto.setSfile(rs.getString(15));
					fileDto.setDownload(rs.getInt(16));
					fileDto.setRdate(rs.getString(17));
					article.setFileDto(fileDto);
			}
			close();
		}catch (Exception e) {
				logger.error("selectArticle() - "+ e.getMessage());
		}
		
		return article;
	}
	
	public List<ArticleDTO> selectArticles(int start,String cate) {
		
		List<ArticleDTO> articles = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLES);
			psmt.setString(1, cate);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
					ArticleDTO dto = new ArticleDTO();
					dto.setNo(rs.getInt(1));
					dto.setParent(rs.getInt(2));
					dto.setComment(rs.getInt(3));
					dto.setCate(rs.getString(4));
					dto.setTitle(rs.getString(5));
					dto.setContent(rs.getString(6));
					dto.setFile(rs.getInt(7));
					dto.setHit(rs.getInt(8));
					dto.setWriter(rs.getString(9));
					dto.setRegip(rs.getString(10));
					dto.setRdate(rs.getString(11));
					dto.setNick(rs.getString(12));
					
					//logger.debug("데이터 확인 : title : " + rs.getString(5) + "/ rdate 확인 : " + rs.getString(11));
					//logger.debug("rdate : " + dto.getRdate());
					logger.debug("nick : " + dto.getNick());
					logger.debug("title : " + dto.getTitle());
					articles.add(dto);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}
		
	
	public void updateArticle(ArticleDTO dto) {
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(SQL.UPDATE_ARTICLE);
				psmt.setString(1, dto.getTitle());
				psmt.setString(2, dto.getContent());
				psmt.setInt(3, dto.getNo());
				psmt.executeUpdate();
				close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void deleteArticle(String no)  {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_ARTICLE);
			psmt.setString(1, no);
			psmt.setString(2, no);
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 추가
	public List<ArticleDTO> selectLatests(String cate, int size) {
		
		List<ArticleDTO> latests = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_LATESTS);
			psmt.setString(1, cate);
			psmt.setInt(2, size);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleDTO dto = new ArticleDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setRdate(rs.getString("rdate"));
				latests.add(dto);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return latests;
	}
	
	public int selectCountTotal(String cate) {
		
		int total = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_TOTAL);
			psmt.setString(1, cate);
			rs = psmt.executeQuery();
			if(rs.next()) {
					total = rs.getInt(1);
			}
			close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	public List<ArticleDTO> selectComments(String parent) {
		
		List<ArticleDTO> comments = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COMMENTS);
			psmt.setString(1, parent);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleDTO dto = new ArticleDTO();
				dto.setNo(rs.getInt(1));
				dto.setParent(rs.getInt(2));
				dto.setComment(rs.getInt(3));
				dto.setCate(rs.getString(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setFile(rs.getInt(7));
				dto.setHit(rs.getInt(8));
				dto.setWriter(rs.getString(9));
				dto.setRegip(rs.getString(10));
				dto.setRdate(rs.getString(11));
				dto.setNick(rs.getString(12));
				
				comments.add(dto);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comments;
	}
	
	// 댓글을 등록하고 등록한 해당 댓글을 바록 조회해서 dto 출력
	public ArticleDTO insertComment(ArticleDTO dto) {
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(SQL.INSERT_COMMENT);
			psmt.setInt(1, dto.getParent());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getRegip());
			psmt.executeUpdate();
			rs = stmt.executeQuery(SQL.SELECT_COMMENT_LATEST);
			conn.commit();
			
			if(rs.next()) {
					dto.setNo(rs.getInt(1));
					dto.setParent(rs.getInt(2));
					dto.setComment(rs.getInt(3));
					dto.setCate(rs.getString(4));
					dto.setTitle(rs.getString(5));
					dto.setContent(rs.getString(6));
					dto.setFile(rs.getInt(7));
					dto.setHit(rs.getInt(8));
					dto.setWriter(rs.getString(9));
					dto.setRegip(rs.getString(10));
					dto.setRdateYYMMDD(rs.getString(11));
					dto.setNick(rs.getString(12));
			}
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("dto : " + dto);
		
		return dto;
	}
	public void updateArticleForCommentPlus(String no) {
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(SQL.UPDATE_ARTICLE_FOR_COMMENT_PLUS);
				psmt.setString(1, no);
				psmt.executeUpdate();
				close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void updateArticleForCommentMinus(String no) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_ARTICLE_FOR_COMMENT_PLUS);
			psmt.setString(1, no);
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateComment(String no, String content) {
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_COMMENT);
			psmt.setString(1, content);
			psmt.setString(2, no);
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int deleteComment(String no) {
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_COMMENT);
			psmt.setString(1, no);
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}