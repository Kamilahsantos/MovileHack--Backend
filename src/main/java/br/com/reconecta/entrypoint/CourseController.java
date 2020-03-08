package br.com.reconecta.entrypoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;	

import br.com.reconecta.entrypoint.dto.CompanyDto;
import br.com.reconecta.entrypoint.dto.CourseDto;
import br.com.reconecta.gateway.CompanyGateway;
import br.com.reconecta.gateway.CourseGateway;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {
	
	private CourseGateway gateway;
	
	@Autowired
	public CourseController(CourseGateway gateway) {
		this.gateway = gateway;
	}
	//getall
	@ApiOperation(value = "Get All Course")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess") })
	@GetMapping(path = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllEndPoint() {
		return ResponseEntity.ok(gateway.getAll());
	}
	//getbyid
	@ApiOperation(value = "Get a course")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess") })
	@GetMapping(path = "/courses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getByIdEndPoint(@PathVariable int id) {
		return ResponseEntity.ok(gateway.getById(id));
	}
	
	
	//post
	@ApiOperation(value = "Save a course")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucess") })
	@PostMapping(path = "/courses", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveEndPoint(@RequestBody CourseDto model) {
		gateway.save(model);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	//put
	@ApiOperation(value = "Update a course")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucess") })
	@PutMapping(path = "/courses/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateEndPoint(@RequestBody CourseDto model) {
		gateway.update(model);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	//delete
	
	@ApiOperation(value = "Delete a course")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess") })
	@DeleteMapping(path = "/courses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteByIdEndPoint() {
		return ResponseEntity.ok(gateway.getAll());
	}


}
