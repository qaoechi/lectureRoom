package com.jumjari.zobiac.mapper;

import com.jumjari.zobiac.DTO.LogDTO;
import com.jumjari.zobiac.VO.Member;
import com.jumjari.zobiac.entity.ClassroomLog;
import com.jumjari.zobiac.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-30T00:13:54+0900",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class LogMapperImpl implements LogMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public LogDTO toLogDTO(ClassroomLog Log) {
        if ( Log == null ) {
            return null;
        }

        LogDTO logDTO = new LogDTO();

        logDTO.setId( Log.getId() );
        if ( Log.getClassroomId() != null ) {
            logDTO.setClassroomId( Log.getClassroomId().longValue() );
        }
        logDTO.setState( Log.getState() );
        logDTO.setBefore( Log.getBefore() );
        logDTO.setAfter( Log.getAfter() );
        logDTO.setTime( Log.getTime() );
        logDTO.setUser( userMapper.toMemberDTO( Log.getUser() ) );

        return logDTO;
    }

    @Override
    public ClassroomLog toLogEntity(LogDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClassroomLog classroomLog = new ClassroomLog();

        classroomLog.setId( dto.getId() );
        if ( dto.getClassroomId() != null ) {
            classroomLog.setClassroomId( dto.getClassroomId().intValue() );
        }
        classroomLog.setState( dto.getState() );
        classroomLog.setBefore( dto.getBefore() );
        classroomLog.setAfter( dto.getAfter() );
        classroomLog.setTime( dto.getTime() );
        classroomLog.setUser( memberToUser( dto.getUser() ) );

        return classroomLog;
    }

    protected User memberToUser(Member member) {
        if ( member == null ) {
            return null;
        }

        User user = new User();

        user.setId( member.getId() );
        user.setUsername( member.getUsername() );
        user.setPassword( member.getPassword() );

        return user;
    }
}
