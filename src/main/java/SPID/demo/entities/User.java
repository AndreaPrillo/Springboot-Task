package SPID.demo.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends Base{

    private String name;
    private String surname;
    private String username;

    private String email;

    private String password;

    private String cardNo;


    public User( LocalDateTime createdAt, String createdBy, String name, String surname, String username, String email, String password, String cardNo) {
        super( createdAt, createdBy);
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.cardNo = cardNo;
    }
}

