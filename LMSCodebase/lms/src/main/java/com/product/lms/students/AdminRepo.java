package com.product.lms.students;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends MongoRepository<AdminModel, String> {

    AdminModel findByUsername(String username);
}