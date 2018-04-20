package org.timo.sfnjooqdemo;

import org.jooq.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.timo.sfnjooqdemo.data.tables.Person.*;

@RestController
public class RestBoundary {

    @Autowired
    private DSLContext dslContext;

    @GetMapping(value = "/persons")
    public Map<Integer, String> getPersons() {
        return dslContext.select(PERSON.ID, PERSON.NAME)
                .from(PERSON)
                .orderBy(PERSON.NAME.asc())
                .fetch().intoMap(PERSON.ID, PERSON.NAME);

    }
}
