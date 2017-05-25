package pl.dawidbasa.organizer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "contacts")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Length(min = 2, max = 30, message = "Please input first name with {min} to {max} characters.")
	private String firstName;

	@Length(min = 2, max = 30, message = "Please input last name with {min} to {max} characters.")
	private String lastName;

	@Length(min = 2, max = 30, message = "Please input company with {min} to {max} characters.")
	private String company;

	@Length(min = 2, max = 30, message = "Please input email with {min} to {max} characters.")
	private String email;

	@Length(max = 9, message = "Please input valid phone number.")
	private String phone;

	@Transient
	private MultipartFile profilePic;

	public Contact() {
		super();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public MultipartFile getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}

	public void updateContactFields(Contact c) {
		setFirstName(c.getFirstName());
		setLastName(c.getLastName());
		setCompany(c.getCompany());
		setEmail(c.getEmail());
		setPhone(c.getPhone());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (id != other.id)
			return false;
		return true;
	}

}