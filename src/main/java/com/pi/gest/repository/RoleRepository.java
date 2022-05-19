package com.pi.gest.repository;

import com.pi.gest.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface RoleRepository  extends JpaRepository  <Role, Integer >{
}
