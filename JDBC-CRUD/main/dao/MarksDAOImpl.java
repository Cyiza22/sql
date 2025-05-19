package dao;

import java.util.*;

public class MarksDAOImpl implements MarksDAO {
    private List<Marks> marksList = new ArrayList<>();

    @Override
    public void addMark(Marks mark) {
        marksList.add(mark);
    }

    @Override
    public List<Marks> getMarksByStudentId(int studentId) {
        List<Marks> result = new ArrayList<>();
        for (Marks m : marksList) {
            if (m.getStudent_id() == studentId) {
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public List<Marks> getAllMarks() {
        return marksList;
    }

    @Override
    public void updateMark(Marks mark) {
        for (int i = 0; i < marksList.size(); i++) {
            Marks m = marksList.get(i);
            if (m.getStudent_id() == mark.getStudent_id() && m.getCourse_id() == mark.getCourse_id()) {
                marksList.set(i, mark);
                return;
            }
        }
    }

    @Override
    public void deleteMark(int studentId, int courseId) {
        marksList.removeIf(m -> m.getStudent_id() == studentId && m.getCourse_id() == courseId);
    }
}
