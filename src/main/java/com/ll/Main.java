package com.ll;
import java.util.*;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Main {
    public static void main(String[] args) {
        App app =new App();
        app.run();
    }
}

class App {
    public void run(){
        Scanner sc= new Scanner(System.in);
        WiseSayingController wsc= new WiseSayingController(sc);

        while(true){
            System.out.print("== 명언 앱 == \n명령)");
            String cmd = sc.nextLine();
            if(cmd.equals("")){
                System.out.println("잘못 입력하였습니다.\n다시입력해주세요");
                continue;
            }
            cmd=cmd.trim();
            wsc.controller(cmd);

        }
    }
}
