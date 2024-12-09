package com.ll;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingService {
    WiseSayingRepository wsr = new WiseSayingRepository();
    Scanner sc ;
    WiseSayingService(Scanner sc){
        this.sc= sc;
    }

    public void loadFile(){
         wsr.loadFile();
    }

    public int add(String content,String author){
        return wsr.add(content,author);
    }

    public boolean delete(int id){
        return wsr.delect(id);
    }
    public List<WiseSaying> getList(){
        return wsr.getList();
    }
    public void modify(int id,String newContent,String newAuthor){
     wsr.modify(id,newContent,newAuthor);
    }



    public void build(){
        wsr.build();
    }

    public void clear(){
        wsr.clearData();
    }

    public WiseSaying getById(int id) {
        return wsr.getById(id);
    }
}// 서비스에서 출력과 스케너 사용 금지,
