package com.trainings.employees.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity

public class Department implements Serializable {


    @Serial
    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    private int deptno;

    @Version
    private long version;

    private String dname;
    private String loc;

    @OneToMany(mappedBy = "id.department")
    private List<Computer> computers;

    public Department(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public Department() {}

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
