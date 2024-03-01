package com.skbit.userservice.entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter
@ToString
@Setter
public class User {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message="name is required")
	private String name;
	@Email
	private String email;
	
	private String about;
	
	@NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Mobile number should be valid")
    private String mobileNumber;
	@NotBlank(message="password is required")
	private String password;

}
