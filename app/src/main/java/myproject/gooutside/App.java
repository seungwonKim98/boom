package myproject.gooutside;

import java.sql.Date;
import java.util.Scanner;


public class App {

  public static void main(String[] args) {
    Scanner keyboardScan = new Scanner(System.in);


    // 회원 데이터
    final int LENGTH = 100;
    int[] no = new int[LENGTH]; // 회원 번호 
    String[] name = new String[LENGTH]; // 회원 이름
    String[] email = new String[LENGTH]; // 이메일
    String[] password = new String[LENGTH]; // 비밀 번호
    String[] tel = new String[LENGTH]; // 전화 번호
    Date[] registeredDate = new Date[LENGTH]; // 가입일
    int size = 0;

    // 공지 데이터
    int[] nno = new int[LENGTH]; // 게시글 번호
    String[] ntitle = new String[LENGTH]; // 글 제목
    String[] ncontent = new String[LENGTH]; // 글 내용
    String[] nname = new String[LENGTH]; // 작성자 이름
    Date[] nDate = new Date[LENGTH]; // 작성일 

    int nsize = 0;

    // 커뮤니티 데이터

    int[] cno = new int[LENGTH]; // 게시글 번호
    String[] cplace = new String[LENGTH]; // 장소 
    String[] ctitle = new String[LENGTH]; // 제목
    String[] ccontent = new String[LENGTH]; // 게시글 내용
    String[] npassword = new String[LENGTH]; // 암호
    String[] cname = new String[LENGTH]; // 작성자 
    Date[] cdate = new Date[LENGTH]; // 작성일

    // int[] cstatus = new int[LENGTH]; //  상태 

    int csize = 0;



    while(true){
      System.out.print("명령> ");
      String input = keyboardScan.nextLine();

      if(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
        System.out.println("사용해주셔서 감사합니다.");
        break;

      }else if(input.equalsIgnoreCase("/member/add")) {

        System.out.println("[회원 등록]");

        System.out.print("번호? ");
        no[size] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("이름? ");
        name[size] = keyboardScan.nextLine();

        System.out.print("이메일? ");
        email[size] = keyboardScan.nextLine();

        System.out.print("암호? ");
        password[size] = keyboardScan.nextLine();

        System.out.print("전화? ");
        tel[size] = keyboardScan.nextLine();

        registeredDate[size] = new java.sql.Date(System.currentTimeMillis());

        size++;
      }else if(input.equalsIgnoreCase("/member/list")) {
        System.out.println("[회원 목록]");

        for (int i = 0; i < size; i++) {
          // 번호, 이름, 이메일, 전화, 가입일
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              no[i], name[i], email[i], tel[i], registeredDate[i]);
        }

      }else if(input.equalsIgnoreCase("/project/add")){
        System.out.println("[프로젝트 등록]");

        System.out.print("번호? ");
        pno[psize] = Integer.valueOf(keyboardScan.nextLine());

        System.out.print("프로젝트명? ");
        ptitle[psize] = keyboardScan.nextLine();

        System.out.print("내용? ");
        pcontent[psize] = keyboardScan.nextLine();

        System.out.print("시작일? ");
        pstartDate[psize] = Date.valueOf(keyboardScan.nextLine());

        System.out.print("종료일? ");
        pendDate[psize] = Date.valueOf(keyboardScan.nextLine());

        System.out.print("만든이? ");
        powner[psize] = keyboardScan.nextLine();

        System.out.print("팀원? ");
        pmembers[psize] = keyboardScan.nextLine();

        psize++;

      }else if(input.equalsIgnoreCase("/project/list")) {
        System.out.println("[프로젝트 목록]");

        for (int i = 0; i < psize; i++) {
          // 번호, 프로젝트명, 시작일, 종료일, 만든이
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              pno[i], ptitle[i], pstartDate[i], pendDate[i], powner[i]);
        }

      }else if(input.equalsIgnoreCase("/task/add")) {
        System.out.println("[작업 등록]");

        System.out.print("번호? ");
        tno[tsize] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("내용? ");
        tcontent[tsize] = keyboardScan.nextLine();

        System.out.print("마감일? ");
        tdeadline[tsize] = Date.valueOf(keyboardScan.nextLine());

        System.out.println("상태?");
        System.out.println("0: 신규");
        System.out.println("1: 진행중");
        System.out.println("2: 완료");
        System.out.print("> ");
        tstatus[tsize] = Integer.valueOf(keyboardScan.nextLine());

        System.out.print("담당자? ");
        towner[tsize] = keyboardScan.nextLine();

        tsize++;

      }else if(input.equalsIgnoreCase("/task/list")) {
        System.out.println("[작업 목록]");


        for (int i = 0; i < tsize; i++) {
          String stateLabel = null;
          switch (tstatus[i]) {
            case 1:
              stateLabel = "진행중";
              break;
            case 2:
              stateLabel = "완료";
              break;
            default:
              stateLabel = "신규";
          }
          // 번호, 작업명, 마감일, 프로젝트, 상태, 담당자
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              tno[i], tcontent[i], tdeadline[i], stateLabel, towner[i]);
        }


      }else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println();

    }

    keyboardScan.close();
  }
}


