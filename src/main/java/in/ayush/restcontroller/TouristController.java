package in.ayush.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ayush.model.Tourist;
import in.ayush.service.ITouristMgmtService;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

	@Autowired
	private ITouristMgmtService service;

	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist) {

		String resultMsg = service.saveTourist(tourist);
		return new ResponseEntity<String>(resultMsg, HttpStatus.OK);

	}

	@GetMapping("/findAll")
	public ResponseEntity<?> displayTouristDetails() {

		List<Tourist> list = service.fetchAllTourist();
		return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id) {

		Tourist tourist = service.fetchTouristById(id);
		return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);

	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) {

		String msg = service.updateTouristByDetails(tourist);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@PatchMapping("/budgetModify/{id}/{hike}")
	public ResponseEntity<String> modifyTouristBudgetById(@PathVariable("id") Integer id,
			@PathVariable("hike") Float hikePercentage) {

		String msg = service.updateTouristBudgetById(id, hikePercentage);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTouristById(@PathVariable("id") Integer id) {
		String msg = service.deleteTouristById(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
