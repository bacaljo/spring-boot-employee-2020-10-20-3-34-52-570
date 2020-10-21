package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CompanyServiceTest {

    private static final int WANTED_NUMBER_OF_INVOCATIONS = 1;

    @Test
    public void should_return_all_companies_when_get_all() {
        //given
        CompanyRepository repository = mock(CompanyRepository.class);
        when(repository.findAll()).thenReturn(asList(new Company(), new Company()));
        CompanyService service = new CompanyService(repository);
        //when
        List<Company> actual = service.getAll();
        //then
        verify(repository, times(WANTED_NUMBER_OF_INVOCATIONS)).findAll();
        assertEquals(2, actual.size());
    }
}