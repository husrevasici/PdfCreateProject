package PdfProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StudentInformation {
	int Id;
	String StudentNumber;
	String StudentNameSurname;
	String Midterm1;
	String FinalExam;
	String LetterGrade;

	StudentInformation(int id, String StudentNumber, String StudentNameSurname, String Midterm1, String FinalExam,
			String LetterGrade) {
		// Integer.parseInt(number);
		this.Id = id;
		this.StudentNumber = StudentNumber;
		this.StudentNameSurname = StudentNameSurname;
		this.Midterm1 = Midterm1;
		this.FinalExam = FinalExam;
		this.LetterGrade = LetterGrade;
	}
}

public class DPdfLineEdit extends DPdfRead {

	String studentList = "(\\d{0,2}+).\\s*+(\\d{7,9}+)(\\D*+)(\\w{0,3})(\\s*+)(\\w{0,3})(\\s*+)(\\D{0,2})";
	String lessonCodeNumberBranch = "[Dd][Ee][Rr][Ss]\\s*+[Kk][Oo][Dd][Uu]\\s*+[/]\\s*+[Aa][Dd][Iı]\\s*+[/]\\s*+[Şş][Uu][Bb][Ee][Ss][İi]";
	String teacherNameSurname = "[Öö][Ğğ][Rr][Ee][Tt][İi][Mm]\\s*+[Ee][Ll][Ee][Mm][Aa][Nn]\\s*+[Aa][Dd]\\s*+[Ss][Oo][Yy][Aa][Dd]";
	// DERS KODU / ADI / ŞUBESİ
	// ÖĞRETİM ELEMAN AD SOYAD

	Pattern p, p1;
	Matcher m, m1;
	static int count = 0;

	static int sayac = 1;
	public void producingPattern() {
		StudentInformation studentInformation;
		p = Pattern.compile(lessonCodeNumberBranch);
		p1 = Pattern.compile(teacherNameSurname);
		for (int i = 0; i < arrayList.size(); i++) {
			m = p.matcher(arrayList.get(i));
			m1 = p1.matcher(arrayList.get(i));
			if (m.find()) {
				// System.out.println(arrayList.get(i));
				arrayListLessonCodeNumberBranch.add(arrayList.get(i).trim());
			}
			if (m1.find()) {
				// System.out.println(arrayList.get(i));
				arrayListTeacherNameSurname.add(arrayList.get(i));
			}
		}
		p = Pattern.compile(studentList);
		for (int i = 0; i < arrayList.size(); i++) {
			m = p.matcher(arrayList.get(i));
			if (m.find()) {
				int mgroup1 = Integer.parseInt(m.group(1));
// sayac++ + ".indeks: " +
//
//				System.out.println(mgroup1 + " " + m.group(2) + m.group(3) + " **** " + m.group(4) + " #### "
//						+ m.group(6) + "----" + m.group(8));
				studentInformation = new StudentInformation(mgroup1, m.group(2), m.group(3), m.group(4), m.group(6),
						m.group(8));

				arrayListStudentInformation.add(studentInformation);
			}
		}
	}

}
