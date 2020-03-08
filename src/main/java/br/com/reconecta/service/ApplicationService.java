package br.com.reconecta.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.reconecta.entrypoint.dto.ApplicationDto;
import br.com.reconecta.gateway.ApplicationGateway;
import br.com.reconecta.repository.ApplicationRepository;

public class ApplicationService implements ApplicationGateway {

	private ApplicationRepository repository;

	@Autowired
	public ApplicationService(ApplicationRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(ApplicationDto dto) {
		// TODO Auto-generated method stub
	}

}
