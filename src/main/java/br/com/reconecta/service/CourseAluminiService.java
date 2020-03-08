package br.com.reconecta.service;

import org.springframework.stereotype.Component;

import br.com.reconecta.entrypoint.dto.CourseAluminiDto;
import br.com.reconecta.entrypoint.dto.CourseSaveDto;
import br.com.reconecta.gateway.CourseAluminiGateway;

@Component
public class CourseAluminiService implements CourseAluminiGateway {

	@Override
	public CourseAluminiDto save(CourseSaveDto dto) {

		return null;

	}

}
