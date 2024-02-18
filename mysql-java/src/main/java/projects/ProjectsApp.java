package projects;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import projects.entity.Project;
import projects.exception.DbException;
import projects.service.ProjectService;

public class ProjectsApp {
    private Scanner scanner = new Scanner(System.in);
    private ProjectService projectService = new ProjectService();

    private List<String> operations = List.of(
        "1) Add a project"
    );

    public static void main(String[] args) {
        new ProjectsApp().processUserSelections();
    }

    private void processUserSelections() {
        boolean done = false;

        while (!done) {
            try {
                int selection = getUserSelection();

                switch (selection) {
                    case -1:
                        done = exitMenu();
                        break;

                    case 1:
                        createProject();
                        break;

                    default:
                        System.out.println("\n" + selection + " is not a valid selection. Try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nError: " + e + " Try again.");
            }
        }
    }

    private void createProject() {
        String projectName = getStringInput("Enter the project name");
        BigDecimal estimatedHours = getDecimalInput("Enter the estimated hours");
        BigDecimal actualHours = getDecimalInput("Enter the actual hours");
        Integer difficultyLevel = getIntegerInput("Enter the difficulty (1-5)");
        String notes = getStringInput("Enter the project notes");

        Project dbProject = new Project();

        dbProject.setProjectName(projectName);
        dbProject.setEstimatedHours(estimatedHours);
        dbProject.setActualHours(actualHours);
        dbProject.setDifficulty(difficultyLevel);

        projectService.addProject(dbProject);

        System.out.println("You have successfully created project: " + dbProject);
    }

    private BigDecimal getDecimalInput(String prompt) {
        String input = getStringInput(prompt);

        if (Objects.isNull(input)) {
            return null;
        }

        try {
            return new BigDecimal(input).setScale(2);
        } catch (NumberFormatException e) {
            System.out.println("Exception: It is not a valid decimal number.");
            return null;
        }
    }

    private boolean exitMenu() {
        System.out.println("Exiting the menu.");
        return true;
    }

    private int getUserSelection() {
        Integer userInput = getIntegerInput("Enter a menu selection");
        return Objects.isNull(userInput) ? -1 : userInput;
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine().trim();
    }

    private Integer getIntegerInput(String prompt) {
        String input = getStringInput(prompt);

        if (input.isEmpty()) {
            return null;
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Exception: It is not a valid integer number.");
            return null;
        }
    }
}
