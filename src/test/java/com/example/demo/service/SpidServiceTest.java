package com.example.demo.service;

import com.example.demo.SpidApplication;
import com.example.demo.model.Spid;
import com.example.demo.utils.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {SpidApplication.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpidServiceTest {

    @Mock
    SpidService spidService;

    @BeforeAll
    public void setup() {
        //testing changing the status of a SPID
        Spid spid = new Spid();
        spid.setId(1);
        spid.setStatus(Status.READY_FOR_REVIEW);

        when(spidService.changeStatus(spid)).thenReturn(spid);
    }

    //testing databaase retrival of SPIDs
    @Test
    public void testDatabaseRetrievalForSpids() {
        Spid spid = new Spid();
        spid.setId(1);
        spid.setStatus(Status.READY_FOR_REVIEW);
        assertEquals(spid, spidService.changeStatus(spid));
    }

}