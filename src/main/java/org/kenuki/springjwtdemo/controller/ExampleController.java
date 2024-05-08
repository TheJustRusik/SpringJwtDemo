package org.kenuki.springjwtdemo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/example")
@AllArgsConstructor
public class ExampleController {
    @GetMapping("/for_all")
    ResponseEntity<String> for_all() {
        return ResponseEntity.ok("This data for all");
    }
    @GetMapping("/for_user")
    @PreAuthorize("hasRole('USER')")
    ResponseEntity<String> for_user() {
        return ResponseEntity.ok("This data for users");
    }

    @GetMapping("/for_admin")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<String> for_admin() {
        return ResponseEntity.ok("This data for admins");
    }

    @GetMapping("/for_admin")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    ResponseEntity<String> for_user_and_admin() {
        return ResponseEntity.ok("This data for admins and users");
    }
}
