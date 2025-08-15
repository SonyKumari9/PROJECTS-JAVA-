package atm.example.atm.repo;

import atm.example.atm.model.BankTransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankTransactionRepository extends JpaRepository<BankTransactionModel, Long> {

	@Query("SELECT SUM(CASE " +
		       "WHEN LOWER(b.type) = 'deposit' THEN CAST(b.amount AS double) " +
		       "WHEN LOWER(b.type) = 'withdraw' THEN -CAST(b.amount AS double) " +
		       "ELSE 0 END) " +
		       "FROM BankTransactionModel b WHERE b.accountNo = ?1")
		Double getBalanceByAccountNo(String accountNo);


    List<BankTransactionModel> findByAccountNoOrderByDateDesc(String accountNo);

	BankTransactionModel findTopByAccountNoOrderByDateDesc(String accountNo);
	
	
	BankTransactionModel findTopByPinOrderByDateDesc(String pin);
	
	
	// Check for Balance
	BankTransactionModel findTopByAccountNoAndPinOrderByDateDesc(String accountNo, String pin);
	
	
	


}

