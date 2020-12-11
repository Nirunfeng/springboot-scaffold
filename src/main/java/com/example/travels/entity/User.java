package com.example.travels.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Ni RunF
 * @Date: 2020/12/8 23:18
 * @Version：1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private String id;
    private String username;
    private String password;
    private String email;

}
