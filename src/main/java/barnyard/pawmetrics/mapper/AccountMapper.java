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
//
//    AccountDTO toDTO(Account user);
//
//    void update(@MappingTarget Account account, AccountDTO dto);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Account partialUpdate(AccountDTO userDto, @MappingTarget Account user);
}