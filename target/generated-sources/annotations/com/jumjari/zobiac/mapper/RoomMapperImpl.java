package com.jumjari.zobiac.mapper;

import com.jumjari.zobiac.DTO.RoomDTO;
import com.jumjari.zobiac.entity.Room;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-30T00:05:45+0900",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public RoomDTO toRoomDTO(Room Room) {
        if ( Room == null ) {
            return null;
        }

        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setRoomId( Room.getRoomId() );
        roomDTO.setBuilding( Room.getBuilding() );
        roomDTO.setNumber( Room.getNumber() );
        roomDTO.setFloor( Room.getFloor() );

        return roomDTO;
    }

    @Override
    public Room toRoomEntity(RoomDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Room room = new Room();

        room.setRoomId( dto.getRoomId() );
        room.setBuilding( dto.getBuilding() );
        room.setNumber( dto.getNumber() );
        room.setFloor( dto.getFloor() );

        return room;
    }
}
