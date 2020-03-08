package br.com.reconecta.entrypoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reconecta.entrypoint.dto.CourseAluminiDto;
import br.com.reconecta.gateway.CourseAluminiGateway;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class CourseAluminiController {

	private CourseAluminiGateway coursegateway;

	@Autowired
	public CourseAluminiController(CourseAluminiGateway coursegateway) {
		this.coursegateway = coursegateway;
	}

	@ApiOperation(value = "Save a Course")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess") })
	@PostMapping(path = "/course", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveEndPoint(@RequestBody CourseAluminiDto model) {
		coursegateway.save(model);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@ApiOperation(value = "Update a Course")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess") })
	@PutMapping(path = "/course/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateEndPoint(@RequestBody CourseAluminiDto model) {
		coursegateway.save(model);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@ApiOperation(value = "Delete a Course")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess") })
	@PostMapping(path = "/course/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteEndPoint(@RequestBody CourseAluminiDto model) {
		coursegateway.save(model);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
