
public class Person {
	private String name;
	private int status, employed, status23; // 0 is unemployed, 1 is employed
	//0 is not in program, 1 is in program
	
	public Person(String name2, int status2, int employed2, int status3){
		name = name2;
		status = status2;
		employed = employed2;
		status23 = status3;
	}
	
	public void changeStatus(int newStatus){
		status = newStatus;
	}
	public void changeEmployedStatus(int newStatus){
		employed = newStatus;
	}
	public String generateVetStatus(){
	if(status23 == 0){
		return "Not A Veteran";
	}
	else if(status23 == 1){
		return "Veteran";
	}
	return "";
	}
	public String getName(){
		return name;
	}
	public String generateStatus(){
		if(status == 0){
			return "Active";
		}
		else if(status == 1){
			return "Inactive";
		}
		return "";
	}
	public String generateEmpStatus(){
		if(employed == 0){
			return "UnEmployed";
		}
		if(employed == 1){
			return "Employed";
		}
		return "";
	}
	public String toString(){
		String temp = generateStatus();
		String temp2 = generateEmpStatus();
		String temp3 = generateVetStatus();
		return name + ","+ temp + "," + temp2 + "," + temp3;
	}
}
