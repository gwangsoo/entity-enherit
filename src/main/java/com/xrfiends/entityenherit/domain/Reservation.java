package com.xrfiends.entityenherit.domain;

import com.xrfiends.entityenherit.jpa.AbstractAuditingEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation extends AbstractAuditingEntity {

    @Id
    @Column(name = "id", length = 36, nullable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Detail> details;
}
