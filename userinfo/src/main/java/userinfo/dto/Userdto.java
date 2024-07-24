package userinfo.dto;

public class Userdto {
	private int id;
	private String name;
	private String email;

	private long phone;
	private String password;
	private String qualification;
	private String district;
	private int pincode;
	private int age;
	private String stream;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ ", qualification=" + qualification + ", district=" + district + ", pincode=" + pincode + ", age="
				+ age + ", stream=" + stream + "]";
	}

	public Userdto(int id, String name, String email, long phone, String password, String qualification,
			String district, int pincode, int age, String stream) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.qualification = qualification;
		this.district = district;
		this.pincode = pincode;
		this.age = age;
		this.stream = stream;
	}

	// Constructor for login (email and password only)
	public Userdto(String email) {
		this.email = email;

	}

	public Userdto(String email, String password) {
		this.email = email;
		this.password = password;

	}

	public Userdto(String name, String email, long phone, String password, String qualification, String district,
			int pincode, int age, String stream) {
		super();

		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.qualification = qualification;
		this.district = district;
		this.pincode = pincode;
		this.age = age;
		this.stream = stream;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public Userdto() {
		super();
	}

}
