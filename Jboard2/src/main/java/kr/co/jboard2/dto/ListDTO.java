package kr.co.jboard2.dto;

public class ListDTO {
	
		private int start; 
		private int currentPage;
		private int total;
		private int lastPageNum; 
		private int pageGroupCurrent;
		private int pageGroupStart; 
		private int pageGroupEnd; 
		private int pageStartNum;
		private String rdate;
		
		public String getRdate() {
			return rdate;
		}
		public void setRdate(String rdate) {
			this.rdate = rdate;
		}
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public int getLastPageNum() {
			return lastPageNum;
		}
		public void setLastPageNum(int lastPageNum) {
			this.lastPageNum = lastPageNum;
		}
		public int getPageGroupCurrent() {
			return pageGroupCurrent;
		}
		public void setPageGroupCurrent(int pageGroupCurrent) {
			this.pageGroupCurrent = pageGroupCurrent;
		}
		public int getPageGroupStart() {
			return pageGroupStart;
		}
		public void setPageGroupStart(int pageGroupStart) {
			this.pageGroupStart = pageGroupStart;
		}
		public int getPageGroupEnd() {
			return pageGroupEnd;
		}
		public void setPageGroupEnd(int pageGroupEnd) {
			this.pageGroupEnd = pageGroupEnd;
		}
		public int getPageStartNum() {
			return pageStartNum;
		}
		public void setPageStartNum(int pageStartNum) {
			this.pageStartNum = pageStartNum;
		} 
		

}
