package com.iiht.user.login.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="user")
public class RegisterUser {
@Override
public String toString() {
return "RegisterUser [email=" + email + ", password=" + password + ", status=" + status + "]";
}
@Id
private String email;
private String password;
@ColumnDefault("false")
private boolean status;
public boolean getStatus() {
return status;
}
public void setStatus(boolean status) {
this.status = status;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}

}