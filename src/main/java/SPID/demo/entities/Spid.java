package SPID.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "spid")
public class Spid extends Base {

    @OneToOne(cascade = CascadeType.MERGE)
    private User userId;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Type type;

    public Spid( LocalDateTime createdAt, String createdBy, User userId, String description, Status status, Type type) {
        super( createdAt, createdBy);
        this.userId = userId;
        this.description = description;
        this.status = status;
        this.type = type;
    }
}

