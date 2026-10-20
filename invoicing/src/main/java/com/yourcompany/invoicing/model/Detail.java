package com.yourcompany.invoicing.model;

import jakarta.persistence.*;
import lombok.*;

@Embeddable @Getter @Setter
public class Detail {

    int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Product product;

}
