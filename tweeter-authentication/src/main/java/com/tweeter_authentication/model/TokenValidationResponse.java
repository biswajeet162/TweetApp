package com.tweeter_authentication.model;

import lombok.*;

import java.util.Date;

@Data
@Builder
@Setter
@Getter
@RequiredArgsConstructor
public class TokenValidationResponse {
    private boolean valid;
    private String handle;
    private String userName;
    private Long userId;
    private String token;
    private Date expiryDate;

    public TokenValidationResponse(boolean valid, String handle, String userName, Long userId, String token, Date expiryDate) {
        this.valid = valid;
        this.handle = handle;
        this.userName = userName;
        this.userId = userId;
        this.token = token;
        this.expiryDate = expiryDate;
    }
}
