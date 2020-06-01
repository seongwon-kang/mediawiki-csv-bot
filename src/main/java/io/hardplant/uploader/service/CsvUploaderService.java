package io.hardplant.uploader.service;

import java.util.List;

public interface CsvUploaderService {

	List<CommuTable> upload(String id, String pwd, String csvContent);
    
}