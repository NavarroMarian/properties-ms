package com.limit.properties.repository;

import com.limit.properties.entity.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property, String> {

    Property save (Property property);

}
