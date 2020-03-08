package br.com.reconecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reconecta.repository.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

}
