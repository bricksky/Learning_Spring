package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<String, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
    store.put(member.getName(), member);
    }

    @Override
    public Member findById(Long memberId) {
       return store.get(memberId);
    }
}
