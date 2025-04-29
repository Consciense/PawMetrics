package barnyard.pawmetrics.mapper;

import barnyard.pawmetrics.domain.dto.AccountDTO;
import barnyard.pawmetrics.domain.dto.RegistrationDTO;
import barnyard.pawmetrics.domain.entity.Account;
import org.mapstruct.*;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {
    Account toEntity(RegistrationDTO dto);
    Account update(@MappingTarget Account account, AccountDTO dto);
}