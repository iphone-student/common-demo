package com.zb.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@JsonInclude(Include.NON_NULL)
public final class ServiceResponse<R> {

    @JsonProperty("code")
    private int errorCode;

    @JsonProperty("message")
    private String errorMsg;

    @JsonProperty("result")
    private R result;

    public static <V> ServiceResponse<V> ok() {
        return ServiceResponse.<V>builder()
                .errorCode(EnumRespStatus.SUCCESS.getCode())
                .build();
    }

    public static <V> ServiceResponse<V> ok(V value) {
        return ServiceResponse.<V>builder()
                .errorCode(EnumRespStatus.SUCCESS.getCode())
                .result(value)
                .build();
    }

    public static <V> ServiceResponse<V> error() {
        return ServiceResponse.<V>builder()
                .errorCode(EnumRespStatus.ERROR.getCode())
                .build();
    }

    public static <V> ServiceResponse<V> error(int code) {
        return ServiceResponse.<V>builder()
                .errorCode(code)
                .build();
    }

    public static <V> ServiceResponse<V> error(String message) {
        return ServiceResponse.<V>builder()
                .errorCode(EnumRespStatus.ERROR.getCode())
                .errorMsg(message)
                .build();
    }

    public static <V> ServiceResponse<V> error(int code, String message) {
        return ServiceResponse.<V>builder()
                .errorCode(code)
                .errorMsg(message)
                .build();
    }
}
