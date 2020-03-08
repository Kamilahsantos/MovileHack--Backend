package br.com.reconecta.gateway;

import br.com.reconecta.entrypoint.dto.ProfileDto;
import br.com.reconecta.repository.entity.ProfileEntity;

public interface ProfileGateway {

	public ProfileEntity save(Object father);

	public ProfileDto getById(Long id);

	public ProfileDto update(ProfileDto profile);

}
