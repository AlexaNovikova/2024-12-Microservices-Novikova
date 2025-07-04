package ru.otus.notification.service.service;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import ru.otus.lib.kafka.model.SendNotificationModel;
import ru.otus.notification.service.model.Notification;
import ru.otus.notification.service.model.NotificationListDto;
import ru.otus.notification.service.repository.NotificationRepository;

import java.time.OffsetDateTime;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final NotificationRepository repository;

    public void send(SendNotificationModel model) {
        var notification = Notification.builder()
                .sendTo(model.getEmail())
                .subject(model.getSubject())
                .message(model.getMessage())
                .createdAt(OffsetDateTime.now())
                .build();
        repository.save(notification);
    }

    public NotificationListDto getList(String login) {
        var list = repository.findAllBySendToOrderByCreatedAt(login);
        var items = list.stream()
                .map(i -> new NotificationListDto.Item(i.getId(), i.getSendTo(), i.getSubject(), i.getMessage()))
                .collect(Collectors.toList());
        return new NotificationListDto(items);
    }

}