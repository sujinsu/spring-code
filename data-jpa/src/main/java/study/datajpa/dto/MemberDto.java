package study.datajpa.dto;

import study.datajpa.entity.Member;

public class MemberDto {

    private Long id;
    private String username;
    private String teamname;

    public MemberDto(Long id, String username, String teamname) {
        this.id = id;
        this.username = username;
        this.teamname = teamname;
    }

    // Dto 는 entity 봐도됨 >> .map(member -> new MemberDto(member)); >> .map(MemberDto::new);
    public MemberDto(Member member){
        this.id = member.getId();
        this.username = member.getUsername();
    }
}
