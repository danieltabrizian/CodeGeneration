package io.swagger.model.Entity;

import io.swagger.enums.Roles;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue
    private UUID uuid;
    private Integer pinCode;
    protected Roles role;
    protected String username;
    private String name;
    private String email;
    private String password;
    private Long transactionLimit;
    private long dayLimit;
}
