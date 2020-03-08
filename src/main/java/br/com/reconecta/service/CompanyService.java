package br.com.reconecta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reconecta.entrypoint.dto.CompanyDto;
import br.com.reconecta.gateway.CompanyGateway;
import br.com.reconecta.mapper.CompanyMapper;
import br.com.reconecta.repository.CompanyRepository;
import br.com.reconecta.repository.entity.CompanyEntity;

@Component
public class CompanyService implements CompanyGateway {

	private CompanyRepository repository;

	@Autowired
	public CompanyService(CompanyRepository repository) {
		this.repository = repository;
	}

	@Override
	public CompanyDto save(CompanyDto dto) {
		CompanyEntity entitySaved = repository.save(CompanyMapper.from(dto));
		return CompanyMapper.from(entitySaved);
	}

}
