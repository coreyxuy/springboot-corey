package com.itcorey.controller.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @Classname UserReq
 * @Description TODO
 * @Date 2020/6/4 19:51
 * @Created by corey
 */
@ApiModel(description = "用户实体类")
@Data
public class UserReqDto {

    @ApiModelProperty(value = "密码")
    @NotEmpty(message="密码不能为空")
    @Length(min=6,message="密码长度不能小于6位")
    private String password;

    @ApiModelProperty(value = "名字")
    @NotNull(message = "姓名不能为空！")
    private String name;

    @ApiModelProperty(value = "生日")
    @NotNull(message = "生日日期不能为空！")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ApiModelProperty(value = "性别（1：男 2：女）")
    private Integer sex;

    @ApiModelProperty(value = "电子邮件")
    @Email(message="请输入正确的邮箱")
    private String email;

    @ApiModelProperty(value = "电话")
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String phone;

}
