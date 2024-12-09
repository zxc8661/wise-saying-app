package com.ll;

import com.fasterxml.jackson.core.type.TypeReference;
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
    static String BASIC_PATH = "C:/Users/zxc86/Desktop/devcos/wise-saying-app/db/wiseSaying";
    static int count=1;
    public int  add(String content,String author){
        WiseSaying ws =new WiseSaying(count++,content,author);
        wsList.add(ws);
        saveToFile();
        return ws.getId();
    }

    public boolean delect(int id){
        WiseSaying wiseSaying = getById(id);
        if(wiseSaying == null) return false;
        wsList.remove(wiseSaying);
        saveToFile();
        return true;
    }

    public  void modify(int id, String newContent, String newAuthor){
      WiseSaying ws = getById(id);
      if(ws != null) {
          ws.setContent(newContent);
          ws.setAuthor(newAuthor);
          saveToFile();
      }

    }

    public WiseSaying getById(int id){
        return wsList.stream()
                .filter(ws->ws.getId() ==id)
                .findFirst()
                .orElse(null);
    }

    public List<WiseSaying> getList(){
        List<WiseSaying> list = new ArrayList<>(wsList);
        return list;
    }

    public void build(){
        saveToFile();
    }



    private void saveToFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();

        File directory = new File(BASIC_PATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            for (WiseSaying wiseSaying : wsList) {
                File file = new File(BASIC_PATH + "/" + wiseSaying.getId() + ".json");
                writer.writeValue(file, wiseSaying);
            }

            File file = new File(BASIC_PATH + "/data.json");
            writer.writeValue(file, wsList);
        } catch (IOException e) {
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

    public void loadFile(){
        ObjectMapper objectMapper = new ObjectMapper();
        File file =new File(BASIC_PATH+"/data.json");
        if(!file.exists()){
            return;
        }

        try {
            List<WiseSaying> loadedWiseSayings = objectMapper.readValue(file, new TypeReference<List<WiseSaying>>() {});
            wsList.addAll(loadedWiseSayings);

            // `nextId`를 가장 큰 ID 다음 값으로 설정
            count = wsList.stream().mapToInt(WiseSaying::getId).max().orElse(0) + 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
//sdf
