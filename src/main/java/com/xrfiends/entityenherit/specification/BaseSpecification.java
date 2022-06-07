package com.xrfiends.entityenherit.specification;

import com.xrfiends.entityenherit.domain.Base;
import com.xrfiends.entityenherit.domain.Room;
import com.xrfiends.entityenherit.domain.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseSpecification {
    @Getter
    @AllArgsConstructor
    public enum SearchKey {
        ID("id"),
        NAME("name"),
        ROOM_NO("roomNo"),
        SEAT_NO("seatNo")
        ;

        private final String value;
    }

    public static Specification<Base> searchWith(Map<SearchKey, Object> searchKeyword) {
        return (Specification<Base>) ((root, query, builder) -> {
            List<Predicate> predicate = getPredicateWithKeywordBase(searchKeyword, root, builder, query);
            predicate.addAll(getPredicateWithKeywordRoom(searchKeyword, root, builder, query));
            predicate.addAll(getPredicateWithKeywordSeat(searchKeyword, root, builder, query));
            return builder.and(predicate.toArray(new Predicate[0]));
        });
    }

    private static List<Predicate> getPredicateWithKeywordBase(Map<SearchKey, Object> searchKeyword, Root<Base> root, CriteriaBuilder builder, CriteriaQuery<?> query) {
        List<Predicate> predicate = new ArrayList<>();

        for (SearchKey key : searchKeyword.keySet()) {
            switch (key) {
                case ID:
                    predicate.add(builder.equal(root.get(key.value), searchKeyword.get(key)));
                    break;
                case NAME:
                    predicate.add(builder.like(root.get(key.value), "%" + searchKeyword.get(key).toString() + "%"));
                    break;
                default:
                    break;
            }
        }

        return predicate;
    }

    private static List<Predicate> getPredicateWithKeywordRoom(Map<SearchKey, Object> searchKeyword, Root<Base> root, CriteriaBuilder builder, CriteriaQuery<?> query) {
        List<Predicate> predicate = new ArrayList<>();

        Root<Room> rootRoom = builder.treat(root, Room.class);

        for (SearchKey key : searchKeyword.keySet()) {
            switch (key) {
                case ROOM_NO:
                    predicate.add(builder.equal(rootRoom.get(key.value), searchKeyword.get(key)));
                    break;
                default:
                    break;
            }
        }

        return predicate;
    }

    private static List<Predicate> getPredicateWithKeywordSeat(Map<SearchKey, Object> searchKeyword, Root<Base> root, CriteriaBuilder builder, CriteriaQuery<?> query) {
        List<Predicate> predicate = new ArrayList<>();

        Root<Seat> rootSeat = builder.treat(root, Seat.class);

        for (SearchKey key : searchKeyword.keySet()) {
            switch (key) {
                case SEAT_NO:
                    predicate.add(builder.equal(rootSeat.get(key.value), searchKeyword.get(key)));
                    break;
                default:
                    break;
            }
        }

        return predicate;
    }
}
