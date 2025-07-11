package gift.repository;

import gift.entity.Wish;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class H2WishRepository {

    private final JdbcClient jdbcClient;

    public H2WishRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Wish> findAllByUserId(Long userId) {
        return jdbcClient.sql("select * from wishes where userId = :userId")
                         .param("userId", userId)
                         .query(Wish.class)
                         .list();
    }

    public Optional<Wish> findById(Long id) {
        return jdbcClient.sql("select * from wishes where id = :id")
                         .param("id", id)
                         .query(Wish.class)
                         .optional();
    }

    public Optional<Wish> save(Wish wish) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        boolean success = jdbcClient.sql("insert into wishes (userId, productId, quantity) values (:userId, :productId, :quantity)")
                                    .param("userId", wish.getUserId())
                                    .param("productId", wish.getProductId())
                                    .param("quantity", wish.getQuantity())
                                    .update(keyHolder) != 0;

        wish.setId(keyHolder.getKey().longValue());
        return (success ? Optional.of(wish) : Optional.empty());
    }

    public Optional<Wish> update(Wish wish) {
        boolean success = jdbcClient.sql("update wishes set quantity = :quantity where id = :id")
                                    .param("id", wish.getId())
                                    .param("quantity", wish.getQuantity())
                                    .update() != 0;

        return (success ? Optional.of(wish) : Optional.empty());
    }

    public boolean deleteById(Long id) {
        return jdbcClient.sql("delete from wishes where id = :id")
                         .param("id", id)
                         .update() != 0;
    }
}
