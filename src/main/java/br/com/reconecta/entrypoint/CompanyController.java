package br.com.reconecta.entrypoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reconecta.entrypoint.dto.CompanyDto;
import br.com.reconecta.entrypoint.dto.CompanySaveDto;
import br.com.reconecta.gateway.CompanyGateway;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Company", description = "REST API for Company", tags = { "Company" })
public class CompanyController {

	private CompanyGateway gateway;

	@Autowired
	public CompanyController(CompanyGateway gateway) {
		this.gateway = gateway;
	}

	@ApiOperation(value = "Save a Company")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucess") })
	@PostMapping(path = "/company", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveEndPoint(@RequestBody CompanySaveDto model) {
		gateway.save(model);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@ApiOperation(value = "Get All Companys")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess") })
	@GetMapping(path = "/companys", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CompanyDto>> getAllEndPoint() {
		return ResponseEntity.ok(gateway.getAll());
	}

	@ApiOperation(value = "Get a Company")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess") })
	@GetMapping(path = "/company/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDto> getByIdEndPoint(@PathVariable Long id) {
		return ResponseEntity.ok(gateway.getById(id));
	}

}
