package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
//        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        MemberRepository getMemberRepository = ac.getBean("getMemberRepository", MemberRepository.class);


        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = memberService.getMemberRepository();

        System.out.println("memberService -> memberRepository1: " + memberRepository1);
        System.out.println("orderService -> memberRepository2: " + memberRepository2);
        System.out.println("memberRepository: " + getMemberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(getMemberRepository);
        assertThat(memberService.getMemberRepository()).isSameAs(getMemberRepository);
    }

    @Test
    void configurationDeep(){
       ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
       AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}

