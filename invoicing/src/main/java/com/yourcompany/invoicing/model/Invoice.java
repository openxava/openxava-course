package com.yourcompany.invoicing.model;

import jakarta.persistence.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import com.yourcompany.invoicing.calculators.*;
import lombok.*;

import java.time.*;

@Entity @Getter @Setter
public class Invoice {

    @Id
    @Hidden // The property is not shown to the user. It's an internal identifier
    @GeneratedValue(strategy=GenerationType.UUID) // Universally Unique Identifier
    @Column(length=36)
    String oid;

    @Required
    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class) // The current year by default
    int year;

    @Required
    @Column(length=9)
    @DefaultValueCalculator(value=NextInvoiceNumberCalculator.class,
        properties=@PropertyValue(name="year")) // Next number within the year, restarting each year
    int number;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Today by default
    LocalDate date;

    @TextArea
    String remarks;

}
