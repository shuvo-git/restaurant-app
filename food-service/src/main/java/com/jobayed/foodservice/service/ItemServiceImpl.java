package com.jobayed.foodservice.service;

import com.jobayed.foodservice.controller.model.request.ItemRequest;
import com.jobayed.foodservice.controller.model.response.ItemResponse;
import com.jobayed.foodservice.entity.ItemEntity;
import com.jobayed.foodservice.repository.ItemRepository;
import com.jobayed.foodservice.utility.Constants;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final KafkaProducerService kafkaProducerService;


    @Override
    @Transactional
    public ItemResponse.Add addItem(ItemRequest.Add request) {
        ItemEntity item =  ItemEntity.builder()
                .name(request.getName())
                .price(request.getPrice())
                .status(request.getStatus())
                .build();
        item = itemRepository.save(item);

        String key = "food_";
        kafkaProducerService.sendToKafka(
                "food",
                key,
                item
        );

        return ItemResponse.Add.builder()
                .message("Item successfully created!")
                .build();
    }

    private void publishToTopic(ItemEntity entity) {
        kafkaProducerService.sendToKafka(
                Constants.Topic.FOOD,
                Constants.Topic.Key.FOOD,
                entity
        );
    }
}
