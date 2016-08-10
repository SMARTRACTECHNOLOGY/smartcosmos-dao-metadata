package net.smartcosmos.dto.metadata;

import org.junit.*;

import static org.junit.Assert.*;

public class PageInformationTest {

    @Test
    public void thatValuesAreInitializedWithBuilder() {

        PageInformation pageInformation = PageInformation.builder()
            .build();

        assertNotNull(pageInformation);

        assertNotNull(pageInformation.getNumber());
        assertEquals(0, pageInformation.getNumber());

        assertNotNull(pageInformation.getSize());
        assertEquals(0, pageInformation.getSize());

        assertNotNull(pageInformation.getTotalElements());
        assertEquals(0, pageInformation.getTotalElements());

        assertNotNull(pageInformation.getTotalPages());
        assertEquals(0, pageInformation.getTotalPages());
    }

    @Test
    public void thatValuesAreInitializedWithConstructor() {

        PageInformation pageInformation = new PageInformation();

        assertNotNull(pageInformation);

        assertNotNull(pageInformation.getNumber());
        assertEquals(0, pageInformation.getNumber());

        assertNotNull(pageInformation.getSize());
        assertEquals(0, pageInformation.getSize());

        assertNotNull(pageInformation.getTotalElements());
        assertEquals(0, pageInformation.getTotalElements());

        assertNotNull(pageInformation.getTotalPages());
        assertEquals(0, pageInformation.getTotalPages());
    }

    @Test
    public void thatValuesCanBeSetWithBuilder() {

        final int expectedSize = 10;
        final int expectedNumber = 1;
        final long expectedTotalElements = 123;
        final int expectedTotalPages = 13;

        PageInformation pageInformation = PageInformation.builder()
            .number(expectedNumber)
            .size(expectedSize)
            .totalElements(expectedTotalElements)
            .totalPages(expectedTotalPages)
            .build();

        assertNotNull(pageInformation);

        assertNotNull(pageInformation.getNumber());
        assertEquals(expectedNumber, pageInformation.getNumber());

        assertNotNull(pageInformation.getSize());
        assertEquals(expectedSize, pageInformation.getSize());

        assertNotNull(pageInformation.getTotalElements());
        assertEquals(expectedTotalElements, pageInformation.getTotalElements());

        assertNotNull(pageInformation.getTotalPages());
        assertEquals(expectedTotalPages, pageInformation.getTotalPages());
    }
}
