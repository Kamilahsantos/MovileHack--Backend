package br.com.reconecta.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`TB_PROFILE`")
public class ProfileEntity implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "profile_id")
	private Long id;

	@Column(name = "country")
	private String country;

	@Column(name = "state")
	private String state;

	@Column(name = "city")
	private String city;

	@Column(name = "description")
	private String description;

	@Column(name = "email")
	private String email;

	@Column(name = "name")
	private String name;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "company_id", nullable = true)
	private CompanyEntity company;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "alumini_id", nullable = true)
	private AluminiEntity alumini;

}
