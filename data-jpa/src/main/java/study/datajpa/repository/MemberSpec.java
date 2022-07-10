package study.datajpa.repository;

import org.springframework.data.jpa.domain.Specification;
import study.datajpa.entity.Member;

public class MemberSpec {

    public static Specification<Member> teamName(final String teamName){
        return (Specification<Member>) (root, query, builder) -> {
            
        }
    }
}
