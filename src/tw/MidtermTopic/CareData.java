package tw.MidtermTopic;


public class CareData {
	private int id  ;
	private String ChildcareType;
	private String ChildcareName;
	private String District;
	private String address;
	private String ContactPerson;
	private String phone;
	private String Introduction;
	private String DiscountContent;
	private String DiscountStart;
	private String DiscountEnd;
	private String Remark;
	public CareData() {
		
	}
	
	public CareData(String ChildcareType ,String ChildcareName , String District ,String address , String ContactPerson , String phone , String Introduction,String DiscountContent , String DiscountStart,String DiscountEnd , String Remark) {
		this.ChildcareType = ChildcareType;
		this.ChildcareName = ChildcareName;
		this.District = District;
		this.address = address;
		this.ContactPerson = ContactPerson;
		this.phone = phone;
		this.Introduction = Introduction;
		this.DiscountContent = DiscountContent;
		this.DiscountStart = DiscountStart;
		this.DiscountEnd = DiscountEnd;
		this.Remark = Remark;
	}	
	public CareData(int id , String ChildcareType ,String ChildcareName , String District ,String address , String ContactPerson , String phone , String Introduction,String DiscountContent , String DiscountStart,String DiscountEnd , String Remark) {
		this.id = id;
		this.ChildcareType = ChildcareType;
		this.ChildcareName = ChildcareName;
		this.District = District;
		this.address = address;
		this.ContactPerson = ContactPerson;
		this.phone = phone;
		this.Introduction = Introduction;
		this.DiscountContent = DiscountContent;
		this.DiscountStart = DiscountStart;
		this.DiscountEnd = DiscountEnd;
		this.Remark = Remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChildcareType() {
		return ChildcareType;
	}

	public void setChildcareType(String childcareType) {
		ChildcareType = childcareType;
	}

	public String getChildcareName() {
		return ChildcareName;
	}

	public void setChildcareName(String childcareName) {
		ChildcareName = childcareName;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactPerson() {
		return ContactPerson;
	}

	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIntroduction() {
		return Introduction;
	}

	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}

	public String getDiscountContent() {
		return DiscountContent;
	}

	public void setDiscountContent(String discountContent) {
		DiscountContent = discountContent;
	}

	public String getDiscountStart() {
		return DiscountStart;
	}

	public void setDiscountStart(String discountStart) {
		DiscountStart = discountStart;
	}

	public String getDiscountEnd() {
		return DiscountEnd;
	}

	public void setDiscountEnd(String discountEnd) {
		DiscountEnd = discountEnd;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}
	

}
