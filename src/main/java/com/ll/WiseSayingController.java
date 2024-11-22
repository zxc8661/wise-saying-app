package com.ll;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc;
    private final WiseSayingService wss;

    WiseSayingController(Scanner sc){
        this.sc = sc;
        this.wss = new WiseSayingService(sc);
    }
    public void controller(String cmd){
        String []cmds = cmd.split("\\?");

        switch(cmds[0]){
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author= sc.nextLine();

                    wss.add(content,author);
                    System.out.println("등록 완료했습니다.");
                    break;
                case "목록":
                    List<WiseSaying> list= wss.list();
                    System.out.println("번호 / 작가 / 명언");
                    for(int i=list.size()-1;i>=0;i--){
                        WiseSaying ws=list.get(i);
                        System.out.println(ws.getId()+" / "+ws.getAuthor()+" / "+ws.getContent());
                    }
                    break;

                case "종료":
                    System.out.println("APP이 종료되었습니다\n" +
                            "감사합니다.");
                    System.exit(0);
                    break;
                case "삭제":
                    if(cmds.length!=2) {
                        System.out.println("잘못된 입력입니다\n" +
                                "적용할 id를 입력해 주세요");
                    }else {

                        int d_id = Integer.parseInt(cmds[1].substring(3));
                        if(wss.delect(d_id)){
                            System.out.println(d_id+"번 명령어가 삭제되었습니다.");
                        }else{
                            System.out.println(d_id+"번 명언은 존재하지 않습니다.");
                        }
                    }

                    break;
                case "수정":
                    if(cmds.length!=2) {
                        System.out.println("잘못된 입력입니다\n" +
                                "적용할 id를 입력해 주세요");
                    }else{
                        int m_id = Integer.parseInt(cmds[1].substring(3));
                       wss.modify(m_id);
                       System.out.println("수정되었습니다");
                    }
                    break;
                case "빌드":   //여기 해야되 11월 21
                    wss.build();
                    System.out.println("data.json 파일의 내용이 갱신되었습니다.");
                    break;
                default:
                    System.out.println("잘못된 명령어를 입력하였습니다.\n" +
                            "명령어는 다음과 같습니다\n" +
                            "등록\n" +
                            "목록\n" +
                            "빌드\n삭제\n수정\n종료\n");

            }
    }
}
