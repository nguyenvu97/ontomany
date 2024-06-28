package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@ToString
public class InfoPerson implements Serializable {
    @Column(name = "email",length = 20)
    private String email;
    @Column(name = "passWorld",length = 20)
    private String passWorld;
    @Column(name = "phone",length = 20)
    private String phone;
}
