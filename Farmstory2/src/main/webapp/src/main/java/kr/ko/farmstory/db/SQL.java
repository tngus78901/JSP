package kr.ko.farmstory.db;

public class SQL {
		// User
		public static final String INSERT_USER = "INSERT INTO `User` SET"
																			+"`uid`=?,"
																			+"`pass`=SHA2(?,256),"
																			+"`name`=?,"
																			+"`nick`=?,"
																			+"`email`=?,"
																			+"`hp`=?,"
																			+"`zip`=?,"
																			+"`addr1`=?,"
																			+"`addr2`=?,"
																			+"`regip`=?,"
																			+"`regDate`=NOW()";
		
		public static final String SELECT_USER = "SELECT * FROM `User` WHERE `uid`=? AND `pass`=SHA(?, 256)";
		public static final String SELECT_COUNT_UID = "SELECT COUNT(*) FROM `User` WHERE `uid`=?";
		public static final String SELECT_COUNT_NICK = "SELECT COUNT(*) FROM `User` WHERE `nick`=?";
		public static final String SELECT_COUNT_EMAIL = "SELECT COUNT(*) FROM `User` WHERE `email`=?";
		public static final String SELECT_COUNT_HP = "SELECT COUNT(*) FROM `User` WHERE `hp`=?";
		public static final String SELECT_TERMS = "SELECT * FROM `Terms`";
		
		
		// Article
		public static final String INSERT_ARTICLE = "INSERT INTO `Article` SET " 
																					+"`cate`=?,"
																					+"`title`=?,"
																					+"`content`=?,"
																					+"`writer`=?,"
																					+"`regip`=?,"
																					+"`rdate`=NOW()";
		
		
		
		public static final String INSERT_COMMENT = "INSERT INTO `Article` SET "
																					+"`parent`=?,"
																					+"`content`=?,"
																					+"`writer`=?,"
																					+"`regip`=?,"
																					+"`rdate`=NOW()";
		
		
		public static final String SELECT_ARTICILE = "SELECT * FROM `Article` WHERE `no`=?";
		public static final String SELECT_ARTICILES = "SELECT "
																					+"a.*,"
																					+"b.nick"
																					+"FROM `Article` AS a"
																					+"JOIN `User` AS b ON a.writer = b.uid"
																					+"WHERE `parent`=0 AND `cate`=?"
																					+"ORDER BY `no` DESC"
																					+"LIMIT ?,10";
		
		
		public final static String SELECT_COMMENTS = "SELECT"
		
																					+"a.*, "
																					+"b.`nick`"
																					+"FROM `Article` AS a"
																					+"JOIN `User` AS b ON a.writer = b.uid"
																					+"WHERE `parent`=?";
		
		public final static String SELECT_COUNT_TOTAL = "SELECT COUNT (*) FROM `Article` WHERE `parent`=0";
		
		
		public final static String UPDATE_ARTICLE = "UPDATE `Article` SET `title`=?, `content`=? WHERE `no`=?";
		public final static String UPDATE_ARTICLE_FOR_COMMENT_PLUS = "UPDATE" 
		public final static String UPDATE_ARTICLE_FOR_COMMENT_MINUS = 
		public final static String UPDATE_COMMENT =
		
		public final static String DELETE_ARTICLE = 
		public final static String DELETE_COMMENT = 

}
