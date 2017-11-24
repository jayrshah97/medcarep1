package com.medcare.service;

import java.util.HashMap;
import java.util.Map;

public interface PatientCountServiceI {
    public HashMap totalCount();

    Map<String, Object> opdPatients(Integer id);

    Map<String, Object> admitPatients(Integer id);
}
