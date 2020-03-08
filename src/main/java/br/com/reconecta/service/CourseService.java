package br.com.reconecta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reconecta.entrypoint.dto.CompanyDto;
import br.com.reconecta.entrypoint.dto.CourseDto;
import br.com.reconecta.entrypoint.dto.CourseSaveDto;
import br.com.reconecta.gateway.CourseGateway;
import br.com.reconecta.mapper.CourseMapper;
import br.com.reconecta.repository.CompanyRepository;
import br.com.reconecta.repository.CourseRepository;
import br.com.reconecta.repository.entity.CompanyEntity;
import br.com.reconecta.repository.entity.CourseEntity;

@Component
public class CourseService implements CourseGateway {

	private CourseRepository repository;
	private CompanyRepository companyRepository;

	@Autowired
	public CourseService(CourseRepository repository, CompanyRepository companyRepository) {
		this.repository = repository;
		this.companyRepository = companyRepository;
	}

	@Override
	public void save(CourseSaveDto dto) {
		CompanyEntity companyEntity = companyRepository.findById(dto.getCompanyID()).get();
		CourseEntity courseEntity = CourseMapper.fromSave(dto);
		courseEntity.setCompany(companyEntity);
		repository.save(courseEntity);
	}

	@Override
	public List<CourseDto> getAll() {
		List<CourseEntity> listReturn = repository.findAll();
		return CourseMapper.from(listReturn);
	}

	@Override
	public CompanyDto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
