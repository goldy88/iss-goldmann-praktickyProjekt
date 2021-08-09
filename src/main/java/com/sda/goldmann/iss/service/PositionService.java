package com.sda.goldmann.iss.service;


import com.sda.goldmann.iss.util.SpeedCalculator;
import com.sda.goldmann.iss.dto.Position;
import com.sda.goldmann.iss.model.IssSpeed;
import com.sda.goldmann.iss.model.PositionMeasure;

import java.util.Set;
import org.hibernate.Transaction;

public class PositionService {

    private final HibernateService hibernateService;

    public PositionService(HibernateService hibernateService) {
        this.hibernateService = hibernateService;
    }

    public Position getById(Long id) {
        return hibernateService.getSession().get(Position.class, id);
    }

    public Position create(Position position) {
        var transaction = hibernateService.getSession().beginTransaction();

        hibernateService.getSession().persist(
                createPositionMeasure(position)
        );

        transaction.commit();

        return position;
    }

    public IssSpeed storeSpeed(Position issPosition1, Position issPosition2) {
        Transaction transaction = hibernateService.getSession().beginTransaction();

        var issSpeed = new IssSpeed();
        double distance = SpeedCalculator.distance(
                issPosition1.getCords().getLatitude(),
                issPosition1.getCords().getLongitude(),
                issPosition2.getCords().getLatitude(),
                issPosition2.getCords().getLongitude(),
                "K"
        );
        double speed = SpeedCalculator.speed(
                distance,
                issPosition2.getTimestamp() - issPosition1.getTimestamp()
        );
        issSpeed.setSpeed((float) speed);
        issSpeed.setPositions(Set.of(
                createPositionMeasure(issPosition1),
                createPositionMeasure(issPosition2)
        ));

        hibernateService.getSession().persist(issSpeed);

        transaction.commit();

        return issSpeed;
    }

    private PositionMeasure createPositionMeasure(Position position) {
        var positionMeasure = new PositionMeasure();

        positionMeasure.setLatitude(position.getCords().getLatitude());
        positionMeasure.setLongitude(position.getCords().getLongitude());
        positionMeasure.setMeasureTimeInSec(position.getTimestamp());

        return positionMeasure;
    }
}
