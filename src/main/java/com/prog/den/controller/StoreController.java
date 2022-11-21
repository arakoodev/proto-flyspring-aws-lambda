package com.prog.den.controller;

import com.prog.den.model.Store;
import com.prog.den.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/stores")
@RestController
public class StoreController {

    private final StoreService storeService;

    @PostMapping("")
    public Store create(@RequestBody Store r) {
        return storeService.save(r);
    }

    @GetMapping("")
    public List<Store> list() {
        return storeService.list();
    }
}
