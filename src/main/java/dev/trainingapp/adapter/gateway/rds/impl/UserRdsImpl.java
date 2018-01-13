package dev.trainingapp.adapter.gateway.rds.impl;

import dev.trainingapp.usecase.gateway.rds.user.UserRdsGateway;
import dev.trainingapp.usecase.gateway.rds.user.UserRdsGatewayCtm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserRdsImpl implements UserRdsGatewayCtm {
    private final EntityManager em;
    private final UserRdsGateway userRdsGateway;

}


