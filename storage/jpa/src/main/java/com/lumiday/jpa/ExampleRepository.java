package com.lumiday.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ExampleRepository extends JpaRepository<ExampleEntity, Long> {

}
