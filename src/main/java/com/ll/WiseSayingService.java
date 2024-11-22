package com.ll;

import java.util.List;
import java.util.Scanner;

public class WiseSayingService {
    WiseSayingRepository wsr = new WiseSayingRepository();
    Scanner sc;

    WiseSayingService(Scanner sc ){
        this.sc = sc;
    }
    public void add(String content,String author){
        wsr.add(content,author);
    }

    public boolean delect(int id){
        return wsr.delect(id);
    }
    public List<WiseSaying> list(){
        return wsr.list();
    }
    public void modify(int id){
       List<WiseSaying> tmp = wsr.getList();
       int index = wsr.explore(id);
       WiseSaying ws = tmp.get(index);
       System.out.print("명언(기존) : "+ws.getContent()+"\n" +
               "명언 : ");
       String newContent = sc.nextLine();
       System.out.print("작가(기존) :"+ws.getAuthor()+"\n" +
               "작가 : ");
       String newAuthor = sc.nextLine();
       wsr.modify(newContent,newAuthor,index);
    }
    public void build(){
        wsr.build();
    }
}
