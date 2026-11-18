package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.user.UserDto;
import za.co.mafeka.divorceelguia.dto.user.UserRequest;
import za.co.mafeka.divorceelguia.model.User;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserRequest req);
    List<UserDto> toDtoList(List<User> users);
}