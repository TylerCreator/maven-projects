package models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable {
    private RoleMapping id;
    private String role;


    public RoleMapping getId() {
        return id;
    }

    public void setId(RoleMapping id) {
        this.id = id;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role(){

    }


}
