package courier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import courier.model.Courier;

@Repository
public interface CourierRepo extends JpaRepository<Courier, Integer>{

}
