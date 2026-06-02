package com.product.lms.students;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepo  extends MongoRepository<Course, String>{

}
