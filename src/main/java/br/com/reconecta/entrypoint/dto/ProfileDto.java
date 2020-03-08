package br.com.reconecta.entrypoint.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String country;

	private String state;

	private String city;

	private String description;

	private String email;

	private String name;

	private CompanyDto company;

	private AluminiDto alumini;
}
