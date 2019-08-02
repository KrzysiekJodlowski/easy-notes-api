package com.jodlowski.easynotesapi.model;

import org.hibernate.annotations.ColumnTransformer;
import javax.persistence.*;


@Entity
@Table(name = "notes_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String name;
    @ColumnTransformer(read = "pgp_sym_decrypt_bytea(password, current_setting('encrypt.key'))",
            write = "pgp_sym_encrypt(?, current_setting('encrypt.key'))")
    @Column(columnDefinition = "bytea")
    private String password;
    @Column(name = "e_mail")
    private String eMail;

    public User() {};

    public User(Long userId, String name, String password, String eMail) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.eMail = eMail;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
