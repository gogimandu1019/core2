package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {
    @Test
    void AutoWiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
            //스프링컨테이너 관리되는 빈 없고 아무거나 만든것
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean1 = " + noBean2);
            //스프링컨테이너 관리되는 빈 없고 아무거나 만든것
        }
        
        @Autowired
        public void setNoBean3 (Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
        
    }
}
