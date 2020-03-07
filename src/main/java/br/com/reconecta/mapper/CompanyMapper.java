package br.com.reconecta.mapper;

import br.com.reconecta.entrypoint.dto.CompanyDto;
import br.com.reconecta.repository.entity.CompanyEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyMapper {

	public static CompanyEntity from(CompanyDto dto) {
		return CompanyEntity.builder().name(dto.getName()).build();
	}

}
