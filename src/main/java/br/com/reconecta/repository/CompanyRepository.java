package br.com.reconecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reconecta.repository.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

}
