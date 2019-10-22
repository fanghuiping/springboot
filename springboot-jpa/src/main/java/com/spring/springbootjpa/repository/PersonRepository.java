package com.spring.springbootjpa.repository;


import com.spring.springbootjpa.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    @Query("select p from Person p where p.name = :name")
    Optional<Person> findByNameCustomeQuery(@Param("name") String name);

    String findPersonNameById(Long id);

    void updatePersonNameById(String updatedName, Long id);

    List<Person> findByAgeGreaterThan(int i);
}
