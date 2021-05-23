package com.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author cm
 * @since 2021-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
//@TableName("chars")
public class CharsEntity implements Serializable {

    private static final long serialVersionUID=1L;

    //@TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer chanel;

    private Double number1;

    private Double number2;

    private Double number3;

    private Double number4;

    private Double number5;

    private Double number6;

    private Double number7;

    private Double number8;

    private Date time;


}
