package com.gradle.demo.model;

import org.apache.catalina.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="phone")
    private String phone;

    @OneToOne
    private RespSector respSector;

    @Column(name="username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="attempt")
    private int attempt;

    @Column(name="active")
    private boolean isActive;

    @Column(name="locked")
    private boolean isLocked;

    @Column(name="expired")
    private boolean isExpired;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;

    public Users(Users users) {
        this.firstName = users.getFirstName();
        this.lastName = users.getLastName();
        this.phone = users.getPhone();
        this.respSector = users.getRespSector();
        this.username = users.getUsername();
        this.password = users.getPassword();
        this.attempt = users.getAttempt();
        this.isActive = users.isActive();
        this.isLocked = users.isLocked();
        this.isExpired = users.isExpired();
        this.roles = users.getRoles();
    }
public Users()
{

}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public RespSector getRespSector() {
        return respSector;
    }

    public void setRespSector(RespSector respSector) {
        this.respSector = respSector;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
