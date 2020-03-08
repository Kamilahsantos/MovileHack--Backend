package br.com.reconecta.gateway;
import java.util.List;


import br.com.reconecta.entrypoint.dto.CourseDto;

public interface CourseGateway {

	public List<CourseDto> getAll();


	public default CourseDto update(CourseDto model) {
		return model;
		// TODO Auto-generated method stub
		
	}

	public default void save(CourseDto model) {
		// TODO Auto-generated method stub
		
	}


	public default CourseDto getById(int id) {
		return null;
	}


}
