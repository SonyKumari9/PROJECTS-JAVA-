package atm.example.atm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import atm.example.atm.model.SignupModel;

@Repository
public interface SignupRepo  extends JpaRepository<SignupModel, Long>{

}
