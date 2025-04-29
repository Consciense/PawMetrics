package barnyard.pawmetrics.service;

import barnyard.pawmetrics.domain.entity.PetType;
import barnyard.pawmetrics.repository.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetTypeService {
    @Autowired
    private PetTypeRepository petTypeRepository;

    public void add(PetType petType) {
        if (!petTypeRepository.existsByPetTypeName(petType.getPetTypeName())) {
            petTypeRepository.save(petType);
        }
        else throw new RuntimeException("Pet type already exists");
    }

    public List<PetType> getAllTypes() {
        return petTypeRepository.findAll();
    }

    public PetType findByPetType(String petTypeName) {
        return petTypeRepository.findByPetTypeName(petTypeName).orElseThrow(() -> new RuntimeException("Pet type not found"));
    }

    public void deleteByPetType(String petTypeName) {
        if (petTypeRepository.existsByPetTypeName(petTypeName))
            petTypeRepository.deletePetTypeByPetTypeName(petTypeName);
    }
}
