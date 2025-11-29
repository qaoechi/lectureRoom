package com.jumjari.zobiac.mapper;

import com.jumjari.zobiac.DTO.BuildingDTO;
import com.jumjari.zobiac.entity.Building;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-30T00:04:32+0900",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class BuildingMapperImpl implements BuildingMapper {

    @Override
    public BuildingDTO toDTO(Building building) {
        if ( building == null ) {
            return null;
        }

        BuildingDTO buildingDTO = new BuildingDTO();

        buildingDTO.setId( building.getId() );
        buildingDTO.setKorFull( building.getKorFull() );
        buildingDTO.setKorShort( building.getKorShort() );
        buildingDTO.setEngShort( building.getEngShort() );
        buildingDTO.setLatitude( building.getLatitude() );
        buildingDTO.setLongitude( building.getLongitude() );

        return buildingDTO;
    }

    @Override
    public Building toEntity(BuildingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Building building = new Building();

        building.setId( dto.getId() );
        building.setKorFull( dto.getKorFull() );
        building.setKorShort( dto.getKorShort() );
        building.setEngShort( dto.getEngShort() );
        building.setLongitude( dto.getLongitude() );
        building.setLatitude( dto.getLatitude() );

        return building;
    }
}
