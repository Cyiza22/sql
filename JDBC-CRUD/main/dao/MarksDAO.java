package dao;
import java.util.List;

public interface MarksDAO {
    void addMark(Marks mark);
    List<Marks> getMarksByStudentId(int studentId);
    List<Marks> getAllMarks();
    void updateMark(Marks mark);
    void deleteMark(int studentId, int courseId);
}
