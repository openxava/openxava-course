package com.yourcompany.invoicing.model;

import jakarta.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity @Getter @Setter
public class Category {

    @Id
    @Hidden // The property is not shown to the user. It's an internal identifier
    @GeneratedValue(strategy=GenerationType.UUID) // Universally Unique Identifier (1)
    @Column(length=36)
    String oid;

    @Column(length=50)
    String description;

}
