package com.example.backclinic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericEntityRepository extends CrudRepository<GenericEntity, Long> {


}
