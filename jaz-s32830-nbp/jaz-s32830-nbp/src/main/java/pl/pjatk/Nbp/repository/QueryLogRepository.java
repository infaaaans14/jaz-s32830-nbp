package pl.pjatk.Nbp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.Nbp.model.QueryLog;

@Repository
public interface QueryLogRepository extends JpaRepository<QueryLog, Long> {
}