import java.io.Serializable;

public class Student implements Serializable {
	private String StudentName; // 학생이름
	private int StudentNum; // 학번
	private String Major; // 전공학과
	private String Address; // 주소
	private String Call; // 연락처
	private String Email; // 이메일
	private String Grade; // 성적
	private String Scholarship; // 장학금
	
	
	public Student(String StudentName, int StudentNum, String Major, String Address, String Call, String Email, String Grade, String Scholarship){ // 생성자
		this.StudentName = StudentName;
		this.StudentNum = StudentNum;
		this.Major = Major;
		this.Address = Address;
		this.Call = Call;
		this.Email = Email;
		this.Grade = Grade;
		this.Scholarship = Scholarship;
		
		
	}
	public String getStudentName() {
		return StudentName;
	}
	
	public int getStudentNum() {
		return StudentNum;
	}
	
	public String getMajor() {
		return Major;
	}
	
	public String getAddress() {
		return Address;
	}

	public String getCall() {
		return Call;
	}

	public String getEmail() {
		return Email;
	}

	public String getGrade() {
		return Grade;
	}

	public String getScholarship() {
		return Scholarship;
	}
	
	public void setStudentName(String StudentName) {
		this.StudentName = StudentName;
	}

	public void setStudentNum(int StudentNum) {
		this.StudentNum = StudentNum;
	}
	
	public void setMajor(String Major) {
		this.Major = Major;
	}
	
	public void setAddress(String Address) {
		this.Address = Address;
	}

	public void setCall(String Call) {
		this.Call = Call;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public void setGrade(String Grade) {
		this.Grade = Grade;
	}
	
	public void setScholarship(String Scholarship) {
		this.Scholarship = Scholarship;
	}
	
	public String toString() {
		return getStudentName() + " " + getStudentNum() + " " + getMajor() + " " + getAddress() + " " + getCall() + " " + getEmail() + " " + getGrade() + " " + getScholarship();
	}

}