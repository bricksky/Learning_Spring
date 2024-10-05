package bricksky.hello_spring.repository;

import bricksky.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> ,MemberRepository {

    @Override
    Optional<Member> findByname(String Name);
}

