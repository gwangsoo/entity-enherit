package com.xrfiends.entityenherit.domain;

import com.xrfiends.entityenherit.jpa.AbstractAuditingEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Detail extends AbstractAuditingEntity {
    @Id
    @Column(name = "id", length = 36, nullable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String name;

    @ManyToOne
    private Base base;
}
