package com.educ_nc_spring_19.master_data.mapper;

import com.educ_nc_spring_19.educ_nc_spring_19_common.common.dto.SubdirectionDTO;
import com.educ_nc_spring_19.master_data.model.entity.Subdirection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SubdirectionMapper {
    SubdirectionDTO toSubdirectionDTO(Subdirection subdirection);
    List<SubdirectionDTO> toSubdirectionsDTO(List<Subdirection> subdirections);
    Subdirection toSubdirection(SubdirectionDTO subdirectionDTO);
}
