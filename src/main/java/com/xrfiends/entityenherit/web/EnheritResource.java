package com.xrfiends.entityenherit.web;

import com.xrfiends.entityenherit.dto.BaseDTO;
import com.xrfiends.entityenherit.dto.ReservationDTO;
import com.xrfiends.entityenherit.dto.RoomDTO;
import com.xrfiends.entityenherit.dto.SeatDTO;
import com.xrfiends.entityenherit.mapper.BaseMapper;
import com.xrfiends.entityenherit.mapper.ReservationMapper;
import com.xrfiends.entityenherit.mapper.RoomMapper;
import com.xrfiends.entityenherit.mapper.SeatMapper;
import com.xrfiends.entityenherit.repository.BaseRepository;
import com.xrfiends.entityenherit.repository.ReservationRepository;
import com.xrfiends.entityenherit.repository.RoomRepository;
import com.xrfiends.entityenherit.repository.SeatRepository;
import com.xrfiends.entityenherit.specification.BaseSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class EnheritResource {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final SeatRepository seatRepository;
    private final BaseRepository baseRepository;

    private final ReservationMapper reservationMapper;
    private final RoomMapper roomMapper;
    private final SeatMapper seatMapper;
    private final BaseMapper baseMapper;

    @PostMapping("/reservations")
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO r) {
        String id = reservationRepository.save(reservationMapper.toEntity(r)).getId();
        ReservationDTO result = reservationRepository.findById(id).map(reservationMapper::toDto).orElse(null);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/reservations/{id}")
    public ResponseEntity<ReservationDTO> findReservation(@PathVariable String id) {
        ReservationDTO result = reservationRepository.findById(id).map(reservationMapper::toDto).orElse(null);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/rooms")
    public ResponseEntity<RoomDTO> createReservation(@RequestBody RoomDTO r) {
        String id = roomRepository.save(roomMapper.toEntity(r)).getId();
        RoomDTO result = roomRepository.findById(id).map(roomMapper::toDto).orElse(null);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<RoomDTO> findRoom(@PathVariable String id) {
        RoomDTO result = roomRepository.findById(id).map(roomMapper::toDto).orElse(null);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/seats")
    public ResponseEntity<SeatDTO> createReservation(@RequestBody SeatDTO r) {
        String id = seatRepository.save(seatMapper.toEntity(r)).getId();
        SeatDTO result = seatRepository.findById(id).map(seatMapper::toDto).orElse(null);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/seats/{id}")
    public ResponseEntity<SeatDTO> findSeat(@PathVariable String id) {
        SeatDTO result = seatRepository.findById(id).map(seatMapper::toDto).orElse(null);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/bases")
    public ResponseEntity<List<BaseDTO>> findBase(String id, String name, String roomNo, String seatNo) {
        Map<BaseSpecification.SearchKey, Object> searchKeys = new HashMap<>();

        if(StringUtils.hasLength(id)) {
            searchKeys.put(BaseSpecification.SearchKey.ID, id);
        }
        if(StringUtils.hasLength(name)) {
            searchKeys.put(BaseSpecification.SearchKey.NAME, name);
        }
        if(StringUtils.hasLength(roomNo)) {
            searchKeys.put(BaseSpecification.SearchKey.ROOM_NO, roomNo);
        }
        if(StringUtils.hasLength(seatNo)) {
            searchKeys.put(BaseSpecification.SearchKey.SEAT_NO, seatNo);
        }

        //List result = baseRepository.findAll(BaseSpecification.searchWith(searchKeys));
        List<BaseDTO> result = baseRepository.findAll(BaseSpecification.searchWith(searchKeys)).stream().map(baseMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
