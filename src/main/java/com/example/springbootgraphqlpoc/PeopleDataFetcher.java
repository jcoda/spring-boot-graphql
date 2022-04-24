package com.example.springbootgraphqlpoc;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PeopleDataFetcher implements DataFetcher<List<Person>> {


    @Override
    public List<Person> get(DataFetchingEnvironment environment) {
        Person person1 = new Person();
        person1.setName("Fred Bloggs");
        return Arrays.asList(person1);
    }
}
