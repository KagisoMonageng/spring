package mercurystoreapi.store.user;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<UserClass,Long> {

    @Query("SELECT u FROM UserClass u WHERE u.email = ?1")
    Optional<UserClass> getUserByEmail(String email);
}
