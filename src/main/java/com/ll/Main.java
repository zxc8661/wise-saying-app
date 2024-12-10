package com.ll;
import java.util.*;
import java.io.*;

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
        wsc.loadFile();    // 처음 파일 로드

        while(true){
            System.out.print("\n== 명언 앱 == \n명령 )");
            String cmd = sc.nextLine(). trim();
            if(cmd.isEmpty()){
                System.out.println("잘못입력하였습니다.\n다시 입력해 수제요");
                continue;
            }

            if(cmd.equals("종료")){
                break;
            }
            wsc.controller(cmd);

        }
    }
}
