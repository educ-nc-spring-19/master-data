package com.educ_nc_spring_19.master_data.mapper;

import com.educ_nc_spring_19.educ_nc_spring_19_common.common.dto.MentorDTO;
import com.educ_nc_spring_19.master_data.model.entity.Mentor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MentorMapper {
    MentorDTO toMentorDTO(Mentor mentor);
    List<MentorDTO> toMentorsDTO(List<Mentor> mentors);
    Mentor toMentor(MentorDTO mentorDTO);
}
