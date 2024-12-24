package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor

public class OrderServiceImpl implements OrderService {

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    @Autowired
    private DiscountPolicy rateDiscountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
        // System.out.println("1. OrderServiceImpl.OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        // System.out.println("memberRepository = " + memberRepository);
    this.memberRepository = memberRepository;
}

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        // System.out.println("discountPolicy = " + discountPolicy);
    this.discountPolicy = discountPolicy;
}
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
