package barnyard.pawmetrics.service;

import barnyard.pawmetrics.domain.entity.Breed;
import barnyard.pawmetrics.repository.BreedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BreedService {
    @Autowired
    private BreedRepository breedRepository;

    public void add(Breed breed) {
        if (!breedRepository.existsByBreedName(breed.getBreedName())) {
            breedRepository.save(breed);
        }
        else throw new RuntimeException("Breed already exists");
    }

    public Breed findByBreedName(String breedName) {
        return breedRepository.findByBreedName(breedName).orElseThrow(() -> new RuntimeException("Breed not found"));
    }

    public List<Breed> findAll() {
        return breedRepository.findAll();
    }

    public void deleteByBreedName(String breedName) {
        if (breedRepository.existsByBreedName(breedName))
            breedRepository.deleteByBreedName(breedName);
    }
}

