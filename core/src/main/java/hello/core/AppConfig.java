package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//20210927 스프링으로 전환
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){   //메소드명에서 역할이 드러나고,
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());//생성자 주입-> 20210926 리팩토링
    }
    @Bean
    public MemberRepository memberRepository() {   //구현하는 부분도 db설정 등에 따라 바뀔때 여기만 바꾸면 되고
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
      //  return null;

    }

    @Bean
    public DiscountPolicy discountPolicy() {   //할인정책은 여기서만 바꿔주면 되고
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
