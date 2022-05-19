package com.fundamentos.spring.fundamentos.repository;

import com.fundamentos.spring.fundamentos.entity.User;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u User WHERE u.email=?1")
    Optional<String> findByUserEmail(String email);

    @Query("Select u User WHERE u.name like ?1%")
    List<User> findAndSort(String name , Sort sort);

}
