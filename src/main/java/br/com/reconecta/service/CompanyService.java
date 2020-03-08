package br.com.reconecta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reconecta.entrypoint.dto.CompanyDto;
import br.com.reconecta.entrypoint.dto.CompanySaveDto;
import br.com.reconecta.gateway.CompanyGateway;
import br.com.reconecta.mapper.CompanyMapper;
import br.com.reconecta.repository.CompanyRepository;
import br.com.reconecta.repository.ProfileRepository;
import br.com.reconecta.repository.entity.CompanyEntity;
import br.com.reconecta.repository.entity.ProfileEntity;

@Component
public class CompanyService implements CompanyGateway {

	private CompanyRepository repository;
	private ProfileRepository profileRepository;

	@Autowired
	public CompanyService(CompanyRepository repository, ProfileRepository profileRepository) {
		this.repository = repository;
		this.profileRepository = profileRepository;
	}

	@Override
	public CompanyDto save(CompanySaveDto dto) {
		CompanyEntity entitySaved = repository.save(CompanyMapper.from(dto));
		ProfileEntity profileEntity = ProfileEntity.builder().company(entitySaved).build();
		profileRepository.save(profileEntity);
		return CompanyMapper.from(entitySaved);
	}

	@Override
	public List<CompanyDto> getAll() {
		List<CompanyEntity> listEntity = repository.findAll();
		return CompanyMapper.from(listEntity);
	}

	@Override
	public CompanyDto getById(Long id) {
		Optional<CompanyEntity> entityFounded = repository.findById(id);

		if (entityFounded.isPresent())
			return CompanyMapper.from(entityFounded.get());

		return CompanyDto.builder().build();
	}

}
