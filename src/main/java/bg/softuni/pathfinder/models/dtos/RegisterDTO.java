package bg.softuni.pathfinder.models.dtos;

import bg.softuni.pathfinder.validations.FieldsMatch;
import bg.softuni.pathfinder.validations.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@FieldsMatch(first = "password", second = "confirmPassword", message = "Passwords do not match")
public class RegisterDTO {
    @NotBlank
    @Size(min = 2)
    private String username;

    @NotBlank
    @Size(min = 2)
    private String fullName;

    @NotBlank(message = "the field must not be empty")
    @Email(message = "Email format is not valid")
    @UniqueUserEmail(message = "The email is already registered.")
    private String email;

    private int age;

    @NotBlank
    @Size(min = 2)
    private String password;

    @NotBlank
    @Size(min = 2)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public RegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public RegisterDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getAge() {
        return age;
    }

    public RegisterDTO setAge(int age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
