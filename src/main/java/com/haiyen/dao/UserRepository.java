package com.haiyen.dao;
import org.springframework.data.repository.CrudRepository;
import com.haiyen.model.*;


public interface UserRepository extends CrudRepository <User, Integer> {

}
