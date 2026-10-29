package com.yourcompany.invoicing.model;

import java.time.*;
import java.util.*;
import jakarta.persistence.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import lombok.*;
import com.yourcompany.invoicing.calculators.*;

@Entity @Getter @Setter
public class Invoice {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Hidden
    @Column(length=36)
    String oid;

    @Column(length=4)
    @Required
    @DefaultValueCalculator(CurrentYearCalculator.class) // Current year
    int year;

    @Column(length=6)
    @Required
    @DefaultValueCalculator(value=NextNumberForYearCalculator.class,
            properties=@PropertyValue(name="year") // To inject the value of year from Invoice to
            // the calculator before calling calculate()
    )
    int number;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Current date
    LocalDate date;

    @ManyToOne(fetch=FetchType.LAZY, optional=false) // Customer is required
    Customer customer;

    @ElementCollection
    @ListProperties("product.number, product.description, quantity")
    Collection<Detail> details;

    @TextArea
    String remarks;

}
