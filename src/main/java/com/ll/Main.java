package com.ll;
import java.util.*;
import java.io.*;
//

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
    public void changeSaying(String saying){
        this.saying=saying;
    }
    public void changeWriter(String writer){
        this.writer=writer;
    }
}
class App{
    List<WiseSaying> list = new ArrayList<>();
    Scanner sc =new Scanner(System.in);
    int count=1;
    public void run(){

        boolean flag = true;

        //git test
        while(flag){
            System.out.println("== 명언 앱 ==");
            System.out.printf("명령)");
            String total = sc.nextLine();//가나다라

            String []cmd = total.split("\\?");
            try {
                switch (cmd[0]) {
                    case "등록":
                        add();

                        break;
                    case "종료":
                        flag = false;
                        break;
                    case "목록":
                        list();
                        break;
                    case "삭제":
                        delect(cmd[1]);
                        break;
                    case "수정":
                        modify(cmd[1]);
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("잘못된 명령어를 입력하였습니다. 다시 입력해 주세요.");
            }
        }
    }
    public void controlFile(int type, int id){
        int index = explower(id);
        WiseSaying ws = list.get(index);

        String filePath = "C:/Users/zxc86/Desktop/gittest/wise-saying-app/db/wiseSaying";
        String fileName = ws.num+".txt";

        File file = new File(filePath,fileName);

        try{
            if(type==1){
                file.createNewFile();
                Writer writer = new FileWriter(file);
                writer.write("id : " + ws.num + "\n");
                writer.write("content : " + ws.saying + "\n");
                writer.write("author : " + ws.writer + "\n");
                writer.close();
            }else if(type==2){
                file.delete();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        //C:\Users\zxc86\Desktop\gittest\wise-saying-app\db\wiseSaying
    }
    public int explower(int num){
        for(int i=0;i<list.size();i++){
            WiseSaying ws = list.get(i);
            if(num==ws.num){
                return i;
            }
        }
        return -1;
    }
    public void modify(String token){
        String[] tokens = token.split("=");
        int num = Integer.parseInt(tokens[1]);
        int index = explower(num);
        if(index!=-1){
            WiseSaying ws = list.get(index);
            System.out.println("명언(기존) : "+ws.saying);
            System.out.print("명언 : ");
            String newsaying=sc.nextLine();
            System.out.println("작가(기존) : "+ws.writer);
            System.out.print("작가 : ");
            String newwriter = sc.nextLine();
            ws.changeSaying(newsaying);
            ws.changeWriter(newwriter);
            controlFile(1,ws.num);
        }else{
            System.out.println(num+"번 명언은 존재하지 않습니다");
        }

    }
    public void add(){
        System.out.printf("명언 : ");
        String say = sc.nextLine();
        System.out.printf("작가 : ");
        String writer = sc.nextLine();
        WiseSaying ws = new WiseSaying(say,writer,count++);
        list.add(ws);
        controlFile(1,ws.num);
        System.out.println(ws.num+"번 명언이 등록되었습니다.");
    }
    public void list(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------");
        for(int i=list.size()-1;i>=0;i--){
            WiseSaying tmp = list.get(i);
            System.out.println(tmp.num +" / " +tmp.writer+" / "+tmp.saying);
        }
    }
    public void delect(String tmp){
        String [] sarr = tmp.split("=");
        int num =Integer.parseInt(sarr[1]);
        int index = explower(num);
        if(index!=-1){
            controlFile(2,num);
            list.remove(index);
            System.out.println(num+"번 명언이 삭제되었습니다.");

        }else{
            System.out.println(num+"번 명언은 존재하지 않습니다");
        }
    }
}