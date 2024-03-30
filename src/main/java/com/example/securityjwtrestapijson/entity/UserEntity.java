package com.example.securityjwtrestapijson.entity;

import com.example.securityjwtrestapijson.entity.enumtype.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED) //JPA 쓰면서 protected 키워드는 생성해서 쓰지말라는 의미
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username; // provider + providerId
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole userRole; //[ROLE_USER,ROLE_ADMIN]

    @JsonIgnore
    private String password;


    //==생성 메서드==//
    public static UserEntity createUser(String username, String email, String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setEmail(email);
        userEntity.setUserRole(UserRole.ROLE_USER);
        userEntity.setPassword(password);
        return userEntity;
    }
}
