package cn.lambochen.demo.mapstruct.generic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenlinghong
 * @date 2021-06-25 09:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPO {

    private Long id;

    private String name;

    private String gender;

}
