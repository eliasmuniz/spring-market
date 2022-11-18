package com.test.market.domain.repository;

import com.test.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

// es una interface porque es una espeficicación que quiero definir
// ESTO AYUDA A que se pueda saber que se puede realizar con Purchase Repository
public interface PurchaseRepository {
    List<Purchase> getAll();
  Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}

