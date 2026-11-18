package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.appointment.AppointmentDto;
import za.co.mafeka.divorceelguia.dto.appointment.AppointmentRequest;
import za.co.mafeka.divorceelguia.model.Appointment;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppointmentMapper {
    @Mapping(source = "office.id", target = "officeId")
    @Mapping(source = "office.name", target = "officeName")
    @Mapping(source = "seeker.id", target = "seekerId")
    AppointmentDto toDto(Appointment entity);

    @Mapping(source = "appointments.officeId", target = "office.id")
    @Mapping(source = "appointments.seekerId", target = "seeker.id")
    Appointment toEntity(AppointmentRequest req);

    List<AppointmentDto> toDtoList(List<Appointment> list);
}