package code.structure.workforce.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import code.structure.workforce.service.dto.Allocation;
import code.structure.workforce.service.dto.Work;
import code.structure.workforce.service.service.WorkforceService;

@RestController
public class WorkforceController {

	@Autowired
	private WorkforceService workforceService;
	
	@RequestMapping(value = "/service/test", method = RequestMethod.GET)
	public String test() {
		System.out.println("Invoked test() method");
		return "Spring Boot RESTful service!";
	}
	
	@RequestMapping(value = "/service/optimum", method = RequestMethod.POST)
	public ResponseEntity<Allocation> findOptimalAllocation(@RequestBody Work work) {
		try {
			System.out.println(work);
			return new ResponseEntity<Allocation>(workforceService.findOptimalAllocation(work), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Allocation>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
