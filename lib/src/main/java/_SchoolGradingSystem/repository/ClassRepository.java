package _SchoolGradingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import _SchoolGradingSystem.entity.SchoolClassEntity;

@Repository
public interface ClassRepository extends JpaRepository<SchoolClassEntity, Long> {

}