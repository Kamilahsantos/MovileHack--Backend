package br.com.reconecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reconecta.repository.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

}
