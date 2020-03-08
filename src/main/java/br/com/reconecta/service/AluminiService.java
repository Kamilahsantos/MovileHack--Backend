package br.com.reconecta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reconecta.entrypoint.dto.AluminiDto;
import br.com.reconecta.gateway.AluminiGateway;
import br.com.reconecta.mapper.AluminiMapper;
import br.com.reconecta.repository.AluminiRepository;
import br.com.reconecta.repository.entity.AluminiEntity;

@Component
public class AluminiService implements AluminiGateway {

	private AluminiRepository repository;

	@Autowired
	public AluminiService(AluminiRepository repository) {
		this.repository = repository;
	}

	@Override
	public AluminiDto save(AluminiDto dto) {
		AluminiEntity entitySaved = repository.save(AluminiMapper.from(dto));
		return AluminiMapper.from(entitySaved);
	}

	@Override
	public List<AluminiDto> getAll() {
		List<AluminiEntity> listEntity = repository.findAll();
		return AluminiMapper.from(listEntity);
	}

	@Override
	public AluminiDto getById(Long id) {
		Optional<AluminiEntity> entityFounded = repository.findById(id);

		if (entityFounded.isPresent())
			return AluminiMapper.from(entityFounded.get());

		return AluminiDto.builder().build();
	}

}
