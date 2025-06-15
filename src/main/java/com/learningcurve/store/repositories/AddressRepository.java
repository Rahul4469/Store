package com.learningcurve.store.repositories;

import com.learningcurve.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}