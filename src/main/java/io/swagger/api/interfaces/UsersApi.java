/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.33).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.interfaces;

import io.swagger.model.Request.UserRequest;
import io.swagger.responses.user.UserDeletedResponse;
import io.swagger.responses.user.UserListResponse;
import io.swagger.responses.user.UserSingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-26T09:18:21.534Z[GMT]")
@Validated
public interface UsersApi {

    @Operation(summary = "", description = "Returns a list of users", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Users" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "The list of users is returned from the database.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserRequest.class)))),
    })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserListResponse> usersGet(@Parameter(in = ParameterIn.QUERY, description = "Limits the number of items on a page" ,schema=@Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit, @Parameter(in = ParameterIn.QUERY, description = "Specifies the page number of the artists to be displayed" ,schema=@Schema()) @Valid @RequestParam(value = "offset", required = false) Integer offset) throws IOException;


    @Operation(summary = "", description = "delete user data", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Users" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "deletes all the data of the user", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
    })
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<UserDeletedResponse> usersIdDelete(@Parameter(in = ParameterIn.PATH, description = "Numeric ID of the user to get", required=true, schema=@Schema()) @PathVariable("id") String id) throws IOException;


    @Operation(summary = "", description = "gets a single user data", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Users" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "return user data after submitting an existing id", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserRequest.class))),
    })
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserSingleResponse> usersIdGet(@Parameter(in = ParameterIn.PATH, description = "Numeric ID of the user", required=true, schema=@Schema()) @PathVariable("id") String id) throws IOException;


    @Operation(summary = "", description = "Updates user data", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Users" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "updates all the data of the user", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserRequest.class)))),
    })
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<UserSingleResponse> usersIdPut(@Parameter(in = ParameterIn.PATH, description = "Numeric ID of the user to get", required=true, schema=@Schema()) @PathVariable("id") String id, @RequestBody UserRequest body) throws IOException;


    @Operation(summary = "", description = "creates a new users", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Users" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "creates a new user based on the fields of the user after checking the inputand the permissions", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserRequest.class)))),
    })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<UserSingleResponse> usersPost(@RequestBody UserRequest body) throws IOException;

    @Operation(summary = "", description = "All users with no accounts", security = {
            @SecurityRequirement(name = "bearerAuth")    }, tags={ "Users" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "creates a new user based on the fields of the user after checking the inputand the permissions", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserRequest.class)))),
    })
    @RequestMapping(value = "/users/accounts",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<UserListResponse> usersGetAllUserWithNoAccount(@Parameter(in = ParameterIn.QUERY, description = "Limits the number of items on a page" ,schema=@Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit, @Parameter(in = ParameterIn.QUERY, description = "Specifies the page number of the artists to be displayed" ,schema=@Schema()) @Valid @RequestParam(value = "offset", required = false) Integer offset) throws IOException;

}

