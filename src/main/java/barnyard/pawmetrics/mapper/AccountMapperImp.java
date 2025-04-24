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
            Account user = new Account();
            user.setUsername(dto.getUsername());
            user.setPassword(dto.getPassword());
            user.setEmail(dto.getEmail());
            return user;
        }
    }

//    @Override
//    public AccountDTO toDTO(Account user) {
//        return null;
//    }
//
//    @Override
//    public void update(Account account, AccountDTO dto) {
//        if (dto == null) {
//            return;
//        } else {
//            Account user = new Account();
//            user.setUsername(dto.getUsername());
//            user.setPassword(dto.getPassword());
//            return user;
//        }
//    }
//
//    @Override
//    public Account partialUpdate(AccountDTO userDto, Account user) {
//        return null;
//    }
}