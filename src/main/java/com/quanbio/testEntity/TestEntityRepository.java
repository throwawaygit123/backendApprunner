package com.quanbio.testEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {


public boolean existsByNameEntity(String nameEntity);
}
