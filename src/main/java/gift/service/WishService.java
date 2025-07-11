package gift.service;

import gift.entity.Wish;
import gift.repository.H2WishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishService {

    private final H2WishRepository wishRepository;

    public WishService(H2WishRepository wishRepository) {
        this.wishRepository = wishRepository;
    }

    public List<Wish> getAllWishes(Long userId) {
        return wishRepository.findAllByUserId(userId);
    }

    public Optional<Wish> getWishById(Long id) {
        return wishRepository.findById(id);
    }

//    public Optional<Wish> createWish() {
//
//    }
//
//    public Optional<Wish> updateWish() {
//
//    }

    public boolean deleteWish(Long id) {
        return wishRepository.deleteById(id);
    }
}
