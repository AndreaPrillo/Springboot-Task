package entities;

import java.sql.Timestamp;

public class SPID extends Base {

    private USER user;
    private String description;
    private Status status;

    public SPID() {

    }

    public SPID(long id,Timestamp createdAt,USER user, String description, Status status) {
        super(id,createdAt,user.getCreatedBy());
        this.user = user;
        this.description = description;
        this.status = status;
    }

    public USER getUser() {
        return user;
    }

    public void setUser(USER user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SPID{" +
                "user=" + user +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", id=" + id +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
