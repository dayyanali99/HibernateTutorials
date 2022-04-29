package org.learnhibernate.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee
{
    @Id
    private int eid;
    private String employeeName;
    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "eid")}, inverseJoinColumns = {@JoinColumn(name = "pid")})
    private List<Project> projects;

    public Employee()
    {
    }

    public Employee(int eid, String employeeName)
    {
        this.eid = eid;
        this.employeeName = employeeName;
    }

    public int getEid()
    {
        return eid;
    }

    public void setEid(int eid)
    {
        this.eid = eid;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public List<Project> getProjects()
    {
        return projects;
    }

    public void setProjects(List<Project> projects)
    {
        this.projects = projects;
    }
}
