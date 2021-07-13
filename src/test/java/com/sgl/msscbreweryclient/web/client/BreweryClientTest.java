package com.sgl.msscbreweryclient.web.client;

import com.sgl.msscbreweryclient.web.model.BeerDto;
import com.sgl.msscbreweryclient.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void testGetBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void testSaveNewBeer(){
        URI uri = breweryClient.saveNewBeer(BeerDto.builder().beerName("Budwiser").build());
        assertNotNull(uri);
        // We have added annotation @Slf4j so can use the log object
        log.info(uri.toString());
    }

    @Test
    void testUpdateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("Kingfisher").build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    public void testGetCustomerById(){
        CustomerDto customerDto = breweryClient.getCusomerById(UUID.randomUUID());
        Assertions.assertNotNull(customerDto);
    }

    @Test
    public void testSaveNewCustomer(){
        CustomerDto customerDto = CustomerDto.builder().name("Santosh").build();
        URI uri = breweryClient.saveNewCustomer(customerDto);
        Assertions.assertNotNull(uri);
        log.info(uri.toString());
    }

    @Test
    public void testUpdateCustomer(){
        breweryClient.updateCustomer(UUID.randomUUID(), CustomerDto.builder().id(UUID.randomUUID()).name("Santosh").build());
    }

    @Test
    public void testDeleteCustomer(){
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}