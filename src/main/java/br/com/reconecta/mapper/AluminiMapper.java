package br.com.reconecta.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.reconecta.entrypoint.dto.AluminiDto;
import br.com.reconecta.entrypoint.dto.AluminiSaveDto;
import br.com.reconecta.repository.entity.AluminiEntity;
import br.com.reconecta.repository.entity.ProfileEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AluminiMapper {

	public static AluminiEntity from(AluminiDto dto) {
		return AluminiEntity.builder().cpf(dto.getCpf()).build();
	}

	public static AluminiEntity from(AluminiSaveDto dto) {
		return AluminiEntity.builder().cpf(dto.getCpf()).profile(ProfileEntity.builder().build()).build();
	}

	public static AluminiEntity fromUpdated(AluminiDto dto) {
		return AluminiEntity.builder().cpf(dto.getCpf()).profile(ProfileMapper.from(dto.getProfile())).build();
	}

	public static AluminiDto from(AluminiEntity entity) {
		return AluminiDto.builder().id(entity.getId()).cpf(entity.getCpf())
				.profile(ProfileMapper.from(entity.getProfile())).build();
	}

	public static List<AluminiDto> from(List<AluminiEntity> listAluminiEntity) {
		return listAluminiEntity.stream().map(AluminiMapper::from).collect(Collectors.toList());
	}

}
