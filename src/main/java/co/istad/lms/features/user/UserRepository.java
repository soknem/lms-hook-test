package co.istad.lms.features.user;




import co.istad.lms.domain.User;
import co.istad.lms.domain.roles.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByAlias(String alias);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByAlias(String alias);


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.isBlocked = :status WHERE u.alias = :alias")
    int updateBlockedStatusById(String alias, boolean status);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.isDeleted = :status WHERE u.alias = :alias")
    int updateDeletedStatusById(String alias, boolean status);

}
