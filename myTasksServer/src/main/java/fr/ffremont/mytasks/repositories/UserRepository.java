/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.mytasks.repositories;

import fr.ffremont.mytasks.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author florent
 */
public interface UserRepository extends PagingAndSortingRepository<User, String>{
    public User findOneByHash(String hash);
    
    public User findOneByEmail(String email);
}
