package PdfProject;

public class NotCizelgesi {
	private int id, ders_kodu;
	private String StudentNumber, StudentNameSurname, Midterm1, FinalExam, LetterGrade;

	public NotCizelgesi(int id, String StudentNumber, String StudentNameSurname, String Midterm1, String FinalExam,
			String letterGrade, int ders_kodu) {
		this.setId(id);
		this.setStudentNumber(StudentNumber);
		this.setStudentNameSurname(StudentNameSurname);
		this.setMidterm1(Midterm1);
		this.setFinalExam(FinalExam);
		this.setLetterGrade(letterGrade);
		this.setDers_kodu(ders_kodu);
	}

	public int getDers_kodu() {
		return ders_kodu;
	}

	public void setDers_kodu(int ders_kodu) {
		this.ders_kodu = ders_kodu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentNumber() {
		return StudentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		StudentNumber = studentNumber;
	}

	public String getStudentNameSurname() {
		return StudentNameSurname;
	}

	public void setStudentNameSurname(String studentNameSurname) {
		StudentNameSurname = studentNameSurname;
	}

	public String getMidterm1() {
		return Midterm1;
	}

	public void setMidterm1(String midterm1) {
		Midterm1 = midterm1;
	}

	public String getFinalExam() {
		return FinalExam;
	}

	public void setFinalExam(String finalExam) {
		FinalExam = finalExam;
	}

	public String getLetterGrade() {
		return LetterGrade;
	}

	public void setLetterGrade(String letterGrade) {
		LetterGrade = letterGrade;
	}
}
