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
public class CourseAluminiDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id_course_alumini;
	private int id_company;
	private int alumini;
	private int id_course;
	private boolean match;

}
