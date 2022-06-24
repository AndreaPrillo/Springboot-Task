package SPID.demo.repository;

import SPID.demo.entities.Spid;

import SPID.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpidRepository extends JpaRepository<Spid, Long> {




}
