package com.rocha82.repository;
import com.rocha82.dao.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
/*public class UserRepository{
    public String get(long id){
        return "string from repository";
    }
}*/