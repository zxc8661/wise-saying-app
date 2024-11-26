package com.ll;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
//asdfsdfsadfsasfdsfdsfsfsf
public class WiseSayingRepository {
    static private List<WiseSaying> wsList = new ArrayList<>();
    static String BASIC_PATH = "C:/Users/zxc86/Desktop/gittest/wise-saying-app/db/wiseSaying";
    static int count=1;
    public int  add(String content,String author){
        WiseSaying ws =new WiseSaying(count++,content,author);
        wsList.add(ws);
        controlData();
        return ws.getId();
    }

    public boolean delect(int id){
        int index = explore(id);
              if(index==-1){
            return false;
        }
        File file = new File(BASIC_PATH+"/"+id+".json");
        file.delete();
        wsList.remove(index);
        return true;

    }

    public  void modify(String newContent,String newAuthor,int index){
      WiseSaying ws = wsList.get(index);
      ws.setContent(newContent);
      ws.setAuthor(newAuthor);
      controlData();

    }

    public int explore(int id){
        for(int i=0;i<wsList.size();i++){
            WiseSaying ws = wsList.get(i);
            if(ws.getId()==id)return i;
        }
        return -1;
    }

    public List<WiseSaying> list(){
        List<WiseSaying> list = new ArrayList<>(wsList);
        return list;
    }

    public void build(){
         ObjectMapper objectMapper = new ObjectMapper();
         try{
             File file = new File(BASIC_PATH+"/data.json");
             ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
              writer.writeValue(file,wsList);
         }catch (IOException e){
             e.printStackTrace();
         }
    }



    public void controlData(){
        ObjectMapper objectMapper = new ObjectMapper();
        File derectory = new File(BASIC_PATH);
        if(!derectory.exists()) derectory.mkdirs();
        try{
            for(int i=0;i<wsList.size();i++){
                WiseSaying ws = wsList.get(i);
                File file = new File(BASIC_PATH+"/"+(ws.getId())+".json");
                objectMapper.writeValue(file,ws);
                ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
                writer.writeValue(file,ws);
            }
            File file = new File(BASIC_PATH+"/lastId.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write((count-1)+"");
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void clearData(){
        wsList.clear();
        count = 1;

        // Clear file system data
        File directory = new File(BASIC_PATH);
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                file.delete();
            }
        }
    }

    public List<WiseSaying> getList(){
        return wsList;
    }


}
//sdf
