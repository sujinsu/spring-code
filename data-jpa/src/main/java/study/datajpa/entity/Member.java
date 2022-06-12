package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 연관관계  필드 (team) 등은 X
@ToString(of = {"id","username","age"})
public class Member {

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="team_id")
    private Team team;
    // 프록시객체가 자동으로 생성될 때 private 일 경우 문제가 생길 수 있음


    public Member(String username){
        this.username = username;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null){
            changeTeam(team);
        }
    }

    //  setter 말고 이런 방식
//    public void changeUsername(String username){
//        this.username = username;
//    }

    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }
}
