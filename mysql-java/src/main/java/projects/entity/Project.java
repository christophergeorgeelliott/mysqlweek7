/**
 * 
 */
package projects.entity;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a project entity.
 * It includes fields for project details such as name, estimated hours, actual hours, difficulty, and notes.
 * It also includes lists to hold related materials, steps, and categories.
 * Additionally, it overrides the toString method to provide a formatted string representation of the project.
 *
 */
public class Project {
    private Integer projectId;
    private String projectName;
    private BigDecimal estimatedHours;
    private BigDecimal actualHours;
    private Integer difficulty;
    private String notes;

    private List<Material> materials = new LinkedList<>();
    private List<Step> steps = new LinkedList<>();
    private List<Category> categories = new LinkedList<>();

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public BigDecimal getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(BigDecimal estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public BigDecimal getActualHours() {
        return actualHours;
    }

    public void setActualHours(BigDecimal actualHours) {
        this.actualHours = actualHours;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Project ID: ").append(projectId).append("\n");
        sb.append("Project Name: ").append(projectName).append("\n");
        sb.append("Estimated Hours: ").append(estimatedHours).append("\n");
        sb.append("Actual Hours: ").append(actualHours).append("\n");
        sb.append("Difficulty: ").append(difficulty).append("\n");
        sb.append("Notes: ").append(notes).append("\n");

        sb.append("Materials:\n");
        for (Material material : materials) {
            sb.append(material.toString()).append("\n");
        }

        sb.append("Steps:\n");
        for (Step step : steps) {
            sb.append(step.toString()).append("\n");
        }

        sb.append("Categories:\n");
        for (Category category : categories) {
            sb.append(category.toString()).append("\n");
        }

        return sb.toString();
    }
}
