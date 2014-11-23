/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.mytasks.exception;

/**
 *
 * @author florent
 */
public class NotFoundEntity extends Exception{
    public NotFoundEntity(String message){
        super(message);
    }
}
