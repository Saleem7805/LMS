package com.product.lms.mentor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class MentorService {

    @Autowired
    MentorRepo mentorRepo;
    
    private String generateMentorId() {
        long count = mentorRepo.count() + 1;
        return String.format("MENT%03d", count); 
    }

    private String generatePassword(String name) {
        
        String namePart = name.length() >= 4
                ? name.substring(0, 4)
                : name;
       
        return namePart + "@" ;
        
    }


    

    public Optional<MentorModel> mentorLogin(MentorLoginDTO md) {

    	Optional<MentorModel> mm = mentorRepo.findById(md.getMentorId());

        if (mm.isPresent() && mm.get().getMpassword().equals(md.getMpassword())) {
            return mm;
        } else {
            return Optional.empty();
        }
    }
    
    
    
}
