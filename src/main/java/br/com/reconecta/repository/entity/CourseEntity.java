package br.com.reconecta.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "date_course")
	private String dateCourse;

	@Column(name = "n_student")
	private int numberStudent;

	@Column(name = "date_experiration")
	private String dateExpiration;

	@Column(name = "active")
	private boolean active;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private CompanyEntity company;

}
