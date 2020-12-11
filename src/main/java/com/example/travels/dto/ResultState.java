package com.example.travels.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Author: Ni RunF
 * @Date: 2020/12/9 11:10
 * @Version：1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResultState {
    private boolean state=true;
    private String msg;
}
