package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInterface extends JpaRepository<User, Integer> {

}
