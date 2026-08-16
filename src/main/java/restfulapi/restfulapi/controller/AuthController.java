package restfulapi.restfulapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restfulapi.restfulapi.dto.ApiResponse;
import restfulapi.restfulapi.dto.AuthResponse;
import restfulapi.restfulapi.dto.LoginRequest;
import restfulapi.restfulapi.dto.RegisterRequest;
import restfulapi.restfulapi.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ApiResponse<String> register(@Valid @RequestBody RegisterRequest request) {
        String message = authService.register(request);
        return ApiResponse.<String>builder()
                .code(200)
                .status("OK")
                .data(message)
                .build();
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ApiResponse.<AuthResponse>builder()
                .code(200)
                .status("OK")
                .data(response)
                .build();
    }
}
