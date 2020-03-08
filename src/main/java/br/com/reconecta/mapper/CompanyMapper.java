package br.com.reconecta.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.reconecta.entrypoint.dto.CompanyDto;
import br.com.reconecta.entrypoint.dto.CompanySaveDto;
import br.com.reconecta.repository.entity.CompanyEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyMapper {

	public static CompanyEntity from(CompanyDto dto) {
		return CompanyEntity.builder().cnpj(dto.getCnpj()).build();
	}

	public static CompanyEntity from(CompanySaveDto dto) {
		return CompanyEntity.builder().cnpj(dto.getCnpj()).build();
	}

	public static CompanyDto from(CompanyEntity entity) {
		return CompanyDto.builder().id(entity.getId()).cnpj(entity.getCnpj()).build();
	}

	public static List<CompanyDto> from(List<CompanyEntity> listEntity) {
		return listEntity.stream().map(CompanyMapper::from).collect(Collectors.toList());
	}

}
