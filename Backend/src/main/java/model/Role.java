package model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "role")
public class Role {
    //squence id
    @Id
    //Primary key as employee ID should be unique
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)

    //Role of employee
    private String role;

    //getter for ID
    public String getId() {
        return id;
    }

    //setter for ID
    public void setId(String id) {
        this.id = id;
    }

    //getter for role
    public String getRole() {
        return role;
    }

    //setter for role
    public void setRole(String role) {
        this.role = role;
    }

}