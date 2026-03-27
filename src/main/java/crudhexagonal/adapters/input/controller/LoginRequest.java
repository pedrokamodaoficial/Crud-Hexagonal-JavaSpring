package crudhexagonal.adapters.input.controller;

public record LoginRequest(
        String username,
        String password
) {
}
