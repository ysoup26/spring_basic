package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member,result);
        //Assertions.assertThat(member).isEqualTo(result);/*버전 차이로 인한 문제가 있는듯*/

        //assertThat(member,is(equalsTo(result)));
        //System.out.println("result = "+(result==member));
    }
}
