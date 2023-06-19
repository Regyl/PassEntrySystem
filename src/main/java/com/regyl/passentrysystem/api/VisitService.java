package com.regyl.passentrysystem.api;

import com.regyl.passentrysystem.model.VisitRecord;

import java.util.UUID;

public interface VisitService {

    VisitRecord captureVisit(UUID studentId);
}
