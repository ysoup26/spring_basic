package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    /*회원가입*/
    public Long join(Member member) {
        //조건: 같은 중복 회원 X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    
    //회원 검증
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    try {
                        throw new IllegalAccessException("이미 존재하는 회원입니다.");
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
    
    /*전체 회원 조회*/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    
    /*회원 조회*/
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }
}
