package service;

import dao.MyDataSource;
import dao.SubjectDao;
import model.Subject;

import java.util.List;

public class SubjectService {
    SubjectDao subjectDao = new SubjectDao();

    public void create (String name){
        subjectDao.create(name);
    }

    public List<Subject> getAll(){
        return subjectDao.getAll();
    }

}
