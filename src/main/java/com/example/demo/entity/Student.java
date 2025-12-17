package com.example.demo.entity;
public class Student{
    private Long id;
    private String name;
    private String email;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;

    }
    public String getName(){
        return name;
    }
    public void setName(string name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public Student(int id,String name, String email){
        this.id=(long)id;
        this.name=name;
        this.email=email;
    }
    public Student(){
        
    }
}