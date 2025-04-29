package barnyard.pawmetrics.repository;

import barnyard.pawmetrics.domain.entity.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long> {
    Optional<PetType> findByPetTypeName(String petTypeName);

    void deletePetTypeByPetTypeName(String petTypeName);

    boolean existsByPetTypeName(String petTypeName);
}
