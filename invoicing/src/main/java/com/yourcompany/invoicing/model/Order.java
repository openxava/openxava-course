package com.yourcompany.invoicing.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter
public class Order extends CommercialDocument {

    @ManyToOne(fetch=FetchType.LAZY)
    Invoice invoice; // Reference to invoice added

}
