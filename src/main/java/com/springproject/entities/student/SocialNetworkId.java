package com.springproject.entities.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.NamedAttributeNode;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class SocialNetworkId implements Serializable {
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "type_network",length = 20)
    private String type;
}
