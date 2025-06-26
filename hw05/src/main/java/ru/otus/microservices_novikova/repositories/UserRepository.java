package ru.otus.microservices_novikova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.microservices_novikova.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
