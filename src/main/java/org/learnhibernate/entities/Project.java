package org.learnhibernate.entities;

import org.learnhibernate.entities.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class Project
{
    @Id
    private int id;
    @Column(name = "project_name")
    private String projectName;
    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    public Project()
    {
    }

    public Project(int id, String projectName)
    {
        this.id = id;
        this.projectName = projectName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public List<Employee> getEmployees()
    {
        return employees;
    }

    public void setEmployees(List<Employee> employees)
    {
        this.employees = employees;
    }
}
