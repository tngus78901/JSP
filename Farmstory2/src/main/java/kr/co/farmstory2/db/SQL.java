package kr.co.farmstory2.db;

public class SQL {
	
	// User
	public static final String INSERT_USER = "INSERT INTO `User` SET"
																			+ "`uid`=?,"
																			+ "`pass`=SHA2(?,256),"
																			+ "`name`=?,"
																			+ "`nick`=?,"
																			+ "`email`=?,"
																			+ "`hp`=?,"
																			+ "`zip`=?,"
																			+ "`addr1`=?,"
																			+ "`addr2`=?,"
																			+ "`regip`=?,"
																			+ "`regDate`=NOW()";
			
			
			
	public static final String SELECT_USER       = "SELECT * FROM `User` WHERE `uid`=? AND `pass`=SHA2(?,256)";
	public static final String SELECT_COUNT_UID  = "SELECT COUNT(*) FROM `User` WHERE `uid`=?";
	public static final String SELECT_COUNT_NICK = "SELECT COUNT(*) FROM `User` WHERE `nick`=?";
	public static final String SELECT_COUNT_EMAIL= "SELECT COUNT(*) FROM `User` WHERE `email`=?";
	public static final String SELECT_COUNT_HP   = "SELECT COUNT(*) FROM `User` WHERE `hp`=?";
	public static final String SELECT_USERS   = "SELECT * FROM `User`";
	
	// Terms
	public static final String SELECT_TERMS ="SELECT * FROM `Terms`";  
																		   
																		  
	
	// Article
	public final static String INSERT_ARTICLE = "INSERT INTO `Article` SET"
																			+ "`cate`=?,"	
																			+ "`title`=?,"	
																			+ "`content`=?,"	
																			+ "`file`=?,"	
																			+ "`writer`=?,"	
																			+ "`regip`=?,"	
																			+ "`rdate`=NOW()";	
																		
	public final static String INSERT_COMMENT = "INSERT INTO `Article` SET"  
																			+ "`parent`=?,"
																			+ "`content`=?,"
																			+ "`writer`=?,"
																			+ "`regip`=?,"
																			+ "`rdate`=NOW()";
	
	public final static String SELECT_LATESTS = "SELECT `no`,`title`,`rdate` FROM `Article`"
																			+ "WHERE `parent`=0 AND `cate`=?"
																			+ "Order BY `no` DESC LIMIT?";
	
	public final static String SELECT_MAX_NO = "SELECT MAX(`no`) FROM `Article`";
	public final static String SELECT_ARTICLE = "SELECT  a.*, b.*  FROM `Article` AS a LEFT JOIN `File` AS b ON a.no = b.ano  WHERE `no`=?";
	public final static String SELECT_ARTICLES = "SELECT "
																			+ "a.*,"
																			+ "b.`nick` "
																			+ "FROM `Article` AS a "
																			+ "JOIN `User` AS b ON a.writer = b.uid "
																			+ "WHERE `parent`=0 AND `cate`=? "
																			+ "ORDER BY `no` DESC "
																			+ "LIMIT ?, 10";
	public final static String SELECT_COMMENTS = "SELECT "
																			+ "a.*,"
																			+ "b.`nick` "
																			+ "FROM `Article` AS a "
																			+ "JOIN `User` AS b ON a.writer = b.uid "
																			+ "WHERE `parent`=?";
																			
	public final static String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `Article` WHERE `parent`=0 AND `cate`=?";
	
	public final static String UPDATE_ARTICLE = "UPDATE `Article` SET `title`=?, `content`=? WHERE `no`=?";
	public final static String UPDATE_ARTICLE_FOR_COMMENT_PLUS = "UPDATE `Article` SET `comment` = `comment` + 1 WHERE `no`=?";
	public final static String UPDATE_ARTICLE_FOR_COMMENT_MINUS = "UPDATE `Article` SET `comment` = `comment` - 1 WHERE `no`=?";
	public final static String UPDATE_COMMENT = "UPDATE `Article` SET `content`=? WHERE `no`=?";
	
	public final static String DELETE_ARTICLE = "DELETE FROM `Article` WHERE `no`=? OR `parent`=?";
	public final static String DELETE_COMMENT = "DELETE FROM `Article` WHERE `no`=?";

	// File
	public final static String INSERT_FILE = "INSERT INTO `File` SET "
																			+ "`ano`=?,"
																			+ "`ofile`=?,"
																			+ "`sfile`=?,"
																			+ "`rdate`=NOW()";
		
	public final static String SELECT_FILE = "SELECT * FROM `File` WHERE `fno`=?";
	public final static String DELETE_FILE = "DELETE FROM `File` WHERE `ano`=?";
	
	
	// Product
	public final static String INSERT_PRODUCT = "INSERT INTO `Product` SET "
																			  + "`type`=?,"
																			  + "`pName`=?,"
																			  + "`price`=?,"
																			  + "`delivery`=?,"
																			  + "`stock`=?,"
																			  + "`thumb1`=?,"
																			  + "`thumb2`=?,"
																			  + "`thumb3`=?,"
																			  + "`seller`=?,"
																			  + "`etc`=?,"
																			  + "`rdate`=NOW()";
	
	public final static String SELECT_PRODUCT             = "SELECT * FROM `Product` WHERE `pNo` =?";
	public final static String SELECT_PRODUCTS_ALL        = "SELECT * FROM `Product` WHERE `stock` > 0 LIMIT ?,10 ";
	public final static String SELECT_PRODUCTS_TYPE       = "SELECT * FROM `Product` WHERE `stock` > 0 AND `type`=? LIMIT ?,10";
	public final static String SELECT_COUNT_PRODUCTS_ALL  = "SELECT COUNT(*) FROM `Product` WHERE `stock` > 0";
	public final static String SELECT_COUNT_PRODUCTS_TYPE = "SELECT COUNT(*) `Product` WHERE `stock` > 0 AND `type`=?";
	
	// Order
	public final static String INSERT_ORDER =  "INSERT INTO `Order` SET"    
																				+ "`orderProduct`=?,"
																				+ "`orderCount`=?,"
																				+ "`orderDelivery`=?,"
																				+ "`orderPrice`=?,"
																				+ "`orderTotal`=?,"
																				+ "`receiver`=?,"
																				+ "`hp`=?,"
																				+ "`zip`=?,"
																				+ "`addr1`=?,"
																				+ "`addr2`=?,"
																				+ "`orderEtc`=?,"
																				+ "`orderUser`=?,"
																				+ "`orderDate`=NOW()";
																				
	public final static String SELECT_ORDERS = "SELECT"
																				+ "a.*,"
																				+ "b.`pName`,"
																				+ "b.`thumb1`,"
																				+ "FROM `Order` AS a "
																				+ "JOIN `Product` AS b "
																				+ "ON a.orderProduct = b.No "
																				+ "LIMIT ?, 10";
																				
	public final static String SELECT_COUNT_ORDERS = "SELECT COUNT(*) FROM `Order`";
	public final static String DELETE_ORDER = "DELETE FROM `Order` WHERE `orderNo`=?";


	// comment
	public final static String SELECT_COMMENT_LATEST2 = "SELECT `content`,`rdate` FROM `Article` "
																				+ "WHERE `parent`= ? AND `cate`=? "
																				+ "Order BY `no` DESC LIMIT ?";
																		
	public final static String SELECT_COMMENT_LATEST = "SELECT "
														+ "a.*, "
														+ "b.`nick` "
														+ "FROM `Article` AS a "
														+ "JOIN `User` AS b ON a.writer = b.uid "
														+ "WHERE `parent`!=0 "
														+ "ORDER BY `no` DESC LIMIT 1"; 
}
