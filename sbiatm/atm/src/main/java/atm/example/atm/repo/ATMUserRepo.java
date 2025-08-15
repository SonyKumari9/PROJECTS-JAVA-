package atm.example.atm.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import atm.example.atm.model.ATMUserModel;

@Repository
public interface ATMUserRepo extends JpaRepository<ATMUserModel, Long> {
    Optional<ATMUserModel> findByCardNoAndPin(String cardNo, String pin);
    Optional<ATMUserModel> findByCardNo(String cardNo);
}
