package com.ll;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class WiseSayingAppTest {


    @Test
    public void testRegisterCommand() {
        String simulatedInput = "등록\n명언1\n작가1\n종료\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App app = new App();
        app.run();

        String output = outputStream.toString();
        assertTrue(output.contains("등록 완료했습니다."));
    }

    @Test
    public void testListCommand() {
        String simulatedInput = "등록\n명언1\n작가1\n등록\n명언2\n작가2\n목록\n종료\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App app = new App();
        app.run();

        String output = outputStream.toString();
        assertTrue(output.contains("번호 / 작가 / 명언"));
        assertTrue(output.contains("명언1"));
        assertTrue(output.contains("명언2"));
    }

    @Test
    public void testDeleteCommand() {
        String simulatedInput = "등록\n명언1\n작가1\n삭제?id=1\n목록\n종료\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App app = new App();
        app.run();

        String output = outputStream.toString();
        assertTrue(output.contains("1번 명령어가 삭제되었습니다."));
        assertFalse(output.contains("명언1"));
    }
    @Test
    public void testModifyCommand() {
        String simulatedInput = "등록\n명언1\n작가1\n수정?id=1\n수정된 명언\n수정된 작가\n목록\n종료\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App app = new App();
        app.run();

        String output = outputStream.toString();
        assertTrue(output.contains("수정되었습니다"));
        assertTrue(output.contains("수정된 명언"));
        assertTrue(output.contains("수정된 작가"));
    }
    @Test
    public void testExitCommand() {
        String simulatedInput = "종료\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App app = new App();
        app.run();

        String output = outputStream.toString();
        assertTrue(output.contains("APP이 종료되었습니다"));
    }
}
