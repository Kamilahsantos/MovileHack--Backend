package br.com.reconecta.gateway;

import java.util.List;

import br.com.reconecta.entrypoint.dto.CompanyDto;
import br.com.reconecta.entrypoint.dto.CompanySaveDto;

public interface CompanyGateway {

	public void save(CompanySaveDto dto);

	public List<CompanyDto> getAll();

	public CompanyDto getById(Long id);

}
