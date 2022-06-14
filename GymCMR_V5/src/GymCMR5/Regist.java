package GymCMR5;

public class Regist {
	int registID, registMaxMember;
	String registMemberName, registProgramName
	, registProgramWeek , registProgramTime;
	
	public Regist(int registID
			, String registMemberName
			, String registProgramName
			, String registProgramWeek
			, String registProgramTime
			, int registMaxMember){
		this.registID = registID;
		this.registMemberName = registMemberName;
		this.registProgramName = registProgramName;
		this.registProgramWeek = registProgramWeek;
		this.registProgramTime = registProgramTime;
		this.registMaxMember = registMaxMember;
	}
}
