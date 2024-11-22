package com.ll;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;
//import java.util.Scanner;


public class AppTest
{
    public static String run (String input){
        final ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        final Scanner scanner =TestUtil.genScanner(input);
        final App app = new App(scanner);

        app.run();
        TestUtil.clearSetOutToByteArray(output);
        return output.toString();
    }

    public static  void clear(){
        WiseSayingRepository wsRepo = new WiseSayingRepository();
        wsRepo.clearData();
    }

}
