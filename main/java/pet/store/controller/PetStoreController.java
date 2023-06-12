package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;



@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {

	@Autowired //becomes a managed bean
	private PetStoreService petStoreService;
	
	
//CREATE	
	@PostMapping("/pet_store")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData insertPetStore (@RequestBody PetStoreData petStoreData) {
		log.info("Creating pet store {}", petStoreData);
		return petStoreService.savePetStore(petStoreData);
	
	}

	
//UPDATE
	@PutMapping("/pet_store/{petStoreId}")
	public PetStoreData updatePetStoreData(@PathVariable Long petStoreId, @RequestBody PetStoreData petStoreData) {
		petStoreData.setPetStoreId(petStoreId);
		log.info("Updating pet store ()", petStoreId);
		return petStoreService.savePetStore(petStoreData);

	}
	
		
	
////GET	
//	@GetMapping("/pet_store")
//	public List<PetStoreCustomer> retrieveAllCustomers() {
//		log.info("Retrieve all pet store customers.");
//		return petStoreService.retrieveAllCustomers();
//	}
//	
//	@GetMapping("/pet_store/{petStoreId}")
//	public PetStoreCustomer retrieveCustomerById(@PathVariable Long customerId) {
//		log.info("Retrieving pet store customer with ID={}", customerId);
//		return petStoreService.retrieveCustomerById(customerId);
//	}
//
//
////DELETE CUSTOMER
//	@DeleteMapping("/pet_store")
//	public void deleteAllCustomers() {
//		log.info("Attempting to delete all customers.");
//		throw new UnsupportedOperationException("Deleting all customers is not allowed.");
//	}
//	
//	//Delete by Id
//	@DeleteMapping("/pet_store/{petStoreId}")
//	public Map<String, String> deleteCustomerById(@PathVariable Long customerId) {
//		log.info("Deleting customer with ID={}", customerId);
//		
//		petStoreService.deleteCustomerById(customerId);
//		
//		return Map.of("message", "Deletion of customer with ID=" + customerId + " was successful.");
//	}
//
//
//	
////CREATE PET STORE
//	@PostMapping("/customer/{customerId}/store")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public PetStoreData insertPetStore(@PathVariable Long customerId, 
//			@RequestBody PetStoreData petStoreData) {
//		
//	log.info("Creating store {} for customer with ID={}", petStoreData, customerId);
//	
//	return petStoreService.savePetStore(customerId, petStoreData);
//	
//	}
//	
////MODIFY PET STORE
//	@PutMapping("/customer/{customerId}/store/{storeId}")
//	public PetStoreData updatePetStore(@PathVariable Long customerId,
//			@PathVariable Long storeId,
//			@RequestBody PetStoreData petStoreData) {
//	
//	petStoreData.setPetStoreId(storeId);
//		
//	log.info("Updating store {} for customer with ID={}", petStoreData, customerId);
//	
//	return petStoreService.savePetStore(customerId, petStoreData);
//	}
//	
//
////FIND PET STORE
//	@GetMapping("/customer/{customerId}/store/{storeId}")
//	public PetStoreData retrievePetStoreById(@PathVariable Long customerId, 
//			@PathVariable Long storeId) {
//		log.info("Retrieving pet store with ID={} for customer with ID={}", storeId, customerId);
//		
//		return petStoreService.retrievePetStoreById(customerId, storeId);
//	}
//	
//	
}