package com.ll;
import java.util.*;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        App app =new App(sc);

        app.run();
    }
}

class App {
    Scanner sc;
    App (Scanner sc){
        this.sc = sc;
    }
    public void run(){

        WiseSayingController wsc= new WiseSayingController(sc);
//        wsc.upDate();

        while(true){
            System.out.print("== 명언 앱 == \n명령 )");
            if(!sc.hasNextLine()){
                System.out.println("입력 없음");
                break;
            }
            String cmd = sc.nextLine(). trim();
            if(cmd.equals("")){
                System.out.println("잘못 입력하였습니다.\n다시입력해주세요");
                continue;
            }
            wsc.controller(cmd);

        }
    }
}
