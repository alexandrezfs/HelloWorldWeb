/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.bean;

import javax.ejb.Remote;

/**
 *
 * @author alexandrenguyen
 */

@Remote
public interface HelloWorldBeanInterface {
    
    public String hello();
}
