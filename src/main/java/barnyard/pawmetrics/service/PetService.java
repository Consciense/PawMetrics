package barnyard.pawmetrics.service;

import barnyard.pawmetrics.domain.dto.PetDTO;
import barnyard.pawmetrics.domain.entity.Pet;
import barnyard.pawmetrics.mapper.PetMapper;
import barnyard.pawmetrics.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PetMapper petMapper;
    @Autowired
    private AccountService accountService;

    public void savePet(PetDTO dto) {
        Pet pet = petMapper.toEntity(dto);
        pet.setOwner(accountService.getCurrentUser());
        petRepository.save(pet);
    }

    public List<Pet> getAccountPets() {
        return accountService.getCurrentUser().getPets();
    }

    public Pet getPetById(Long petId) {
        return petRepository.findById(petId).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}

