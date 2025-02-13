package co.istad.lms.features.staff;

import co.istad.lms.domain.roles.Staff;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    boolean existsByUuid(String uuid);

    Optional<Staff> findByUuid(String uuid);

}
