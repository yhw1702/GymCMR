package GymCMR5;

public class Member {
	int memberID; String memberNameInput, phoneNumberInput, apartDongInput, apartHoInput;
	
	public Member(int memberID
			, String memberNameInput
			, String phoneNumberInput
			, String apartDongInput
			, String apartHoInput){
		this.memberID = memberID;
		this.memberNameInput = memberNameInput;
		this.phoneNumberInput = phoneNumberInput;
		this.apartDongInput = apartDongInput;
		this.apartHoInput = apartHoInput;
	}
}
