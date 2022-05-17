package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
// JPA 모든 데이터변경, 로직, 실행은 트랜잭션 안에서 for ex) lazy loading
// javax 와 spring 제공 두가지 있음. 이미 스프링 쓰고있으니 스프링
@Transactional(readOnly = true) // 성능 최적화 : 더티체킹 X, 읽기전용 트랜잭션,  데이터 변경 X
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

//    @Autowired // 생성자 하나일 때는 생략 가능
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

//    // setter 인젝션 >> 테스트 용이
//    // BUT 데이터 변조 가능성 >> 생성자 인젝션 ~!~!
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    /**
     * 회원가입
     * @param member
     * @return
     */
    @Transactional // 데이터 변경 default : read_only=false
    public Long join(Member member){
        ValidateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void ValidateDuplicateMember(Member member) {
        // EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원 전체 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 회원 단건 조회
     */
    public Member findOne(Long MemberId){
        return memberRepository.findOne(MemberId);
    }
}
