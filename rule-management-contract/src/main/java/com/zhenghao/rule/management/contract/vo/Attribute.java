package com.zhenghao.rule.management.contract.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attribute {

    private Long id;

    private String name;

    private String dataType;
}
