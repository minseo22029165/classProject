package guestbook.model;

import java.util.List;

public class MessageListView {
	public int messageTotalCount; // 게시물의 전체 개수 : 페이지 개수
	private int currentPageNumber; // 현재 페이지 번호  : List<Message>
	private List<Message> messageList;  // 페이지 번호에 맞는  게시물의 리스트 3개씩
	private int pageTotalCount; // 페이지 전체 개수 
	private int messageCountPerPage; // 한페이지에 몇개의 게시물이 들어가는지 
	private int firstRow;   // db에서 테이블의 시작행 
	private int endRow;  // oracle 일때만  필요
	
	public MessageListView(int messageTotalCount, int currentPageNumber, List<Message> messageList,
			int messageCountPerPage, int firstRow, int endRow) {
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageList = messageList;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calculatePageTotalCount();
	}
	
	// 
	private void calculatePageTotalCount() {
		if(messageTotalCount ==0) {
			pageTotalCount = 0;
		}else {
			pageTotalCount = messageTotalCount / messageCountPerPage;
			
			if(messageTotalCount % messageCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}
	
	public boolean isEmpty() {
		return messageTotalCount==0;
		
	}
}
