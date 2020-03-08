package br.com.reconecta.gateway;

import java.util.List;

import br.com.reconecta.entrypoint.dto.AluminiDto;

public interface AluminiGateway {

	public AluminiDto save(AluminiDto dto);

	public List<AluminiDto> getAll();

	public AluminiDto getById(Long id);

}
