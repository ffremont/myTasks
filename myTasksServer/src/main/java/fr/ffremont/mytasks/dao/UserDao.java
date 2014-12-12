/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.mytasks.dao;

import fr.ffremont.mytasks.model.Role;
import fr.ffremont.mytasks.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author florent
 */
@Component
public class UserDao {
    @Autowired
    MongoTemplate mongoTpl;
    
    public User findUserByHash(String hash){
        User current = new User();
        current.setEmail("ff.fremont.florent@gmail.com");
        current.setHash(hash);
        current.setRole(Role.MANAGER);
        // @todo aa
        return current;
        //return mongoTpl.findOne(Query.query(Criteria.where("hash").is(hash)), User.class);
    }
}
