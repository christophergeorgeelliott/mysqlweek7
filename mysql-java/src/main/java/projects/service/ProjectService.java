package projects.service;

import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.DbException;

public class ProjectService {
    private final ProjectDao projectDao;

    public ProjectService() {
        this.projectDao = new ProjectDao();
    }

    public Project addProject(Project project) {
        try {
            return projectDao.insertProject(project);
        } catch (DbException e) {
            System.out.println("Error adding project: " + e.getMessage());
            return null;
        }
    }
}
