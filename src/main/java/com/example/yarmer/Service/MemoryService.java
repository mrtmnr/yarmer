package com.example.yarmer.Service;

import com.example.yarmer.Model.Memory;

import java.util.List;

public interface MemoryService {

    List<Memory> getPaginatedMemories(int page, int size);
    int getTotalPages(int size);
}
