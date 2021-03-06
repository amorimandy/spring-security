package io.jzheaux.springsecurity.resolutions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Entity(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;

    @Column(name="username")
    String username;

    @Column
    String password;

    @Column
    boolean enabled = true;

    @Column(name = "full_name")
    String fullName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Collection<UserAuthority> userAuthorities = new ArrayList<>();

    public User() {
    }

    public User(String username, String password) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
    }

    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.enabled = user.enabled;
        this.fullName = user.fullName;
        this.userAuthorities = user.userAuthorities;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Collection<UserAuthority> getUserAuthorities() {
        return userAuthorities;
    }

    public void grantAuthority(String authority) {
        this.userAuthorities.add(new UserAuthority(this, authority));
    }
}
