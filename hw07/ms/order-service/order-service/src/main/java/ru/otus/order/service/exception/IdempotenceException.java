package ru.otus.order.service.exception;

import lombok.Getter;
import ru.otus.common.error.ShopException;

@Getter
public class IdempotenceException extends ShopException {

    public IdempotenceException( String message) {
        super("order.status.transition.not.allowed", "Изменение статуса заказа недоступно", "403"); //todo check
    }
}
