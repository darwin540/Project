package com.java.Crud.repositories;

import com.java.Crud.models.DarwinModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDarwinRepository extends JpaRepository<DarwinModel,Long> {


}
