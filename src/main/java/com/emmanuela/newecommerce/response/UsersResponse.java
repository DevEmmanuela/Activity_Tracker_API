package com.emmanuela.newecommerce.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UsersResponse {
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
}
