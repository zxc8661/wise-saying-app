package com.ll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingControllerTest {

    @BeforeEach
    void beforeEach() {
        AppTest.clear(); // 테스트 초기화
    }

    @Test
    @DisplayName("등록")
    void t1(){
        final String out = AppTest.run("""
                등록
                현재를 사랑하라
                작가미상
                종료""");
        assertThat(out).contains("명언 :").contains("작가 :").contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록")
    public void t2(){

        final String out = AppTest.run("""
                등록
                현재를 사랑하라
                작가미상
                목록
                종료""");

        assertThat(out).contains("번호 / 작가 / 명언").contains("1 / 작가미상 / 현재를 사랑하라");
    }

@Test
@DisplayName("삭제")
public void  t3() throws Exception{
    final String out =AppTest.run("""
                등록
                현재를 사랑하라
                작가미상
                삭제?id=1
                삭제?id=1
                종료
                """);
    assertThat(out).contains("1번 명언이 삭제되었습니다.").contains("1번 명언은 존재하지 않습니다.");
}

   @Test
   @DisplayName("수정")
   public void  t4() throws Exception{
        final String out =AppTest.run("""
                 등록
                현재를 사랑하라
                작가미상
                수정?id=1
                과거에 집착하지 마라.
                작자미상
                종료
                """);
        assertThat(out).contains("명언(기존) : 현재를 사랑하라").contains("작가(기존) : 작가미상");
   }


       @Test
   @DisplayName("빌드")
   public void  t5() throws Exception{
        final String out =AppTest.run("""
                빌드
                종료
                """);
        assertThat(out).contains("data.json 파일의 내용이 갱신되었습니다.");
   }
}
// 종료 추가