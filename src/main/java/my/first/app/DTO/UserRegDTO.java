package my.first.app.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegDTO {
    
    @NotEmpty(message = "Name is required")
    private String name;
    
    @NotEmpty(message = "Username is required")
    @Size(min = 4, message = "Username must be at least 4 characters")
    private String username;
    
    @NotEmpty(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    
    @NotEmpty(message = "Phone is required")
    private String phone;
    
    @NotEmpty(message = "Address is required")
    private String address;
}


