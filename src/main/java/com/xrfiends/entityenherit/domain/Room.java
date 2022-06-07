package com.xrfiends.entityenherit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room extends Base {
    private String roomNo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private Set<Attendee> attendees;
}
