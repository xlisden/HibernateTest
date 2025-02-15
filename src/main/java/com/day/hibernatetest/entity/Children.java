package com.day.hibernatetest.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
public class Children {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent", foreignKey = @ForeignKey(name = "fk_employee_children"))
    private Employee parent;

    public Children() {
    }

    public Children(int id, String name, Employee parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }

}
