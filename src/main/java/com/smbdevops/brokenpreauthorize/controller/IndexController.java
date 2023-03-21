package com.smbdevops.brokenpreauthorize.controller;

import com.smbdevops.brokenpreauthorize.entity.PrincipalEntity;
import com.smbdevops.brokenpreauthorize.repository.PrincipalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    final PrincipalsRepository repository;

    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    public String indexAction(final Model model) {
        final PrincipalEntity usr = this.repository.findByUsername("exists").orElseGet(() -> this.repository.save(PrincipalEntity.builder()
                .username("exists")
                .profileDescription("in the database").build()));

        model.addAttribute("usr", usr);
        return "index";
    }
}
