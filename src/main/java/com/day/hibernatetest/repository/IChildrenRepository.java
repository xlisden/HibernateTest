
package com.day.hibernatetest.repository;

import com.day.hibernatetest.entity.Children;
import java.util.List;
import javax.persistence.EntityManager;


public interface IChildrenRepository {

    public void addChildren(Children children, EntityManager em);
    public void updateChildren(Children children, EntityManager em);
    public void deleteChildren(Children children, EntityManager em);
    public List<Children> getAllChildrens(EntityManager em);
    public Children getByIdChildren(EntityManager em);
    
}
