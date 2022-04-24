package com.example.springbootgraphqlpoc;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class AddressByIdDataFetcher implements DataFetcher<Address> {
    @Override
    public Address get(DataFetchingEnvironment environment) throws Exception {
        System.out.println(environment);
        Address address = new Address();
        address.setStreet("My Street");
        address.setPostcode("AA11 1AA");
        return address;
    }
}
