package com.wizian.admission.wizianb.service;

import com.wizian.admission.wizianb.domain.ApplicationIntroduce;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ApplicationIntroService {

        List<ApplicationIntroduce> findItem(String rcrtNo);

}
