package com.pi.gest.repository;

import com.pi.gest.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client , Integer >{
}
