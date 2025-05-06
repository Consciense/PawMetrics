package barnyard.pawmetrics.mapper;

import barnyard.pawmetrics.domain.dto.BloodTestResultDTO;
import barnyard.pawmetrics.domain.entity.BloodTestResult;
import org.mapstruct.*;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BloodTestMapper {
    BloodTestResult toEntity(BloodTestResultDTO dto);
    BloodTestResultDTO toDTO(BloodTestResult bloodTestResult);
}
