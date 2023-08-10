package com.example.javapractice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Junqi Chen
 * @time:2023/8/10
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    private int id;
    private String name;
}
