package br.com.reconecta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reconecta.entrypoint.dto.AluminiDto;
import br.com.reconecta.entrypoint.dto.AluminiSaveDto;
import br.com.reconecta.gateway.AluminiGateway;
import br.com.reconecta.mapper.AluminiMapper;
import br.com.reconecta.repository.AluminiRepository;
import br.com.reconecta.repository.ProfileRepository;
import br.com.reconecta.repository.entity.AluminiEntity;

@Component
public class AluminiService implements AluminiGateway {

	private AluminiRepository repository;
	private ProfileRepository profileRepository;

	@Autowired
	public AluminiService(AluminiRepository repository, ProfileRepository profileRepository) {
		this.repository = repository;
		this.profileRepository = profileRepository;
	}

	@Override
	public AluminiDto save(AluminiSaveDto dto) {
		AluminiEntity entitySaved = repository.save(AluminiMapper.from(dto));
		return AluminiMapper.from(entitySaved);
	}

	@Override
	public List<AluminiDto> getAll() {
		List<AluminiEntity> listEntity = repository.findAll();
		List<AluminiDto> listConverted = AluminiMapper.from(listEntity);
		return listConverted;
	}

	@Override
	public AluminiDto getById(Long id) {
		Optional<AluminiEntity> entityFounded = repository.findById(id);

		if (entityFounded.isPresent())
			return AluminiMapper.from(entityFounded.get());

		return AluminiDto.builder().build();
	}

	@Override
	public AluminiDto updated(AluminiDto dto) {
		AluminiEntity aluminiEntyty = AluminiMapper.fromUpdated(dto);
		AluminiEntity entityupdated = repository.save(aluminiEntyty);
		return AluminiMapper.from(entityupdated);
	}

}
