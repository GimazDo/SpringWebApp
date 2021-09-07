package com.springproject.entities.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSocialNetwork {

    @EmbeddedId
    private SocialNetworkId socialNetworkId;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;


    @Column(name ="network_url")
    private String url;
}
