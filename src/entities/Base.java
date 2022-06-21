package entities;

import java.sql.Timestamp;

public class Base {

    protected long id;
    protected Timestamp createdAt;
    protected String createdBy;

    public Base() {

    }

    public Base(long id, Timestamp createdAt, String createdBy) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
