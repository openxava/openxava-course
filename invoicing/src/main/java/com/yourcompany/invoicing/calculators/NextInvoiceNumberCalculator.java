package com.yourcompany.invoicing.calculators;

import org.openxava.calculators.*;
import org.openxava.jpa.*;
import lombok.*;

public class NextInvoiceNumberCalculator implements ICalculator {

    @Getter @Setter int year; // Injected from the view before calculate() runs

    public Object calculate() throws Exception {
        Integer last = XPersistence.getManager().createQuery(
            "select max(i.number) from Invoice i where i.year = :year", Integer.class)
            .setParameter("year", year)
            .getSingleResult();
        return last == null ? 1 : last + 1;
    }
}
