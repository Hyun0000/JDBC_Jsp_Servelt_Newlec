package com.newlecture.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.newlecture.app.entity.Notice;
import com.newlecture.app.service.NoticeService;

public class NoticeConsole {
	
	private NoticeService service = new NoticeService();
	private int page = 1;
	private String searchField = "title";
	private String searchWord= " ";
//====================================================================================================
	public void printNoticeList() throws ClassNotFoundException, SQLException {
		List<Notice> list = service.getList(page, searchField, searchWord);
		int num = 1;
		int count = service.getCount();
		int lastPage = count/10;
		lastPage = count%10 == 0 ? lastPage : (lastPage + 1);
		// lastPage = count%10 > 0 ? lastPage + 1 : lastPage;
		
		System.out.println("=======================================");
		System.out.printf("<공지사항> 총 %d 게시글 \n", count);
		System.out.println("=======================================");
		
		for (Notice notice : list) {
			// 번호. 글제목 / 아이디 / 날짜
			System.out.printf("[%d] id(%d). %s / %s / %s \n", num, notice.getId(), notice.getTitle(), notice.getWriter_id(), notice.getRegdate());
			num++;
		}
		
		System.out.println("=======================================");
		System.out.printf("%d / %d pages\n", page, lastPage);
	}
//====================================================================================================
	public int inputNoticeMenu() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("1.상세조회 / 2.이전 / 3.다음 / 4.글쓰기 / 5.검색 / 6. 종료  > ");
		
		String menuStr = scanner.nextLine();
		int menu = 0;
		
		try {
			menu = Integer.parseInt(menuStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menu;
	}
//====================================================================================================
	public void movePreviewList() {
		if (page == 1) {
			System.out.println("***************************");
			System.out.println("***************************");
			System.out.println("첫 번째 page입니다.");
			System.out.println("***************************");
			System.out.println("***************************");
			return;
		} else {
			page--;
		}
	}
//====================================================================================================
	public void moveNextviewList() throws ClassNotFoundException, SQLException {
		int count = service.getCount();
		int lastPage = count/10;
		lastPage = count%10 == 0 ? lastPage : (lastPage + 1);
		
		if (page == lastPage) {
			System.out.println("***************************");
			System.out.println("***************************");
			System.out.println("마지막 페이지 입니다.");
			System.out.println("***************************");
			System.out.println("***************************");
			return;
		} else {
			page++;
		}
	}
//====================================================================================================
	public void inputSearchWord() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("검색범주(title/writer_id/content) > ");
		searchField = scanner.nextLine();
		
		System.out.print("검색어 > ");
		searchWord = scanner.nextLine();
	}
}