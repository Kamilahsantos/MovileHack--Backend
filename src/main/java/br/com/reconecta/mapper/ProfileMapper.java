package br.com.reconecta.mapper;

import java.util.Optional;

import br.com.reconecta.entrypoint.dto.AluminiDto;
import br.com.reconecta.entrypoint.dto.CompanyDto;
import br.com.reconecta.entrypoint.dto.ProfileDto;
import br.com.reconecta.repository.entity.AluminiEntity;
import br.com.reconecta.repository.entity.CompanyEntity;
import br.com.reconecta.repository.entity.ProfileEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProfileMapper {

	public static ProfileEntity fromCompany(ProfileDto dto, CompanyDto companyDto) {
		return ProfileEntity.builder().city(dto.getCity()).country(dto.getCountry()).description(dto.getDescription())
				.email(dto.getEmail()).name(dto.getName()).company(CompanyMapper.from(companyDto)).build();
	}

	public static ProfileDto fromCompany(ProfileEntity entity, CompanyEntity companyEntity) {
		return ProfileDto.builder().city(entity.getCity()).country(entity.getCountry())
				.description(entity.getDescription()).email(entity.getEmail()).name(entity.getName())
				.company(CompanyMapper.from(companyEntity)).build();
	}

	public static ProfileEntity fromAlumini(ProfileDto dto, AluminiDto aluminiDto) {
		return ProfileEntity.builder().city(dto.getCity()).country(dto.getCountry()).description(dto.getDescription())
				.email(dto.getEmail()).name(dto.getName()).alumini(AluminiMapper.from(aluminiDto)).build();
	}

	public static ProfileDto fromAlumini(ProfileEntity entity, AluminiEntity aluminiEntity) {
		return ProfileDto.builder().city(entity.getCity()).country(entity.getCountry())
				.description(entity.getDescription()).email(entity.getEmail()).name(entity.getName())
				.alumini(AluminiMapper.from(aluminiEntity)).build();
	}

	public static ProfileEntity from(ProfileDto dto) {
		return ProfileEntity.builder().id(dto.getId()).city(dto.getCity()).country(dto.getCountry())
				.description(dto.getDescription()).email(dto.getEmail()).name(dto.getName()).build();
	}

	public static ProfileDto from(ProfileEntity entity) {

		if (!Optional.ofNullable(entity).isPresent())
			return ProfileDto.builder().build();

		return ProfileDto.builder().id(entity.getId()).city(entity.getCity()).country(entity.getCountry())
				.description(entity.getDescription()).email(entity.getEmail()).name(entity.getName()).build();
	}

}
