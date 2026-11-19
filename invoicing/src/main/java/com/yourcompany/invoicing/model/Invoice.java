package com.yourcompany.invoicing.model;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter
public class Invoice extends CommercialDocument {

    @OneToMany(mappedBy="invoice")
    Collection<Order> orders; // Collection of Order entities added

}
