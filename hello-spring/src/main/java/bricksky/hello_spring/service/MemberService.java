package bricksky.hello_spring.service;

import bricksky.hello_spring.domain.Member;
import bricksky.hello_spring.repository.MemberRepository;
import bricksky.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
    * 회원 가입
    */
    public Long join(Member member){
        // 같은 이름의 중복회원은 불가능
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByname(member.getName())
             .ifPresent(m -> {
                 throw new IllegalStateException("이미 존재하는 회원입니다.");
              });
    }
    /**
     * 전체 회원 조회
    */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
