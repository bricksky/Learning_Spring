package bricksky.hello_spring.service;

import bricksky.hello_spring.domain.Member;
import bricksky.hello_spring.repository.MemberRepository;
import bricksky.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
    * 회원 가입
    */
//    public Long join(Member member){
//        long start = System.currentTimeMillis();
//
//        try{
//            // 같은 이름의 중복회원은 불가능
//            validateDuplicateMember(member);
//            memberRepository.save(member);
//            return member.getId();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("join = " + timeMs + "ms");
//
//        }
//
//    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByname(member.getName())
             .ifPresent(m -> {
                 throw new IllegalStateException("이미 존재하는 회원입니다.");
              });
    }

    /**
     * 전체 회원 조회
    */
//    public List<Member> findMembers(){
//        long start = System.currentTimeMillis();
//        try{
//            return memberRepository.findAll();
//        } finally {
//             long finish = System.currentTimeMillis();
//             long timeMs = finish - start;
//            System.out.println("findMembers = " + timeMs + "ms");
//        }
//    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
