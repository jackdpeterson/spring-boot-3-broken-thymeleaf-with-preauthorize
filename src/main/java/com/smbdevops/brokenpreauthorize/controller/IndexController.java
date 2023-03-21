package com.smbdevops.brokenpreauthorize.controller;

import com.smbdevops.brokenpreauthorize.entity.PrincipalEntity;
import com.smbdevops.brokenpreauthorize.repository.PrincipalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class IndexController {

    final PrincipalsRepository repository;

    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    public Mono<String> indexAction(final Model model) {
        return this.repository.findByUsername("exists")
                .doOnNext(usr -> {
                    model.addAttribute("usr", usr);
                })
                .switchIfEmpty(this.repository.save(PrincipalEntity.builder()
                        .username("exists")
                        .profileDescription("in the database").build()))
                .thenReturn("index");
    }
}
