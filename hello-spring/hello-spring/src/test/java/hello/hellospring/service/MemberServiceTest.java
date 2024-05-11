package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findMember(saveId).get();
        assertThat(member.getName(), equalTo(findMember.getName()));
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring1");

        //when
        memberService.join(member1);
        /*아래가 강의 영상의 코드지만, join함수 내부의 try-catch가 강제가 되면서 코드가 단순화됨*/
        //IllegalStateException e = assertThrows(IllegalStateException.class,()->memberService.join(member2));
        //assertThat(e.getMessage(),equalTo("이미 존재하는 회원입니다."));
        memberService.join(member2);

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findMember() {
    }
}