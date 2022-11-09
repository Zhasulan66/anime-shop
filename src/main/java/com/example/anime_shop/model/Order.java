package com.example.anime_shop.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @NotEmpty
    @Column(nullable = false)
    private String address;

    @NotEmpty
    @Column(nullable = false)
    private String postcode;

    private String city;

    @Column(nullable = false)
    @NotEmpty
    @Email(message = "{errors.invalid_email")
    private String email;

    @NotEmpty
    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Double total_price;

    @NotEmpty
    @Column(nullable = false)
    private String add_info;

    @OneToMany
    private List<Product> products;

}
