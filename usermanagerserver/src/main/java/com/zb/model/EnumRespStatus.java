package com.zb.model;

import lombok.Getter;

@Getter
public enum EnumRespStatus {

    SUCCESS(1), ERROR(0);

    private int code;

    EnumRespStatus(int code) {
        this.code = code;
    }
}
