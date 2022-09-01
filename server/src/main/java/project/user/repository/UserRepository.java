package project.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
