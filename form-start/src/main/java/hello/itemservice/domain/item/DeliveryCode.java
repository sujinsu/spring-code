package hello.itemservice.domain.item;

import lombok.Data;
import lombok.AllArgsConstructor;

/**
 * FAST : 빠른 배송
 * NORMAL : 일반 배송
 * SLOW : 느린 배송
 */
@Data
@AllArgsConstructor
public class DeliveryCode{

    private String code;
    private String displayName;
}