package br.com.reconecta.gateway;

import br.com.reconecta.entrypoint.dto.ApplicationDto;

public interface ApplicationGateway {
	public void save(ApplicationDto dto);
}
