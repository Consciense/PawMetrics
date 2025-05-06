package barnyard.pawmetrics.repository;

import barnyard.pawmetrics.domain.entity.BloodTestResult;
import barnyard.pawmetrics.domain.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<BloodTestResult, Long> {
    List<BloodTestResult> getBloodTestResultsByPet(Pet pet);
}
