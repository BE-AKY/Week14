package pet.store.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;


@Service
public class PetStoreService {

	@Autowired
	private PetStoreDao petStoreDao;
	
//CREATE STORE	
	@Transactional(readOnly = false)
	public PetStoreData savePetStore(PetStoreData petStoreData) {
	//	Long petStoreId = petStoreData.getPetStoreId();
		
		PetStore petStore = findOrCreatePetStore(petStoreData.getPetStoreId());
		
		copyFieldsInPetStore(petStore, petStoreData);
			
		PetStore daPetStore = petStoreDao.save(petStore);
		
		return new PetStoreData(daPetStore);
			
	}

		private void copyFieldsInPetStore(PetStore petStore, PetStoreData petStoreData) {
			petStore.setPetStoreId(petStoreData.getPetStoreId());
			petStore.setPetStoreName(petStoreData.getPetStoreName());
			petStore.setPetStorePhone(petStoreData.getPetStorePhone());
			petStore.setPetStoreState(petStoreData.getPetStoreState());
			petStore.setPetStoreCity(petStoreData.getPetStoreCity());
			petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
			petStore.setPetStoreZip(petStoreData.getPetStoreZip());
				
		}

//Get		
	private PetStore findOrCreatePetStore(Long petStoreId) {
		PetStore petStore;
				
			if(Objects.isNull(petStoreId)) {
				petStore = new PetStore();		
			} else {	
				petStore = findPetStoreById(petStoreId);
			}
				
			return petStore;
			}

			
		private PetStore findPetStoreById(Long petStoreId) {
			return petStoreDao.findById(petStoreId).orElseThrow(() -> new NoSuchElementException("Pet store with ID=" + petStoreId + " does not exist."));
			}
	
//	@Transactional(readOnly = true)
//	public List<PetStoreData> retrieveAllPetStores() {
//		return petStoreDao.findAll()
//				.stream()
//				.map(PetStoreData::new)
//				.toList();
//	}
//	
//	@Transactional(readOnly = true)
//	public PetStoreData retrievePetStoreById(Long petStoreId ) {
//		PetStore petStore = findPetStoreById(petStoreId);
//		return new PetStoreData(petStore);
//	}
	
	
	
}
