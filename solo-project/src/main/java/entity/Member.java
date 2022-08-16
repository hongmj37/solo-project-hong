package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Table;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Data
@Table(name = "member")
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int pw;

    private String name;

    private char sex;

    private String company_name;

    private int company_type;

    private int company_location;

    public enum company_type{

    }
    public enum company_location{

    }
}
