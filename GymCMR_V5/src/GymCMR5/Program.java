package GymCMR5;

public class Program {
	int programID, maxMemberInput;
	String programNameInput, programWeekInput
	, programTimeInput;
		
	public Program(int programID
			, String programNameInput
			, String programWeekInput
			, String programTimeInput
			, int maxMemberInput){
		this.programID = programID;
		this.programNameInput = programNameInput;
		this.programWeekInput = programWeekInput;
		this.programTimeInput = programTimeInput;
		this.maxMemberInput = maxMemberInput;
	}
}
