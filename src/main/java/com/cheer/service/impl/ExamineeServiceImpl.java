package com.cheer.service.impl;

import com.cheer.dao.ExamineeMapper;
import com.cheer.domain.Examinee;
import com.cheer.service.ExamineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamineeServiceImpl implements ExamineeService {
    @Autowired
    private ExamineeMapper examineeMapper;
    @Override
    public Examinee findExaminee(int id) {
        Examinee examinee = examineeMapper.findExaminee(id);
        return examinee;
    }

    @Override
    public void updateExaminee(Examinee examinee) {
         examineeMapper.updateExaminee(examinee);
    }

    @Override
    public List<Examinee> getExaminee() {
        List<Examinee> examineeList = examineeMapper.getExaminee();
        return examineeList;
    }
}
