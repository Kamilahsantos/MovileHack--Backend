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
public class CourseSaveDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String dateCourse;

	private int numberStudent;

	private String dateExpiration;

	private Long companyID;

	private boolean active;

}
