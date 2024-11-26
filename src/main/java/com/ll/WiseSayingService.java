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
      int index = wsr.explore(id);

       wsr.modify(newC,newA,index);
    }

//    public void upDate(){
//        wsr.upDate();
//    }
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
