package kr.ko.farmstory.dao;

import java.sql.Connection;

import kr.ko.farmstory.db.DBHelper;
import kr.ko.farmstroy.dto.ArticleDTO;

public class ArticleDAO extends DBHelper {
	
		// 기본CRUD
		public void insertArticle(ArticleDTO dto) {
			
				try {
						conn = getConnection();
						psmt = conn.prepareStatemet(SQL.UPDATE_ARTICLE_FOR_COMMENT_MINUS);
						psmt.setString(1, no);
						psmt.executeUpdate();
						close();
						
					
					
					
					
					
				} catch (Exception e) {
						e.printStackTrace();
				}
		}
		
		public void updateArticleForCommentPlus(String no) {
			
				try {
					
				} catch (Exception e) {
						e.printStackTrace();
				}
		}

		public void updateArticleForCommentMinus(String no) {
				
				try {
					
				} catch (Exception e) {
						e.printStackTrace();
				}
			
		}
		
		public void updateComment(String no, String content) {
				
				try {
					
				} catch (Exception e) {
						e.printStackTrace();
				}
			
			
		}
		
		public void deleteComment(String no) {
				
				try {
					
				} catch (Exception e) {
						e.printStackTrace();
				}
			
			
			
		}
}
