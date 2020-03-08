package br.com.reconecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reconecta.repository.entity.AluminiEntity;

public interface AluminiRepository extends JpaRepository<AluminiEntity, Long> {

}
