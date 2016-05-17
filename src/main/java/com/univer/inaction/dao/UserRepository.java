package com.univer.inaction.dao;

import com.univer.inaction.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, Long>{
}
