package com.jobayed.orderservice.service;

import com.jobayed.orderservice.entity.ItemEntity;
import com.jobayed.orderservice.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    @Transactional
    @KafkaListener(groupId = "food_Group", topics = "food")
    public void addItem(ItemEntity item) {
        log.info("Received Food Item = {} from food service...", item);
        if (item != null) {
            itemRepository.save(item);
        }
    }

    @Override
    public Map<Long, ItemEntity> findItemsByIds(List<Long> ids) {
        List<ItemEntity> items = itemRepository.findAllById(ids);
        return items.stream()
                .collect(Collectors.toMap(ItemEntity::getId, item -> item));
    }
}
