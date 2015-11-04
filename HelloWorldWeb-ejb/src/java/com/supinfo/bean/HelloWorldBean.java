/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.bean;

import javax.ejb.Stateless;

/**
 *
 * @author alexandrenguyen
 */

@Stateless
public class HelloWorldBean implements HelloWorldBeanInterface {

    @Override
    public String hello() {
        return "Hello world !";
    }
    
}
