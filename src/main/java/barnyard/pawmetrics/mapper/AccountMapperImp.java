package barnyard.pawmetrics.mapper;

import barnyard.pawmetrics.domain.dto.AccountDTO;
import barnyard.pawmetrics.domain.dto.RegistrationDTO;
import barnyard.pawmetrics.domain.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImp implements AccountMapper {
    @Override
    public Account toEntity(RegistrationDTO dto) {
        if (dto == null) {
            return null;
        } else {
            return Account.builder()
                    .username(dto.getUsername())
                    .password(dto.getPassword())
                    .email(dto.getEmail())
                    .build();
        }
    }

    @Override
    public Account update(Account account, AccountDTO dto) {
        if (dto == null) {
            return null;
        } else {
            account.setUsername(dto.getUsername());
            account.setEmail(dto.getEmail());
            return account;
        }
    }
}