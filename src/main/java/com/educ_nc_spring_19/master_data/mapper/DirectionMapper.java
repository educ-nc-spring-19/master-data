package com.educ_nc_spring_19.master_data.mapper;

import com.educ_nc_spring_19.educ_nc_spring_19_common.common.dto.DirectionDTO;
import com.educ_nc_spring_19.master_data.model.entity.Direction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DirectionMapper {
    DirectionDTO toDirectionDTO(Direction direction);
    List<DirectionDTO> toDirectionsDTO(List<Direction> directions);
    Direction toDirection(DirectionDTO directionDTO);
}
