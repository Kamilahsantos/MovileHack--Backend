package br.com.reconecta.gateway;

import java.util.List;

import br.com.reconecta.entrypoint.dto.CompanyDto;

public interface CompanyGateway {

	public CompanyDto save(CompanyDto dto);

	public List<CompanyDto> getAll();

	public CompanyDto getById(Long id);

}
