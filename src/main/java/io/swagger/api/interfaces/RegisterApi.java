/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.33).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.interfaces;

import io.swagger.model.Request.RegisterRequest;
import io.swagger.responses.auth.JwtTokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-26T09:18:21.534Z[GMT]")
@Validated
public interface RegisterApi {

    @Operation(summary = "add new user to the database", description = "check if all field or not empty and if the user already exists in the database. then create a new user", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Auth" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "registerd successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = JwtTokenResponse.class))),
    })
    @RequestMapping(value = "/register",
        produces = { "application/json" },
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity registerPost(@Parameter(in = ParameterIn.DEFAULT, description = "create a new user", required=true, schema=@Schema()) @Valid @RequestBody RegisterRequest body) throws IOException;

}

