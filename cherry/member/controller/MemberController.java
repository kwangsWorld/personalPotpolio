package com.cherry.member.controller;

import java.util.*;



import com.cherry.main.Main;
import com.cherry.member.service.MemberService;
import com.cherry.member.vo.MemberVo;
import com.cherry.trade.vo.TradeVo;
import com.cherry.util.Color;
import com.cherry.util.Util;

	
public class MemberController {
	
	private final MemberService service;
	
	public MemberController() {
		service = new MemberService();
		
	}
//	// 로그인 창
//	public void loginMenu() {
//		if(Main.loginMember != null || Main.loginManager != null) {
//			memberMenu();
//		}
//		System.out.println("===== 메뉴선택 =====");
//		
//		System.out.print(" 1: 회원가입");
//		System.out.print(" 2: 로그인");	
//		System.out.print(" 3: 아이디 찾기");
//		System.out.println(" 4: 비밀번호 찾기");
//		
//		System.out.print("입력창 :");
//		String num = Main.SC.nextLine();
//		
//		switch(num) {
//		case "1" :join(); break;
//		case "2" :login(); break;
//		case "3" :findId(); break;
//		case "4" :findPwd(); break;
//		default : System.out.println("잘못 입력하였습니다.");
//		}
//	}
	
	//마이 페이지
	public void myPage() {
		boolean x = false;
		while(!x) {
			if(Main.loginMember == null) return;
			System.out.println("============================================== 마이페이지 선택 ==============================================");
			
			System.out.print(" 1.내 정보 보기");	//+닉네임,비밀번호,전화번호,주소 변경 + 회원탈퇴[Dath 구조]
			System.out.print(" 2.로그아웃");
			System.out.print(" 3.구매내역");		//유저가 구매한 내역 확인 
			System.out.print(" 4.관심 목록 조회"); //+관심 목록 제거
			System.out.print(" 5.매너온도");
			System.out.println(" 9.뒤로 가기");
			
			System.out.print("번호를 입력해주세요: ");
			String num = Main.SC.nextLine();
			
			switch(num) {
			case "1" :Info(); break;
			case "2" :logout(); break;
			case "3" :x=purchaseList(); break;
			case "4" :x=wishList(); break;
			case "5" :x=score(); break;
			case "9" :return;
			default : System.out.println("잘못 입력하셨습니다");
			}
		}
		
	}
	
//	//로그인 메뉴 선택
//	public void memberMenu() {
//		System.out.println("===== 로그인 메뉴 선택 =====");
//		
//		System.out.print(" 1: 거래게시판");
//		System.out.print(" 2: 동네생활");
//		System.out.print(" 3: 공지사항");
//		System.out.print(" 4: FAQ");
//		System.out.print(" 5: QnA");
//		System.out.print(" 6: 마이페이지");
//		System.out.println(" 9: 로그아웃");
//		
//		System.out.print("입력창 :");
//		String num = Main.SC.nextLine();
//		
//		switch(num) {
//		case "1" :controller.trade.tradeMain(); break;
//		case "2" :controller.town.selectMenu(); break;
//		case "3" :controller.notice.selectMenu(); break;
//		case "4" :controller.faq.selectMenu(); break;
//		case "5" :controller.qna.selectMenu(); break;
//		case "6" :controller.myPage(); break;
//		case "9" :logout(); break;
//		default : System.out.println("잘못 입력하였습니다.");
//		}
//	}

	// 내정보 보기
	public boolean Info() {
		boolean x = true;
		try {
			//로그인 검사
			if(Main.loginMember == null) {
				throw new Exception("로그인부터 진행해주세요");
			}
			//결과
			System.out.println("============================================ 마이페이지 ============================================");
			System.out.println("아이디 : "+Main.loginMember.getId());
			System.out.println("닉네임 : "+Main.loginMember.getNick());
			System.out.println("이름 : "+Main.loginMember.getName());
			System.out.println("전화번호 : "+Main.loginMember.getPhone());
			System.out.println("이메일 : "+Main.loginMember.getEmail());
			System.out.println("동네명 : "+Main.loginMember.getAreasName());
			System.out.println("가입일시 : "+Main.loginMember.getJoinDate());
			System.out.println("=================================================================================================");
			
			//정보변경
			System.out.println(" 1.비밀번호 변경 2.닉네임 변경 3.주소 변경 4.전화번호 변경 5.회원 탈퇴 9.뒤로가기");
			System.out.print("번호를 입력해주세요: ");
			String num = Main.SC.nextLine();
			
			switch(num) {
			case "1" : changePwd(); break;
			case "2" : changeNick(); break;
			case "3" : changeAddress(); break;
			case "4" : changePhone(); break;
			case "5" : quit(); break;
			case "9" : x=false; break;
			default : System.out.println("잘못 입력하였습니다.");
			}
			
			
		}catch(Exception e) {
			System.out.println("마이페이지 조회 실패");
//			e.printStackTrace();
		}
		return x;
	}

	//회원가입
	public void join() {
		System.out.println("============================================ 회원가입 ============================================");
		try {
			System.out.print("ID : ");
			String id = Main.SC.nextLine();
			System.out.print("PWD : ");
			String pwd = Main.SC.nextLine();
			System.out.print("NICK : ");
			String nick = Main.SC.nextLine();
			System.out.print("NAME : ");
			String name = Main.SC.nextLine();
			System.out.print("EMAIL : ");
			String email = Main.SC.nextLine();
			System.out.print("PHONE : ");
			String match = "[^0-9]";	// 0~9까지 숫자만
			String phone = Main.SC.nextLine().replaceAll(match,"");
			System.out.print("ADRESS[시,구,동 순으로 입력해주세요] : ");
			String adress = Main.SC.nextLine().replace(" ","");
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setNick(nick);
			vo.setName(name);
			vo.setEmail(email);
			vo.setPhone(phone);
			vo.setAddress(adress);
			
			int result = service.join(vo); 
			
			if(result != 1) {
				throw new Exception();
			}
				System.out.println("회원가입 성공");
			
		}catch(Exception e) {
			System.out.println("회원가입 실패");
//			e.printStackTrace();
		}
	}
	//로그인
	public void login() {
		System.out.println("============================================== 로그인 ==============================================");
		
		try {
			if(Main.loginMember != null) {
				System.out.println("이미 로그인 상태입니다.");
				return;
			}
			
			System.out.print("ID : ");
			String id = Main.SC.nextLine();
			System.out.print("PWD : ");
			String pwd = Main.SC.nextLine();
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			
			Main.loginMember = service.login(vo); 
			
			if(Main.loginMember == null) {
				throw new Exception();
			}
			System.out.println("============================================ 로그인 성공 ============================================");
			System.out.println("                                          "+Main.loginMember.getName()+" 님 환영합니다                                          \n");
			
//			memberMenu();

		}catch(Exception e) {
			System.out.println("로그인 실패");
//			e.printStackTrace();
		}
	}
	//로그아웃
	public void logout() {
		System.out.println("=============================================== 로그아웃 ===============================================");

		if(Main.loginMember == null) {
			System.out.println("로그인 상태가 아닙니다");
			return;
		}
		System.out.println("                                            로그아웃 되었습니다                                            \n");

		Main.loginMember = null;
	}
	
	//회원탈퇴
	public void quit() {
		System.out.println("=============================================== 회원탈퇴 ===============================================");
		try {
			
			String no = Main.loginMember.getMemberNo();
			
			int result = service.quit(no);
			
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("                                              회원탈퇴 성공                                              \n");
			logout();
			
		}catch(Exception e) {
			System.out.println("회원탈퇴 실패");
//			e.printStackTrace();
		}
	}

	//비밀번호 변경
	public void changePwd() {
		System.out.println("============================================= 비밀번호 변경 =============================================");
		try {
			
			System.out.print("현재 비밀번호 입력 : ");
			String oldPwd = Main.SC.nextLine();
			
			System.out.print("새로운 비밀번호를 입력하세요 : ");
			String newPwd = Main.SC.nextLine();
		
			String memberNo = Main.loginMember.getMemberNo();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("oldPwd",oldPwd);
			map.put("newPwd",newPwd);
			map.put("memberNo",memberNo);
			
			int result = service.changePwd(map);
			
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("비밀번호 변경 완료");
			logout();
		}catch(Exception e) {
			System.out.println("비밀번호 변경 실패");
//			e.printStackTrace();
		}
	}

	//닉네임 변경
	public void changeNick() {
		System.out.println("============================================= 닉네임 변경 =============================================");
		try {
			
			System.out.print("새로운 닉네임을 입력하세요 : ");
			String newNick = Main.SC.nextLine();
			MemberVo vo = new MemberVo();
			
			vo.setNick(newNick);
			vo.setMemberNo(Main.loginMember.getMemberNo());
			
			//서비스
			int result = service.changeNick(vo);
			
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("닉네임 변경 완료");
			Main.loginMember.setNick(newNick);
			Info();
		}catch(Exception e) {
			System.out.println("닉네임 변경 실패");
//			e.printStackTrace();
		}	
	}
	//주소 변경
	public void changeAddress() {
		System.out.println("============================================== 주소 변경 ==============================================");
		try {
			
			System.out.print("새로운 주소를 입력하세요 [시,구,동 순으로 입력해주세요] : ");
			String newAddress = Main.SC.nextLine().replace(" ","");
			MemberVo vo = new MemberVo();
			vo.setId(Main.loginMember.getId());
			vo.setPwd(Main.loginMember.getPwd());
			vo.setAddress(newAddress);
			vo.setMemberNo(Main.loginMember.getMemberNo());
			
			//서비스
			int result = service.changeAddress(vo);
			
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("                                              주소 변경 완료                                              \n");

			Main.loginMember.setAddress(newAddress);
			Info();
		}catch(Exception e) {
			System.out.println("주소 변경 실패");
//			e.printStackTrace();
		}	
		
	}
	//전화번호 변경
	public void changePhone() {
		System.out.println("============================================ 전화번호 변경 ============================================");
		try {
			
			System.out.print("새로운 전화번호를 입력하세요 : ");
			String match = "[^0-9]";	// 0~9까지 숫자만
			String newPhone = Main.SC.nextLine().replaceAll(match,"");
			MemberVo vo = new MemberVo();
			
			vo.setPhone(newPhone);
			vo.setMemberNo(Main.loginMember.getMemberNo());
			
			//서비스
			int result = service.changePhone(vo);
			
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("                                             전화번호 변경 완료                                             \n");

			Main.loginMember.setPhone(newPhone);
			Info();
		}catch(Exception e) {
			System.out.println("전화번호 변경 실패");
//			e.printStackTrace();
		}	
	}
	
	//구매 내역 리스트
	public boolean purchaseList() {
		boolean x = true;
		
		try {
			//로그인 검사
			if(Main.loginMember == null) {
				throw new Exception("로그인부터 진행해주세요");
			}
			String no = Main.loginMember.getMemberNo();
			List<TradeVo> voList = service.purchaseList(no);
			System.out.println("============================================ 구매 내역 목록 ============================================");
			if(voList.isEmpty()){
				System.out.println("조회된 내용이 없습니다.");
			}else {
				System.out.println("====================================================================================================");
				System.out.println(" 구매번호 || 구매일시  |  판매자닉네임  |  거래 장소  |  상품명  |  가격  "); // 구매후기 작성 여부 추가해야함
				
				for(TradeVo vo : voList) {
					System.out.println(vo.getPurchaseNo() + " | " + vo.getEnrollDate()+" | "+vo.getMemberNick()+" | "+vo.getTradeAreas()+" | "+vo.getProduct()+" | "+vo.getPrice());
				}
				
				System.out.println("====================================================================================================\n\n");
				System.out.println("<메뉴> 1.구매후기작성 9.뒤로가기");
				System.out.print("선택 : ");
				String select = Main.SC.nextLine();
				
				switch(select) {
					case "1" : 
						System.out.print("구매후기 남길 내역 번호 : ");
						String purchaseNo = Main.SC.nextLine();
						writeReview(purchaseNo); break; // 리뷰 작성
					case "9" : break;
					default : System.out.println("잘못입력하셨습니다."); break;
				}
				
			}
			 x =false;
		}catch(Exception e) {
			System.out.println("구매 내역 조회 실패");
//			e.printStackTrace();
		}
		return x;
	}
	
	// 리뷰 작성
	public void writeReview(String purchaseNo) {
		try {
			
			String rv = service.ReviewValidation(purchaseNo);
			
			if(!(Main.loginMember.getMemberNo().equals(rv))) {
				throw new Exception("내역번호없음");
			}
			
	        String manner;
	        
	        System.out.print("구매후기 : " + Color.CYAN);
	        String content = Main.SC.nextLine();
	        System.out.print(Color.EXIT);
	        do {
	            System.out.println("거래는 어땠나요?");
	            System.out.println(Color.YELLOW +"➊" + Color.EXIT + "최고에요 "
	            		  		+ Color.YELLOW +"➋" + Color.EXIT + "평범해요 "
					            + Color.YELLOW +"➌" + Color.EXIT + "별로에요 ");
	            System.out.print("선택 : " + Color.CYAN);
	            manner = Main.SC.nextLine();
	            System.out.print(Color.EXIT);
	
	            if (!(manner.equals("1") || manner.equals("2") || manner.equals("3"))) {
	                System.out.println("잘못입력하셨습니다");
	            }
	           
	        } while (!(manner.equals("1") || manner.equals("2") || manner.equals("3")));

	        int result = service.writeReview(purchaseNo, manner, content); 

			if(result != 1) {
				throw new Exception();
			} 
			
			System.out.println("구매후기 작성 완료");
			
		} catch(Exception e) {
			String ex = e.getMessage();
			System.out.println(Color.RED + "구매후기 작성 실패" + Color.EXIT);
			if(ex.contains("ORA-01722")) {System.out.println("이미 후기를 작성했습니다.");}
			if(ex.contains("내역번호")) {System.out.println("구매내역에 없는 번호입니다.");}
			if(ex.contains("무결성")) {System.out.println("이미 구매후기를 작성하셨습니다.");}
//			e.printStackTrace();
		}

		
	}
	//관심목록 리스트
	public boolean wishList() {
		boolean x = true;
			System.out.println("============================================ 관심 목록 리스트 ============================================");
			try {
				//로그인 검사
				if(Main.loginMember == null) {
					throw new Exception("로그인부터 진행해주세요");
				}
				String no = Main.loginMember.getMemberNo();
				List<TradeVo> voList = service.wishList(no);
				if(voList.isEmpty()) {
					System.out.println("조회된 내용이 없습니다.");
					myPage();
				}else {
					System.out.println("=====================================================================================================\n\n");
					System.out.println("  글번호  |  거래상태  |  게시글명  |  상품  |  가격 ");
					
					for(TradeVo vo : voList) {
						System.out.println(vo.getBoardNo()+" | "+vo.getCompleteYn()+" | "+vo.getTitle()+" | "+vo.getProduct()+" | "+vo.getPrice());
					}
					System.out.println("=====================================================================================================\n\n");
					//관심목록 있을 때 표기 (정보 변경)
					System.out.print(" 1:관심목록 삭제");
					System.out.println(" 9:이전으로 돌아가기");
					System.out.print("번호를 입력해주세요: ");
					String num = Main.SC.nextLine();
					
					switch(num) {
					case "1" : wishDelete(); wishList(); break;
					case "9" : myPage();  break;
					default : System.out.println("잘못 입력하였습니다.");
					}
				}
				
			}catch(Exception e) {
				System.out.println("관심 목록 조회 실패");
//				e.printStackTrace();
			}
		return x;
		
	}
	//관심목록 제거
	public void wishDelete() {
		System.out.println("============================================ 관심 목록 삭제 ============================================");
		try {
			
			System.out.print("삭제할 게시글 번호를 입력해주세요 : ");
			String BoardNo = Main.SC.nextLine();
			String memberNo = Main.loginMember.getMemberNo();
			
			int result = service.wishDelete(memberNo,BoardNo);
			
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("관심 목록 삭제 완료");
			
		}catch(Exception e) {
			System.out.println("관심 목록 삭제 실패");
//			e.printStackTrace();
		}
	}
	//매너온도 (추천수) 확인
	public boolean score() {
		boolean x = true;
		System.out.println("============================================== 매너 온도 ==============================================");
		try {
			//로그인 검사
			if(Main.loginMember == null) {
				throw new Exception("로그인부터 진행해주세요");
			}
			
			String no = Main.loginMember.getMemberNo();
			String score = service.score(no);
			
			if(score == null) {
				score ="36";
//				throw new Exception();
			}
			
			System.out.println("매너 온도 : "+score+"점");
			return false;
		}catch(Exception e) {
			System.out.println("매너 온도 확인 실패");
//			e.printStackTrace();
		}
		return x;
	}
	//아이디 찾기
	public void findId() {
		System.out.println("============================================== 아이디 찾기 ==============================================");
		try {
			System.out.print("사용자 이름 : ");
			String name = Main.SC.nextLine();
			System.out.print("사용자 이메일 : ");
			String Email = Main.SC.nextLine();
			MemberVo vo = new MemberVo();
			vo.setName(name);
			vo.setEmail(Email);
			
			String userID = service.findId(vo);
			
			if(userID == null) {
				throw new Exception();
			}
			System.out.println("\n찾으신 아이디는 "+userID+"입니다.\n");
			
		}catch(Exception e) {
			System.out.println("아이디 찾기 실패");
//			e.printStackTrace();
		}
	}
	//비밀번호 찾기
	public void findPwd() {
		System.out.println("============================================= 비밀번호 찾기 =============================================");
		try {
			System.out.print("사용자 이름 : ");
			String name = Main.SC.nextLine();
			System.out.print("사용자 ID : ");
			String id = Main.SC.nextLine();
			System.out.print("사용자 전화번호 : ");
			String match = "[^0-9]";	// 0~9까지 숫자만
			String phone = Main.SC.nextLine().replaceAll(match,"");
			MemberVo vo = new MemberVo();
			vo.setName(name);
			vo.setId(id);
			vo.setPhone(phone);
			
			String newPwd = service.findPwd(vo);
			
			if(newPwd == null) {
				throw new Exception();
			}
			System.out.println("\n비밀번호를 성공적으로 찾았습니다. 비밀번호를 초기화 진행했습니다.");
			System.out.println(newPwd);
			
		}catch(Exception e) {
			System.err.println("비밀번호  찾기 실패");
//			e.printStackTrace();
		}
	}

}