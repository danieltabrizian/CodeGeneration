package io.swagger.model.Request;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * Account
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-26T09:18:21.534Z[GMT]")


public class AccountRequest {
    @JsonProperty("iban")
    private String iban = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("user_id")
    private String userId = null;

    @JsonProperty("absoluteLimit")
    private Long absoluteLimit = null;

    /**
     * Get iban
     *
     * @return iban
     **/
    @Schema(example = "NL69INHO1234123412", required = false, description = "")

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public AccountRequest type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @Schema(required = false, description = "")

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AccountRequest userId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Get userId
     *
     * @return userId
     **/
    @Schema(required = false, description = "")

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AccountRequest absoluteLimit(Long absoluteLimit) {
        this.absoluteLimit = absoluteLimit;
        return this;
    }

    /**
     * Get absoluteLimit
     *
     * @return absoluteLimit
     **/
    @Schema(description = "")

    public Long getAbsoluteLimit() {
        return absoluteLimit;
    }

    public void setAbsoluteLimit(Long absoluteLimit) {
        this.absoluteLimit = absoluteLimit;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        System.out.println("in de equals account swagger");
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountRequest accountRequest = (AccountRequest) o;
        return Objects.equals(this.iban, accountRequest.iban) &&
                Objects.equals(this.type, accountRequest.type) &&
                Objects.equals(this.userId, accountRequest.userId) &&
                Objects.equals(this.absoluteLimit, accountRequest.absoluteLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, type, userId, absoluteLimit);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Account {\n");

        sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    absoluteLimit: ").append(toIndentedString(absoluteLimit)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
