package com.ll;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingService {
    WiseSayingRepository wsr = new WiseSayingRepository();
    Scanner sc;

    WiseSayingService(Scanner sc ){
        this.sc = sc;
    }
    public int add(String content,String author){

        return wsr.add(content,author);
    }

    public boolean delect(int id){
        return wsr.delect(id);
    }
    public List<WiseSaying> list(){
        return wsr.list();
    }
    public void modify(String newC,String newA,int id){
//       List<WiseSaying> tmp = wsr.getList();
      int index = wsr.explore(id);
//       WiseSaying ws = tmp.get(index);
//       System.out.print("명언(기존) : "+ws.getContent()+"\n" +
//               "명언 : ");
//       String newContent = sc.nextLine();
//       System.out.print("작가(기존) : "+ws.getAuthor()+"\n" +
//               "작가 : ");
//       String newAuthor = sc.nextLine();
       wsr.modify(newC,newA,index);
    }
    public void build(){
        wsr.build();
    }
    public WiseSaying getWiseSaying(int id){
        int index =wsr.explore(id);
        List<WiseSaying> wslist = wsr.list();
        return wslist.get(index);
    }
    public void clear(){
        wsr.clearData();
    }
}// 서비스에서 출력과 스케너 사용 금지,
