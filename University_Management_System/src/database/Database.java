
import lab4.people.Student;
import lab4.people.Teacher;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Database {
    // Singleton
    private static Database instance = null;
    private static int nr_inst;
    final private List<Student> students = new ArrayList<>();
    final private List<Teacher> teachers = new ArrayList<>();

    private Database() {
    }

    public static Database getDatabase() {
        if (instance == null) {
            instance = new Database();
            nr_inst++;
        }
        return instance;
    }

    public static int getNumberOfInstances() {
        return nr_inst;
    }

    public void addTeachers(List<Teacher> teachers) {
        this.teachers.addAll(teachers);
    }

    public void addStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public List<Teacher> findTeachersBySubject(String subject) {
        List<Teacher> teacherBySub = new ArrayList<>();

        for (Teacher teacher : teachers) {
            for (String sub : teacher.getSubjects()) {
                if (sub.equals(subject)) teacherBySub.add(teacher);
            }
        }

        return teacherBySub;
    }

    public List<Student> findAllStudents() {
        if (!students.isEmpty()) return students;
        return null;
    }

    public List<Teacher> findAllTeachers() {
        if (!teachers.isEmpty()) return teachers;
        return null;
    }

    public List<Student> getStudentsBySubject(String subject) {
        List<Student> studentsBySub = new ArrayList<>();

        for (Student st : students) {
            for (Map.Entry<String, Integer> entry : st.getSubjects().entrySet()) {
                if (entry.getKey().equals(subject)) studentsBySub.add(st);
            }
        }

        return studentsBySub;
    }

    public List<Student> getStudentsByAverageGrade() {
        // TODO

        List<Student> studentsByAvGrd = new ArrayList<>();

        for (var student : students) {
            // folosind constructor cu deep copy
            studentsByAvGrd.add(new Student(student));
        }

        studentsByAvGrd.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.averageGrade() == o2.averageGrade()) return 0;
                if (o1.averageGrade() < o2.averageGrade()) return -1;
                if (o1.averageGrade() > o2.averageGrade()) return 1;

                return -2;
            }

        });

        return studentsByAvGrd;
    }

    public List<Student> getStudentsByGradeForSubject(String subject) {
        List<Student> studentsByGrade;

        studentsByGrade = getStudentsBySubject(subject);

        studentsByGrade.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getGradeForSubject(subject) == o2.getGradeForSubject(subject)) return 0;
                if (o1.getGradeForSubject(subject) < o2.getGradeForSubject(subject)) return -1;
                if (o1.getGradeForSubject(subject) > o2.getGradeForSubject(subject)) return 1;

                return -2;
            }

        });

        return studentsByGrade;
    }
}
