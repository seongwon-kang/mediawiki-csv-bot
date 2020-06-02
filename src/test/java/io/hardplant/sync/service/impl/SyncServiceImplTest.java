package io.hardplant.sync.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import io.hardplant.cmmn.CommuTableTemplate;
import io.hardplant.sync.service.SyncService;

@SpringBootTest
@ContextConfiguration(classes = { TestConfig.class })
public class SyncServiceImplTest {

    @Resource
    private SyncService syncService;

    @BeforeEach
    public void setup() {

    }

    @Test
    public void getTemplateFromSheet() {
        assertNotNull(syncService);

        List<CommuTableTemplate> templates = syncService.getTemplateFromSheet("사쿠라기 마노");

        assertNotNull(templates);
    }
}
    