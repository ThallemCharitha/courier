package courier.model;


import java.util.Date;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class Courier {
	@Id
	private int courierId;
	@NotNull(message ="Mention Courier Name and it should be in 5 to 30 char")
	public String courierName;
	
	@NotEmpty(message = "Mention courierService ")
	private String courierService;
	
	@Max(message = "maximum 50", value = 50)
	private int courierWeight;
	
	@Past(message = "start should be before current date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date courierDate;
	
	@Length(min = 15,max = 40)
	@NotBlank(message = "Mention Destination")
	private String courierDestination;
	@Min(20)
	@Max(2000)
	private int courierCharges;
	
	public String getCourierName() {
		return courierName;
	}
	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}
	public int getCourierId() {
		return courierId;
	}
	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}
	public String getCourierService() {
		return courierService;
	}
	public void setCourierService(String courierService) {
		this.courierService = courierService;
	}
	public int getCourierWeight() {
		return courierWeight;
	}
	public void setCourierWeight(int courierWeight) {
		this.courierWeight = courierWeight;
	}
	
	public Date getCourierDate() {
		return courierDate;
	}
	public void setCourierDate(Date courierDate) {
		this.courierDate = courierDate;
	}
	public String getCourierDestination() {
		return courierDestination;
	}
	public void setCourierDestination(String courierDestination) {
		this.courierDestination = courierDestination;
	}
	public int getCourierCharges() {
		return courierCharges;
	}
	public void setCourierCharges(int courierCharges) {
		this.courierCharges = courierCharges;
	}
	public Courier(String courierName, int courierId, String courierService, int courierWeight, Date courierDate,
			String courierDestination, int courierCharges) {
		super();
		this.courierName = courierName;
		this.courierId = courierId;
		this.courierService = courierService;
		this.courierWeight = courierWeight;
		this.courierDate = courierDate;
		this.courierDestination = courierDestination;
		this.courierCharges = courierCharges;
	}
	public Courier() {
		super();
	}
	
	
	

}
