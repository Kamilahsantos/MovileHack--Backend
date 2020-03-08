package br.com.reconecta.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.ObjectUtils;

import br.com.reconecta.entrypoint.dto.CourseDto;
import br.com.reconecta.entrypoint.dto.CourseSaveDto;
import br.com.reconecta.entrypoint.dto.CourseUpdateDto;
import br.com.reconecta.repository.entity.CourseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseMapper {

	public static CourseEntity fromSave(CourseSaveDto dto) {
		return CourseEntity.builder().active(true).dateCourse(dto.getDateCourse())
				.dateExpiration(dto.getDateExpiration()).name(dto.getName()).numberStudent(dto.getNumberStudent())
				.build();
	}

	public static CourseEntity fromUpdate(CourseUpdateDto dto) {
		return CourseEntity.builder().id(dto.getId()).active(dto.isActive()).dateCourse(dto.getDateCourse())
				.dateExpiration(dto.getDateExpiration()).name(dto.getName()).numberStudent(dto.getNumberStudent())
				.build();
	}

	public static CourseDto from(CourseEntity entity) {

		return CourseDto.builder().id(entity.getId()).active(entity.isActive()).dateCourse(entity.getDateCourse())
				.dateExpiration(entity.getDateExpiration()).name(entity.getName())
				.numberStudent(entity.getNumberStudent()).companyId(entity.getCompany().getId()).build();
	}

	public static CourseUpdateDto fromUpdate(CourseEntity entity) {
		return CourseUpdateDto.builder().id(entity.getId()).active(entity.isActive()).dateCourse(entity.getDateCourse())
				.dateExpiration(entity.getDateExpiration()).name(entity.getName())
				.numberStudent(entity.getNumberStudent()).build();
	}

	public static List<CourseDto> from(List<CourseEntity> listCourseEntity) {
		if (ObjectUtils.isEmpty(listCourseEntity))
			return Collections.emptyList();

		return listCourseEntity.stream().map(CourseMapper::from).collect(Collectors.toList());
	}

}
