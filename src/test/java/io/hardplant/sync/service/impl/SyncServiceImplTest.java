package io.hardplant.sync.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.annotation.Resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import io.hardplant.sync.service.SyncService;

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class SyncServiceImplTest {

    @Resource
    private SyncService syncService;

    @BeforeEach
    public void setup(){

    }
        
    @Test
    public void test() {
        assertNotNull(syncService);
    }
}
    