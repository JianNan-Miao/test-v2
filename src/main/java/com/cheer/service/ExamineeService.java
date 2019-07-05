package com.cheer.service;

import com.cheer.domain.Examinee;

import java.util.List;

public interface ExamineeService {
    public Examinee findExaminee(int id);

    public void updateExaminee(Examinee examinee);

    public List<Examinee> getExaminee();
}
