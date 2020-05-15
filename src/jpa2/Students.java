/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
/**
 *
 * @author Maram Tanani
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "student.findAll",
            query = "Select s From student s"),
    @NamedQuery(name = "student.findById",
            query = "Select s From student s Where s.id= :id")
})
public class Students {
    
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
   private String name;
   @ManyToOne
   private String major;
   private Double grade;

    public Students() {
    }

    public Students(Integer id, String name, String major, Double grade) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
