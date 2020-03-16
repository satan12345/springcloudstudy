package com.able.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @param
 * @author jipeng
 * @date 2020-03-12 17:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "serial")
    private String serial;
    @Transient
    private int port;

}

