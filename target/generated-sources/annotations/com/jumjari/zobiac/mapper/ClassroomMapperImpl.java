package com.jumjari.zobiac.mapper;

import com.jumjari.zobiac.DTO.ClassroomDTO;
import com.jumjari.zobiac.entity.Classroom;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-29T23:55:05+0900",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class ClassroomMapperImpl implements ClassroomMapper {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public ClassroomDTO toClassroomDTO(Classroom classroom) {
        if ( classroom == null ) {
            return null;
        }

        ClassroomDTO classroomDTO = new ClassroomDTO();

        classroomDTO.setId( classroom.getId() );
        classroomDTO.setActived( classroom.isActived() );
        classroomDTO.setRoom( roomMapper.toRoomDTO( classroom.getRoom() ) );
        classroomDTO.setName( classroom.getName() );
        classroomDTO.setDirection( classroom.getDirection() );
        classroomDTO.setType( classroom.getType() );
        classroomDTO.setCount( classroom.getCount() );
        classroomDTO.setParent( toClassroomDTO( classroom.getParent() ) );
        classroomDTO.setMemo( classroom.getMemo() );

        return classroomDTO;
    }

    @Override
    public Classroom toClassroomEntity(ClassroomDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Classroom classroom = new Classroom();

        classroom.setId( dto.getId() );
        classroom.setActived( dto.isActived() );
        classroom.setRoom( roomMapper.toRoomEntity( dto.getRoom() ) );
        classroom.setName( dto.getName() );
        classroom.setDirection( dto.getDirection() );
        classroom.setType( dto.getType() );
        classroom.setCount( dto.getCount() );
        classroom.setParent( toClassroomEntity( dto.getParent() ) );
        classroom.setMemo( dto.getMemo() );

        return classroom;
    }
}
