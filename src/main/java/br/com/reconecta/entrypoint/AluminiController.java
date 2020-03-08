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

import br.com.reconecta.entrypoint.dto.AluminiDto;
import br.com.reconecta.entrypoint.dto.AluminiSaveDto;
import br.com.reconecta.gateway.AluminiGateway;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Alumini", description = "REST API for Alumini", tags = { "Alumini" })
public class AluminiController {

	private AluminiGateway gateway;

	@Autowired
	public AluminiController(AluminiGateway gateway) {
		this.gateway = gateway;
	}

	@ApiOperation(value = "Save a Alumini")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created") })
	@PostMapping(path = "/alumini", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveEndPoint(@RequestBody AluminiSaveDto model) {
		gateway.save(model);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@ApiOperation(value = "Get All Aluminis")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess") })
	@GetMapping(path = "/aluminis", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AluminiDto>> getAllEndPoint() {
		return ResponseEntity.ok(gateway.getAll());
	}

	@ApiOperation(value = "Get a Alumini")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Founded") })
	@GetMapping(path = "/alumini/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AluminiDto> getByIdEndPoint(@PathVariable Long id) {
		return ResponseEntity.ok(gateway.getById(id));
	}

//	@ApiOperation(value = "Update a Alumini")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated") })
//	@PutMapping(path = "/alumini", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<AluminiDto> updateEndPoint(@RequestBody AluminiDto model) {
//		AluminiDto modelUpdated = gateway.updated(model);
//		return ResponseEntity.ok(modelUpdated);
//	}

}
