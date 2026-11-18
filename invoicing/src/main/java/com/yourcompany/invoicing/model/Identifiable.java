package com.yourcompany.invoicing.model;

import jakarta.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@MappedSuperclass // Marked as mapped superclass instead of entity
@Getter @Setter
public class Identifiable {

    @Id @GeneratedValue(strategy=GenerationType.UUID) @Hidden
    @Column(length=36)
    String oid; // Property definition includes OpenXava and JPA annotations

}
