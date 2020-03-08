package br.com.reconecta.gateway;

import java.util.List;

import br.com.reconecta.entrypoint.dto.CompanyDto;
import br.com.reconecta.entrypoint.dto.CourseDto;
import br.com.reconecta.entrypoint.dto.CourseSaveDto;

public interface CourseGateway {

	public void save(CourseSaveDto dto);

	public List<CourseDto> getAll();

	public CompanyDto getById(Long id);

}
