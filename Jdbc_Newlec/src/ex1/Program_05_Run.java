package ex1;

import java.sql.SQLException;

import com.newlecture.app.console.NoticeConsole;

public class Program_05_Run {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NoticeConsole console = new NoticeConsole();
		
			exit : while(true) {
				console.printNoticeList();
				int menu = console.inputNoticeMenu();
				
				switch (menu) {
				case 1: // 상세조회
					
					break;
					
				case 2: // 이전
					console.movePreviewList();
					break;
					
				case 3: // 다음
					console.moveNextviewList();
					break;
					
				case 4: // 글쓰기
					
					break;
					
				case 5: // 검색
					console.inputSearchWord();
					break;
					
				case 6: // 종료
					System.out.println("프로그램이 종료됩니다.");
					break exit; // break label
		
				default:
					System.out.println("다시 입력해주세요");
					break;
			}
		}
	}
}
