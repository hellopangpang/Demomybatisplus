package com.jia.demo.generator.entity;

import com.jia.demo.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiamengjie
 * @since 2019-02-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Fileinfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String filename;

    private String path;


}
