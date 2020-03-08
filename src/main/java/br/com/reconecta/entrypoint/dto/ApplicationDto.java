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
public class ApplicationDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long aluminiId;
	private Long courseId;
}