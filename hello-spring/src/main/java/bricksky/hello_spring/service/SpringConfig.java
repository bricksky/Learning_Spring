package bricksky.hello_spring.service;

import bricksky.hello_spring.repository.JdbcMemberRepository;
import bricksky.hello_spring.repository.JpaMemberRepository;
import bricksky.hello_spring.repository.MemberRepository;
import bricksky.hello_spring.repository.MemoryMemberRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
   private EntityManager em;
//    private DataSource dataSource;
//
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
