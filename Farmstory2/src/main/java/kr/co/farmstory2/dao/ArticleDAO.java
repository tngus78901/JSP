package kr.co.farmstory2.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.db.DBHelper;
import kr.co.farmstory2.db.SQL;
import kr.co.farmstory2.dto.ArticleDTO;

public class ArticleDAO extends DBHelper{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 기본 CRUD
	public int insertArticle(ArticleDTO dto) {
		
		int no = 0;
		
		try {
			conn = getConnection();

			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, dto.getCate());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setInt(4, dto.getFile());
			psmt.setString(5, dto.getWriter());
			psmt.setString(6, dto.getRegip());
			psmt.executeUpdate();
			
		//	if(rs.next()) {
		//			no = rs.getInt(1);
		//	}		
			close();
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		return no;
		}
	
	public ArticleDTO selectArticle(String no) {
		
		ArticleDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLE);
			psmt.setString(1, no);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
					dto = new ArticleDTO();
					dto.setNo(rs.getInt("no"));
					dto.setParent(rs.getInt("parent"));
					dto.setComment(rs.getInt("comment"));
					dto.setCate(rs.getString("cate"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setFile(rs.getInt("file"));
					dto.setHit(rs.getInt("hit"));
					dto.setWriter(rs.getString("writer"));
					dto.setRegip(rs.getString("regip"));
					dto.setRdate(rs.getString("rdate"));
			}
			close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;	
	}
	
	public List<ArticleDTO> selectArticles(String cate, int start) {
		
		List<ArticleDTO> articles = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLES);
			psmt.setString(1, cate);
			psmt.setInt(1, start);
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
				dto.setTitle(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setFile(rs.getInt(6));
				dto.setHit(rs.getInt(7));
				dto.setWriter(rs.getString(8));
				dto.setRegip(rs.getString(9));
				dto.setRdate(rs.getString(10));
				dto.setNick(rs.getString(11));
				dto.setNo(rs.getInt(12));
				
				comments.add(dto);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comments;
	}
	public void insertComment(ArticleDTO dto) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_COMMENT);
			psmt.setInt(1, dto.getParent());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getRegip());
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public void updateComment(String no, String content) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_COMMENT);
			psmt.setString(1, content);
			psmt.setString(2, no);
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteComment(String no) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_COMMENT);
			psmt.setString(1, no);
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}