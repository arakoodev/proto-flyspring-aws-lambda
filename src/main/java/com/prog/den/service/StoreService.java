package com.prog.den.service;

import com.prog.den.model.Store;
import com.prog.den.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public Store save(Store e) {
        return storeRepository.save(e);
    }

    public List<Store> list() {
        return storeRepository.findAll();
    }
}
