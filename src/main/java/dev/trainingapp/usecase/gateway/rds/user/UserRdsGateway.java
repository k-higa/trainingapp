package dev.trainingapp.usecase.gateway.rds.user;

import dev.trainingapp.adapter.gateway.rds.entity.UserRds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRdsGateway extends JpaRepository<UserRds, String>, UserRdsGatewayCtm {
}
