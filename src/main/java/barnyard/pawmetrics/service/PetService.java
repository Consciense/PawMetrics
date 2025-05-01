package barnyard.pawmetrics.service;

import barnyard.pawmetrics.domain.dto.PetDTO;
import barnyard.pawmetrics.domain.entity.Pet;
import barnyard.pawmetrics.mapper.PetMapper;
import barnyard.pawmetrics.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        petRepository.save(petMapper.toEntity(dto));
        accountService.updatePets(petMapper.toEntity(dto));
    }

    public List<Pet> getAccountPets() {
        return accountService.getCurrentUser().getPets();
    }

    public void deleteByName(String petName) {
        accountService.deletePet(petName);
        petRepository.deletePetByName(petName);
    }
}
