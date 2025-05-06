package barnyard.pawmetrics.mapper;

import barnyard.pawmetrics.domain.dto.BloodTestResultDTO;
import barnyard.pawmetrics.domain.entity.BloodTestResult;
import org.springframework.stereotype.Component;

@Component
public class BloodTestMapperImplemented implements BloodTestMapper {

    @Override
    public BloodTestResult toEntity(BloodTestResultDTO dto) {
        return BloodTestResult.builder()
                .erythrocytes(dto.getErythrocytes())
                .hemoglobin(dto.getHemoglobin())
                .leukocytes(dto.getLeukocytes())
                .neutrophils(dto.getNeutrophils())
                .lymphocytes(dto.getLymphocytes())
                .monocytes(dto.getMonocytes())
                .eosinophils(dto.getEosinophils())
                .date(dto.getDate())
                .build();
    }

    @Override
    public BloodTestResultDTO toDTO(BloodTestResult bloodTestResult) {
        return BloodTestResultDTO.builder()
                .erythrocytes(bloodTestResult.getErythrocytes())
                .hemoglobin(bloodTestResult.getHemoglobin())
                .leukocytes(bloodTestResult.getLeukocytes())
                .neutrophils(bloodTestResult.getNeutrophils())
                .lymphocytes(bloodTestResult.getLymphocytes())
                .monocytes(bloodTestResult.getMonocytes())
                .eosinophils(bloodTestResult.getEosinophils())
                .date(bloodTestResult.getDate())
                .build();
    }
}
