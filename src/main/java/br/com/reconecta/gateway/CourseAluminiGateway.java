package br.com.reconecta.gateway;

import br.com.reconecta.entrypoint.dto.CourseAluminiDto;
import br.com.reconecta.entrypoint.dto.CourseSaveDto;

public interface CourseAluminiGateway {
	public CourseAluminiDto save(CourseSaveDto dto);

}
