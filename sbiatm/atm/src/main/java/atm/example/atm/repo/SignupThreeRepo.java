package atm.example.atm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import atm.example.atm.model.SignupThreeModel;

@Repository
public interface SignupThreeRepo extends JpaRepository<SignupThreeModel, Long> {

}
