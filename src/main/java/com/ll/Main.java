package com.ll;
import java.util.Scanner;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        App app =new App();
        app.run();
    }
}

class WiseSaying{
    String saying;
    String writer;
    int num;
    WiseSaying(String saying,String writer,int num){
        this.saying= saying;
        this.writer = writer;
        this.num = num;
    }
}
class App{
    List<WiseSaying> list = new ArrayList<>();
    Scanner sc =new Scanner(System.in);

    public void run(){

        boolean flag = true;
        int count=1;

        while(flag){
            System.out.println("== 명언 앱 ==");
            System.out.printf("명령)");
            String cmd = sc.nextLine();//가나다라
            switch(cmd){
                case "등록":
                    add(count);
                    break;
                case "종료":
                    flag=false;
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    for(int i=list.size()-1;i>=0;i--){
                        WiseSaying tmp = list.get(i);
                        System.out.println(tmp.num +" / " +tmp.writer+" / "+tmp.saying);
                    }
                    break;
                case "삭제":

                    break;

            }
        }
    }

    public void add(int count){
        System.out.printf("명언 : ");
        String say = sc.nextLine();
        System.out.printf("작가 : ");
        String writer = sc.nextLine();
        WiseSaying ws = new WiseSaying(say,writer,count++);
        list.add(ws);
        System.out.println(ws.num+"번 명언이 등록되었습니다.");
    }
}