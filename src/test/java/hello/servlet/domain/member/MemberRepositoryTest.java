package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);
        //when
        Member saveMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(member.getId());
        Assertions.assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 21);

        Member saveMember1 = memberRepository.save(member1);
        Member saveMember2 = memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        //result 안에 member1, member2가 있는가?
        Assertions.assertThat(result).contains(member1, member2);
    }
}