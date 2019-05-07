package golf.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
// import lombok.Data;
import lombok.Getter;
import lombok.Setter;
// import lombok.ToString;

@Entity
@Getter
@Setter
// @Data
// @ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 스프링 2.0이상 부터 GenerationType.AUTO에 문제가 있어 IDENTITY로 수정
    private Long id;
    private String name;
    private String username;
    private String password;
    // @CreationTimestamp
    // private Timestamp regdate;
    // @UpdateTimestamp
    // private Timestamp updatedate;
    @Builder 
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
    }
    
    public Account(){}
}