package com.nighthawk.spring_portfolio.mvc.database.note;

import com.nighthawk.spring_portfolio.mvc.database.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteJpaRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByPerson(Person p);
}

