package com.example.springbootgraphqlpoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLConfig {

    private final PeopleDataFetcher peopleDataFetcher;
    private final AddressByIdDataFetcher addressByIdDataFetcher;

    public GraphQLConfig(PeopleDataFetcher peopleDataFetcher, AddressByIdDataFetcher addressByIdDataFetcher) {
        this.peopleDataFetcher = peopleDataFetcher;
        this.addressByIdDataFetcher = addressByIdDataFetcher;
    }

    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer() {
        // Attempt 1 - didn't work
        /*return (wiringBuilder) -> wiringBuilder
                .type("Query", typeWiring -> typeWiring.dataFetcher("people", peopleDataFetcher))
                .type("Address", typeWiring -> typeWiring.dataFetcher("address", addressByIdDataFetcher))
                .build();*/

        // Attempt 2 - didn't work
        return (wiringBuilder) -> wiringBuilder
                .type("Query", typeWiring -> typeWiring.dataFetcher("people", peopleDataFetcher)
                        .dataFetcher("address", addressByIdDataFetcher))
                .build();


        // Attempt 3 - didn't work
        /*return (wiringBuilder) -> wiringBuilder
                .type("Query", typeWiring -> typeWiring.dataFetcher("people", peopleDataFetcher)
                        .dataFetcher("address", addressByIdDataFetcher))
                .type("Address", typeWiring -> typeWiring.dataFetcher("address", addressByIdDataFetcher))
                .build();*/



    }
}
