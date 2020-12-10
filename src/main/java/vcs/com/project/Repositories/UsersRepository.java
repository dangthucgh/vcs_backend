package vcs.com.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vcs.com.project.Entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    Users findByUsername(String username);
}
