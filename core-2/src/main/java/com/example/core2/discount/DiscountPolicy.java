package com.example.core2.discount;

import com.example.core2.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
