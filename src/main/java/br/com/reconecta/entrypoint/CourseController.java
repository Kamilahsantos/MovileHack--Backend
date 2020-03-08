package br.com.reconecta.entrypoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reconecta.entrypoint.dto.CourseDto;
import br.com.reconecta.entrypoint.dto.CourseSaveDto;
import br.com.reconecta.gateway.CourseGateway;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Course", description = "REST API for Course", tags = { "Course" })
public class CourseController {

	private CourseGateway gateway;

	@Autowired
	public CourseController(CourseGateway gateway) {
		this.gateway = gateway;
	}

	@ApiOperation(value = "Save a Course")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucess") })
	@PostMapping(path = "/course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveEndPoint(@RequestBody CourseSaveDto model) {
		gateway.save(model);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@ApiOperation(value = "Get All Courses")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucess") })
	@GetMapping(path = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CourseDto>> getAllEndPoint() {
		return ResponseEntity.ok(gateway.getAll());
	}

}
