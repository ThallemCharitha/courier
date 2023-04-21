package courier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import courier.model.Courier;
import courier.repository.CourierRepo;

@Service
public class CourierService {
	@Autowired
	CourierRepo courierRepo;

	public Courier createCourierDetails(Courier courier) {
		courierRepo.save(courier);
		return courier;
	}

	public List<Courier> courierDetails() {
		List<Courier> courier = courierRepo.findAll();
		return courier;
	}
	public Courier courierDetailsById(int courierId) {
		return courierRepo.findById(courierId).get();
	}
	public Courier updateCourierDetails(Courier courier) {

		courierRepo.save(courier);

		return courier;
	}
	public void deleteCourier(Courier courier) {
		courierRepo.delete(courier);

	}

}
