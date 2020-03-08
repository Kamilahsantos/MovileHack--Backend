package br.com.reconecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reconecta.repository.entity.ApplicationEntity;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

}
