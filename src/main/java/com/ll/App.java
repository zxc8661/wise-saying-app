package com.ll;

import java.util.Scanner;


public class App {
    public void run(){
        boolean flag = true;
        Scanner sc= new Scanner(System.in);
        WiseSayingController wsc= new WiseSayingController();

        while(flag){
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
