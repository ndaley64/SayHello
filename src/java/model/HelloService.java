/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author ndaley
 */
public class HelloService {
    public int generateRandomInt(){
        return 1 + (int)(Math.random() * ((10 - 1) + 1));
    }
}
