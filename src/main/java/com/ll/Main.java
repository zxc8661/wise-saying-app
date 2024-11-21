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

//class WiseSaying{
//    int num;
//    String saying;
//    String writer;
//
//    WiseSaying(String saying,String writer,int num){
//        this.saying= saying;
//        this.writer = writer;
//        this.num = num;
//    }
//
//    public void setSaying(String saying){
//        this.saying = saying;
//    }
//    public void setWriter(String writer){
//        this.writer = writer;
//    }
//    public void setNum(int num){
//        this.num = num;
//    }
//    public int getNum(){
//        return this.num;
//    }
//    public String getSaying(){
//        return this.saying;
//    }
//    public String getWriter(){
//        return this.writer;
//    }
//
//}
//class App{
//    static String BASIC_PATH = "C:/Users/zxc86/Desktop/gittest/wise-saying-app/db/wiseSaying";
//    List<WiseSaying> list = new ArrayList<>();
//    Scanner sc =new Scanner(System.in);
//    int count=1;
//    public void run(){
//
//        boolean flag = true;
//
//        //git test
//        while(flag){
//            System.out.println("== 명언 앱 ==");
//            System.out.printf("명령)");
//            String total = sc.nextLine();//가나다라
//
//            String []cmd = total.split("\\?");
//            try {
//                switch (cmd[0]) {
//                    case "등록":
//                        add();
//
//                        break;
//                    case "종료":
//                        flag = false;
//                        break;
//                    case "목록":
//                        list();
//                        break;
//                    case "삭제":
//                        delect(cmd[1]);
//                        break;
//                    case "수정":
//                        modify(cmd[1]);
//                        break;
//                    case "빌드":
//                        buildData();
//                        break;
//                }
//            }catch (ArrayIndexOutOfBoundsException e){
//                System.out.println("잘못된 명령어를 입력하였습니다. 다시 입력해 주세요.");
//            }
//        }
//    }
//
//    public void controlData(){
//        String filePath =BASIC_PATH;
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        File derectory = new File(filePath);
//        if(!derectory.exists()) derectory.mkdirs();
//        try {
//            for(int i=0;i<list.size();i++){
//                WiseSaying ws = list.get(i);
//                File file = new File(filePath+"/"+(i+1)+".json");
////                objectMapper.writeValue(file,ws);
//
//                ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
//                writer.writeValue(file,ws);
//            }
//            File file = new File(filePath+"/lastId.txt");
//            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//            writer.write((count-1)+"");
//            writer.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public void delectData(int num){
//        File file = new File(BASIC_PATH+"/"+num+".json");
//        file.delete();
//    }
//
//    public void buildData(){
//        ObjectMapper objectMapper = new ObjectMapper();
//        try{
//           File file = new File(BASIC_PATH+"/data.json");
//
//           ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
//           writer.writeValue(file,list);
//           System.out.println("data.json 파일의 내용이 갱신되었습니다.");
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public int explower(int num){
//        for(int i=0;i<list.size();i++){
//            WiseSaying ws = list.get(i);
//            if(num==ws.num){
//                return i;
//            }
//        }
//        return -1;
//    }
//    public void modify(String token){
//        String[] tokens = token.split("=");
//        int num = Integer.parseInt(tokens[1]);
//        int index = explower(num);
//        if(index!=-1){
//            WiseSaying ws = list.get(index);
//            System.out.println("명언(기존) : "+ws.saying);
//            System.out.print("명언 : ");
//            String newsaying=sc.nextLine();
//            System.out.println("작가(기존) : "+ws.writer);
//            System.out.print("작가 : ");
//            String newwriter = sc.nextLine();
//            ws.setSaying(newsaying);
//            ws.setWriter(newwriter);
//            controlData();
//        }else{
//            System.out.println(num+"번 명언은 존재하지 않습니다");
//        }
//
//    }
//    public void add(){
//        System.out.printf("명언 : ");
//        String say = sc.nextLine();
//        System.out.printf("작가 : ");
//        String writer = sc.nextLine();
//        WiseSaying ws = new WiseSaying(say,writer,count++);
//        list.add(ws);
//        //controlFile(1,ws.num);
//        controlData();
//        System.out.println(ws.num+"번 명언이 등록되었습니다.");
//    }
//    public void list(){
//        System.out.println("번호 / 작가 / 명언");
//        System.out.println("-------------------------");
//        for(int i=list.size()-1;i>=0;i--){
//            WiseSaying tmp = list.get(i);
//            System.out.println(tmp.num +" / " +tmp.writer+" / "+tmp.saying);
//        }
//    }
//    public void delect(String tmp){
//        String [] sarr = tmp.split("=");
//        int num =Integer.parseInt(sarr[1]);
//        int index = explower(num);
//        if(index!=-1){
//            //controlFile(2,num);
//            delectData(num);
//            list.remove(index);
//            System.out.println(num+"번 명언이 삭제되었습니다.");
//
//        }else{
//            System.out.println(num+"번 명언은 존재하지 않습니다");
//        }
//    }
//}