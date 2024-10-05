package kg.mega.petproject1.repository;

import kg.mega.petproject1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("from User where username = :username")
    User loadByUsername(String username);
}
