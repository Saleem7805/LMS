package com.product.lms.mentor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;

public interface MentorRepo extends MongoRepository<MentorModel,String>
{

	List<MentorModel> findByAssignedStudentContaining(String pibId);

	

}
