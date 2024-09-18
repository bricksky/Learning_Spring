package bricksky.hello_spring.repository;

import bricksky.hello_spring.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long Id);
    Optional<Member> findByname(String Name);
    List<Member> findAll();
}
