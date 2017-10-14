package com.zz.web310.service;

import com.zz.web310.entity.Moments;

public interface IMomentsService {
    Moments saveMoments(Moments moments);

    Moments getMoments(String userName);

    Boolean deleteMoments(String userName);
}
