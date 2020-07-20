package com.example.demo2020;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"kosmo.config"})
@ComponentScan(basePackages= {"web.board"})
public class RootConfig {

}
