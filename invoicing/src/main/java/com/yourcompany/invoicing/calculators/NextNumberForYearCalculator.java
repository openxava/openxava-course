package com.yourcompany.invoicing.calculators;

import jakarta.persistence.*;
import org.openxava.calculators.*;
import org.openxava.jpa.*;
import lombok.*;

public class NextNumberForYearCalculator implements ICalculator { // A calculator must implement ICalculator

    @Getter @Setter // To be publicly accessible
    int year; // This value will be injected before calculating

    public Object calculate() throws Exception {
        Query query = XPersistence.getManager().createQuery(
                "select max(i.number) from " +
                        "CommercialDocument i " + // CommercialDocument instead of Invoice
                        "where i.year = :year");
        query.setParameter("year", year);
        Integer lastNumber = (Integer) query.getSingleResult();
        return lastNumber == null?1:lastNumber + 1;
    }

}
