package barnyard.pawmetrics.repository;

import barnyard.pawmetrics.domain.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BreedRepository extends JpaRepository<Breed, Long> {
    Optional<Breed> findByBreedName(String breedName);

    void deleteByBreedName(String breedName);

    boolean existsByBreedName(String breedName);
}
