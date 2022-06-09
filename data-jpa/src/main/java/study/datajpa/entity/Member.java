package study.datajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter // @Setter
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String username;

    // 프록시객체가 자동으로 생성될 때 private 일 경우 문제가 생길 수 있음
    protected Member(){
    }

    public Member(String username){
        this.username = username;
    }
//  setter 말고 이런 방식
//    public void changeUsername(String username){
//        this.username = username;
//    }
}
