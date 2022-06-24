package SPID.demo.repository;

import SPID.demo.entities.Spid;
import SPID.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM spid WHERE id = : toFindId ",
            nativeQuery = true)
    public Spid searchSpid(long toFindId );


}
