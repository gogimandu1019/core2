package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//      MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);    //appconfig의 환경설정 정보를 가지고 스프링컨테이너에 알아서 개체생성해서 관리
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//config에서 memberservice클래스 꺼내오기

        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = "+ member.getName());
        System.out.println("find member = "+ findMember.getName());
    }
}
