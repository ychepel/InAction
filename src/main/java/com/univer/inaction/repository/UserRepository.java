package com.univer.inaction.repository;

import com.univer.inaction.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
}
