package com.hill.mall.dao.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 应用空间信息
 *
 * @Author huleilei9
 * @Date 2022/10/29
 **/
@Data
@Table(name = "application_space_info")
public class ApplicationSpaceInfo {

    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC",strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * appCode
     */
    @Column(name = "app_code")
    private String appCode;

    /**
     * appName
     */
    @Column(name = "app_name")
    private String appName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 状态：有效、无效
     */
    private Integer status;
}
