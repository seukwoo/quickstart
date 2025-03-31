package com.helloworld.quickstart.service;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.entity.ItemEntity;
import com.helloworld.quickstart.mapper.QuickMapper;
import com.helloworld.quickstart.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class QuickService {

    @Autowired
    private QuickMapper quickMapper;

    @Autowired
    private ItemRepository itemRepository;

    public boolean registerItem(ItemDto itemDto) {
//        try {
//            HashMap<String, Object> paramMap = new HashMap<>();
//            paramMap.put("id", itemDto.getId());
//            paramMap.put("name", itemDto.getName());
//
//            quickMapper.registerItem(paramMap);
//            log.info("Item inserted successfully: {}", itemDto);
//            return true;
//        } catch (Exception e) {
//            log.error("Error while inserting item: {}", e.getMessage(), e);
//            return false;
//        }
        try {
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setId(itemDto.getId());
            itemEntity.setName(itemDto.getName());

            itemRepository.save(itemEntity);
            log.info("Item inserted successfully: {}", itemDto);
            return true;
        } catch (Exception e) {
            log.error("Error while inserting item: {}", e.getMessage(), e);
            return false;
        }

        
    }
    public ItemDto getItemById(String id){
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", id);
//
//        HashMap<String, Object> res = quickMapper.findById(paramMap);
//
//        ItemDto itemDto = new ItemDto();
//        itemDto.setId((String) res.get("ID"));
//        itemDto.setName((String) res.get("NAME"));
//
//        return itemDto;

        try {
            ItemEntity itemEntity = itemRepository.findById(id).orElse(null);
            if (itemEntity == null) {
                log.warn("Item not found with id: {}", id);
                return null;
            }

            ItemDto itemDto = new ItemDto();
            itemDto.setId(itemEntity.getId());
            itemDto.setName(itemEntity.getName());

            return itemDto;
        } catch (Exception e) {
            log.error("Error while fetching item: {}", e.getMessage(), e);
            return null;
        }

            }
    }
