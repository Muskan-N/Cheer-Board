package model;

import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "user")
public class User {

    @Id
    //Primary key as employee ID should be unique
    private String id;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String fullname;
    private boolean enabled;
    @DBRef
    private Set<Role> roles;

    //getter for ID
    public String getId() {
        return id;
    }

    //setter for ID
    public void setId(String id) {
        this.id = id;
    }

    //getter for email
    public String getEmail() {
        return email;
    }

    //setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    //getter for password
    public String getPassword() {
        return password;
    }

    //setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    //getter for fullname
    public String getFullname() {
        return fullname;
    }

    //setter for fullname
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isEnabled() {
        return enabled;
    }

    //setter for enabled
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    //getter for roles
    public Set<Role> getRoles() {
        return roles;
    }

    //setter for roles
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



}
