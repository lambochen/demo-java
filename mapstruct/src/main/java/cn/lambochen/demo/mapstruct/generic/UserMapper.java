package cn.lambochen.demo.mapstruct.generic;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author chenlinghong
 * @date 2021-06-25 09:39
 */
@Mapper
public interface UserMapper {

    UserMapper instance = Mappers.getMapper(UserMapper.class);

//    @Mapping(source = "gender", target = "gender")
    User to(UserPO po);

    UserPO toPo(User user);

}
