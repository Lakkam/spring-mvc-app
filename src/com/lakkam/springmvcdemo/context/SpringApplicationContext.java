package com.lakkam.springmvcdemo.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
/*
 * This file is Java config approach to configure Spring Application Context
 * The mentioned annotations provides will enable all Spring concepts like config, AOP and base component
 * We can also add security and rest related annotations.
 * If we maintain this file, then we dont need seperate XML file to configure context.
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.lakkam.springmvcdemo")
 public class SpringApplicationContext {

	 

}
