package br.com.reconecta.entrypoint.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String cnpj;
	private List<CourseDto> courses;

}
