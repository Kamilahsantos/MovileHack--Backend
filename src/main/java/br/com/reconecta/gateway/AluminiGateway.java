package br.com.reconecta.gateway;

import java.util.List;

import br.com.reconecta.entrypoint.dto.AluminiDto;
import br.com.reconecta.entrypoint.dto.AluminiSaveDto;

public interface AluminiGateway {

	public AluminiDto save(AluminiSaveDto dto);

	public List<AluminiDto> getAll();

	public AluminiDto getById(Long id);

	public AluminiDto updated(AluminiDto dto);

}
