package io.hardplant.uploader.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hardplant.uploader.service.CommuTable;
import io.hardplant.uploader.service.CsvUploaderService;

@Service
public class CsvUploaderServiceImpl implements CsvUploaderService{

    private final String[] commuTableRow = new String[]{"id", "name", "text", "trans"};
    
    @Autowired
    private CsvDAO csvDao;

    @Override
    public List<CommuTable> upload(String id, String pwd, String csvPath) {
        return csvDao.readTableWithRowname(commuTableRow, csvPath);
    }
}