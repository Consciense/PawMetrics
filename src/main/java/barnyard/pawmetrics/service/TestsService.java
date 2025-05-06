package barnyard.pawmetrics.service;

import barnyard.pawmetrics.domain.dto.BloodTestResultDTO;
import barnyard.pawmetrics.domain.entity.BloodTestResult;
import barnyard.pawmetrics.domain.entity.Pet;
import barnyard.pawmetrics.mapper.BloodTestMapper;
import barnyard.pawmetrics.mapper.PetMapper;
import barnyard.pawmetrics.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestsService {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private PetService petService;
    @Autowired
    private BloodTestMapper bloodTestMapper;
    @Autowired
    private ResultsProcessingService resultsProcessingService;
    @Autowired
    private PetMapper petMapper;

    @Transactional
    public void save(BloodTestResultDTO dto) {
        BloodTestResult bloodTestResult = bloodTestMapper.toEntity(dto);
        bloodTestResult.setPet(petService.getPetById(dto.getPetId()));
        testRepository.save(bloodTestResult);
    }

    public Map<Long, String> bindTestResults(List<BloodTestResult> bloodTestResultList ) {
        Map<Long, String> map = new HashMap<>();
        for (BloodTestResult bloodTestResult : bloodTestResultList) {
            StringBuilder result = new StringBuilder();
            for (String conclusion : analyseResults(bloodTestResult)) {
                result.append(conclusion).append("\n");
            }
            map.put(bloodTestResult.getId(), result.toString());
        }
        return map;
    }

    public ArrayList<BloodTestResult> getBloodTestResults(List<Pet> pets) {
        ArrayList<BloodTestResult> bloodTestResults = new ArrayList<>();
        pets.forEach(pet -> bloodTestResults.addAll(testRepository.getBloodTestResultsByPet(pet)));
        return bloodTestResults;
    }

    public ArrayList<String> analyseResults(BloodTestResult result) {
        ArrayList<String> bloodTestResults = new ArrayList<>();
        if (result.getPet().getType().getPetTypeName().equals("dog")) {
            bloodTestResults = resultsProcessingService.getAdditionalInformation(
                    resultsProcessingService.processDogResults(
                            petMapper.toDTO(result.getPet()),
                            bloodTestMapper.toDTO(result)));
        }
        if (result.getPet().getType().getPetTypeName().equals("cat")) {
            bloodTestResults = resultsProcessingService.getAdditionalInformation(
                    resultsProcessingService.processCatResults(
                            bloodTestMapper.toDTO(result)));
        }
        return bloodTestResults;
    }
}
