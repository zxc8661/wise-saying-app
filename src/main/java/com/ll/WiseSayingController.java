package com.ll;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc;
    private final WiseSayingService service;

    WiseSayingController(Scanner sc){
        this.sc = sc;
        this.service = new WiseSayingService(sc);
    }

    public void controller(String cmd){
        String []cmds = cmd.split("[?,=,&]");
        String action = cmds[0];

        switch(action){
                case "등록":
                    handleAdd();
                    break;
                case "목록":
                    handleList(cmds);

                    break;
                case "삭제":
                    handleDelete(cmds);
                    break;
                case "수정":
                    handleModigy(cmds);

                    break;
                case "빌드":   //여기 해야되 11월 21
                    service.build();
                    System.out.println("data.json 파일의 내용이 갱신되었습니다.");
                    break;
                case "초기":
                    service.clear();
                        break;

                default:
                    System.out.println("잘못된 명령어를 입력하였습니다.\n" +
                            "명령어는 다음과 같습니다\n" +
                            "등록\n" +
                            "목록\n" +
                            "빌드\n삭제\n수정\n종료\n");

            }
    }

    private void handleDelete(String[] parts) {
        if (parts.length < 2) {
            System.out.println("적용할 ID를 입력해주세요.");
            return;
        }
        int id = Integer.parseInt(parts[2]);
        if (service.delete(id)) {
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }

    private void handleModigy(String[] parts) {
        if (parts.length < 2) {
            System.out.println("적용할 ID를 입력해주세요.");
            return;
        }

        int id = Integer.parseInt(parts[2]);
        WiseSaying saying = service.getById(id);
        if (saying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존): " + saying.getContent());
        System.out.print("명언: ");
        String newContent = sc.nextLine();

        System.out.println("작가(기존): " + saying.getAuthor());
        System.out.print("작가: ");
        String newAuthor = sc.nextLine();

        service.modify(id, newContent, newAuthor);
        System.out.println("수정되었습니다.");
    }

    public void handleAdd(){
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author= sc.nextLine().trim();

        int id =service.add(content,author);
        System.out.println(id+"번 명언이 등록되었습니다.");

    }
    private void handleList(String[] cmds) {
        List<WiseSaying> list= service.getList();


        if(cmds.length <=1){
            printList(list,0);
        } else if (cmds.length <= 3) {
            int page = Integer.parseInt(cmds[3]);
            printList(list, page-1);
        } else {
            printSelectList(list,cmds[2],cmds[4]);
        }
    }

    private void printSelectList(List<WiseSaying> list,String type, String word) {
        for(WiseSaying ws : list){
            if(type.equals("content") && ws.getContent().contains(word)){
                ws.getAll();
            }else if(type.equals("author") && ws.getAuthor().contains(word)){
                ws.getAll();
            }
        }
    }


    private void printList(List<WiseSaying> list, int page){
       list.sort(((o1, o2) -> Integer.compare(o2.getId(),o1.getId())));

       int totalPage = list.size()/5+1;

       int startIndex = page*5;

       int endIndex = startIndex+5;
       if(endIndex>=list.size()){
           endIndex = list.size();
       }

       System.out.println("""
               번호 / 작가 / 명언
               ----------------------""");

       for(int i=startIndex;i<endIndex;i++){
           WiseSaying ws = list.get(i);
           ws.getAll();
       }
       System.out.println(String.format("""
               ----------------------
               페이지 : [%d] / %d""",page+1,totalPage));

   }





    public void loadFile(){
        service.loadFile();
    }

}
