package com.stackroute.favouriteservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.favouriteservice.model.Matches;
import com.stackroute.favouriteservice.service.CricketMatchService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/cricket")
public class CricketMatchController {

	private CricketMatchService cricMatchService;

	@Autowired
	public CricketMatchController(CricketMatchService newsService) {
		this.cricMatchService = newsService;
	}

	@ApiOperation(value = "Saving of Cricket matches", response = Matches.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Saved Cricket Match"),
			@ApiResponse(code = 409, message = "Cricket Match already exist in the records") })
	@PostMapping
	public ResponseEntity<Matches> add(@RequestBody Matches cricketMatch) {
		try {
			return new ResponseEntity<>(cricMatchService.addCricketMatch(cricketMatch), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@ApiOperation(value = "Retrieving of Cricket matches", response = Matches.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Cricket Matches"),
			@ApiResponse(code = 404, message = "Cricket Match not found in the records") })
	@GetMapping
	public ResponseEntity<Matches> getMatchesById(@RequestParam String uniqueId) {
		try {
			return new ResponseEntity<>(cricMatchService.getAllCricketMatches(uniqueId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Delete API for cricket match", response = Matches.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Cricket Matches"),
			@ApiResponse(code = 404, message = "Cricket Match not found in the records") })
	@DeleteMapping("/{uniqueId}")
	public ResponseEntity<String> deleteAllNews(@PathVariable String uniqueId) {
		try {

			if (cricMatchService.deleteCricketMatchByUniqueId(uniqueId)) {
				return new ResponseEntity<>("Cricket Match deleted successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Cricket Match not found in the record ", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Cricket Match not found in the record ", HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Updation of Cricket match API ", response = Matches.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Update Cricket match Successfully"),
			@ApiResponse(code = 404, message = "Cricket Match not found in the records") })
	@PutMapping("/{uniqueId}")
	public ResponseEntity<String> update(@RequestBody Matches cricketMatchDto) {
		try {
			if (cricMatchService.updateCricketMatches(cricketMatchDto)) {
				return new ResponseEntity<String>("Match Update successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
